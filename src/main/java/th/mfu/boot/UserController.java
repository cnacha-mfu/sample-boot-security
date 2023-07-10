package th.mfu.boot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class UserController {

    public static Map<String, User> users = new HashMap<String, User>();

    @PostMapping("/users/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {

        if (users.containsKey(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        } 

        users.put(user.getUsername(), user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/users")
    public Collection<User> list() {
        
        return users.values();
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username) {

        return users.get(username);
    }
}
