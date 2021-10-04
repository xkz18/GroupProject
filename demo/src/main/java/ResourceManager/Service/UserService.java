package ResourceManager.Service;

import ResourceManager.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User findById(Integer id);
    public Optional<User> findByUserName(String username);

    List<User> findAll();

    public User save(User user);

    public User create(User user);
    public User update(User user);

}
