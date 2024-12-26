package bg.softuni.mobilele.users;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String name;

    private boolean loggedIn;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isAnonymous() {
        return !isLoggedIn();
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void clear() {
        email = null;
        loggedIn = false;
        name = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
