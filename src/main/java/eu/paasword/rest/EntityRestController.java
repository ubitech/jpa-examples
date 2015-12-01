/*
 *  Copyright 2015-2016 PaaSword project, http://www.paasword.eu/
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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
