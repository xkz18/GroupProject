package ResourceManager.Service.Impl;

import ResourceManager.Service.UserService;
import ResourceManager.model.User;
import ResourceManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User save(User user){
        return repository.save(user);
    }

    @Override
    public User create(User user){
        user.setDateCreated(LocalDate.now());
        return repository.save(user);
    }
    @Override
    public User update(User user){
        user.setLastUpdated(LocalDate.now());
        return repository.save(user);
    }
    @Override
    public Optional<User> findByUserName(String username){
        User sample= new User();
        sample.setUsername(username);
        return repository.findOne(Example.of(sample));
    }
}
