package se.iths.gatewaywithservicediscovery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonsController {

    private final TestConfiguration testConfiguration;

    public PersonsController(TestConfiguration testConfiguration){
        this.testConfiguration = testConfiguration;
    }

    @GetMapping("/api/value")
    String value(){
        return testConfiguration.getValue();
    }
}
