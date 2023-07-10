package th.mfu.boot;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/secure")
public class HelloController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
    
      return "Hello "+name;
    } 
}
