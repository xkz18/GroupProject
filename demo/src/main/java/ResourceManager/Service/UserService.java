package ResourceManager.Service;

import ResourceManager.model.User;

import java.util.List;

public interface UserService {
    public User findById(Integer id);

    List<User> findAll();

    public User save(User user);

    public User create(User user);

}
