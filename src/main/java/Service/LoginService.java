package Service;

import Entity.User;
import Repository.LoginRepository;

public class LoginService {
    LoginRepository loginRepository = new LoginRepository();

    public User returnUser(String nationalId){
        return loginRepository.returnUser(nationalId);
    }
}
