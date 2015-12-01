package eu.paasword.rest;

import eu.paasword.model.User;
import eu.paasword.services.UserManagement;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
        
@RestController
public class EntityRestController {

    private static final Logger logger = Logger.getLogger(EntityRestController.class.getName());    
    
    @Autowired
    UserManagement um;
    
    @RequestMapping(value = "/paasword/entity/user/get", method = RequestMethod.GET)
    public User getUser(
            @RequestParam(value = "userid", defaultValue = "") Long userid
    ) throws IOException {
      return um.getUser(userid);
    }//EoM      
    
    
    
}//EoC
