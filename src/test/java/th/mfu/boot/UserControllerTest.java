package th.mfu.boot;

import th.mfu.boot.UserController;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserControllerTest {


    private static UserController controller  = new UserController();

    @Test
    public void testRegisterUser() {
        // Arrange
        User request = new User();
        request.setUsername("john");
        request.setEmail("john@example.com");

        // Act
        ResponseEntity<String> response = controller.registerUser(request);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User registered successfully", response.getBody());

        // verify(users).containsKey("john");
        // verify(users).put(eq("john"), any());

        User user = controller.getUser("john");

        assertEquals("john", user.getUsername());

    }

    @Test
    public void testRegisterDuplicateUser() {
        // Arrange
        User request1 = new User();
        request1.setUsername("brian");
        request1.setEmail("brian@example.com");

        User request2 = new User();
        request2.setUsername("brian");
        request2.setEmail("brian@example.com");

        // Act
        ResponseEntity<String> response1 = controller.registerUser(request1);
        ResponseEntity<String> response2 = controller.registerUser(request2);

        // Assert
        assertEquals(HttpStatus.OK, response1.getStatusCode());
        assertEquals("User registered successfully", response1.getBody());

        assertEquals(HttpStatus.CONFLICT, response2.getStatusCode());
        assertEquals("Username already exists", response2.getBody());

    }

   
}