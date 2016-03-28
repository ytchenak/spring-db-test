package my.groupid.api;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<String>("Test us success!", HttpStatus.OK);
    }

}