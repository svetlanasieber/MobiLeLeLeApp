package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.validators.FieldMatch;
import bg.softuni.mobilele.models.validators.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match."
)
public class UserRegisterDTO {

   @NotEmpty(message = "User email should be provided.")
   @Email(message = "User email should be valid.")
   @UniqueUserEmail(message = "User email should be unique.")
   private String email;

   @NotEmpty
   @Size(min = 2, max = 20)
   private String firstName;

   @NotEmpty
   @Size(min = 2, max = 20)
   private String lastName;

   @NotEmpty
   @Size(min = 5)
   private String password;

   @NotEmpty
   private String confirmPassword;

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getConfirmPassword() {
      return confirmPassword;
   }

   public void setConfirmPassword(String confirmPassword) {
      this.confirmPassword = confirmPassword;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
