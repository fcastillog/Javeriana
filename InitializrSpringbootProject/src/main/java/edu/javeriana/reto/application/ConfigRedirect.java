package edu.javeriana.reto.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
/**
 *
 * @author dinan
 */
@RestController
@RequestMapping("/")
public class ConfigRedirect {
       
    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/swagger-ui/index.html");
    }
}
