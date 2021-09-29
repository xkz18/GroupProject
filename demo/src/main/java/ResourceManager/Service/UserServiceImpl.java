package ResourceManager.Service;

import ResourceManager.model.User;
import ResourceManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
}
