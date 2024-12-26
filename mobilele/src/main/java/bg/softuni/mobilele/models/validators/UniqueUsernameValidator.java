package bg.softuni.mobilele.models.validators;

import bg.softuni.mobilele.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUserEmail, String> {

    private UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return userRepository.findByEmail(value).isEmpty();
    }
}
