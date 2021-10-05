package ResourceManager.Service;

import ResourceManager.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User findById(Integer id);

    public User loadUserByUsername(String s) throws UsernameNotFoundException;

    List<User> findAll();

    public User save(User user);

    public User create(User user);
    public User update(User user);

}
