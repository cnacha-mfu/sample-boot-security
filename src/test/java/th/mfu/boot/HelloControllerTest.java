package th.mfu.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloControllerTest {

    private HelloController controller = new HelloController();

    @Test
    public void testHello() {
        // Arrange
        String name = "john";
        // Act
        String response = controller.hello(name);
        // Assert
        assertEquals("Hello john", response);
    }
}
