package eu.paasword.services;

import eu.paasword.dao.UserRepository;
import eu.paasword.model.User;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pgouvas
 */
@Service
@Transactional
public class UserManagement {
    
    @Autowired
    UserRepository urs;
    
    public User addUser(User u){
        return urs.save(u);
    }
    
    public User getUser(Long userid){
        return urs.getOne(userid);
    }
    
}//EoC
