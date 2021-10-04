package ResourceManager.Controller;

import ResourceManager.Service.Impl.UserServiceImpl;
import ResourceManager.entity.User;
import ResourceManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository repository;

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping(value="/process_signup")
    public String processSignup(User user){
        if(repository.getUserByUsername(user.getUsername()) != null){
            return ("signup");
        }
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        repository.save(user);
        return ("login");
    }
}
