package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.dtos.UserRegisterDTO;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;

    private UserRepository userRepostiory;

    public UserRegistrationController(UserService userService, UserRepository userRepostiory) {
        this.userService = userService;
        this.userRepostiory = userRepostiory;
    }

//    public void registerAndLogin(UserRegisterDTO registerDTO) {
//        UserEntity newUser = userMapper.userDtoToUserEntity(registerDTO);
//        this.userRepostiory.save(newUser);
//    }

    @ModelAttribute("userModel")
    public void initUserModel(Model model) {
        model.addAttribute("userModel", new UserRegisterDTO());
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }

        this.userService.registerAndLogin(userModel);

        return "redirect:/";
    }
}
