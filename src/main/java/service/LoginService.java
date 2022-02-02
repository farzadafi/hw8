package service;

import entity.User;
import repository.LoginRepository;

public class LoginService {
    LoginRepository loginRepository = new LoginRepository();

    public User returnUser(String nationalId){
        return loginRepository.returnUser(nationalId);
    }
}
