package Service.impl;

import Dao.logininDao;
import Service.logininService;
import model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class loginServiceImpl implements logininService {
    @Autowired
    private logininDao logininDao;
    @Override
    public int loginIf(String username, String password) {
        System.out.println(username+password);
        user user=logininDao.findUser(username);
        if(password.equals(user.getPassword())){
            return 1;
        }
        return 0;
    }

    @Override
    public Map sessionPut(Map session, user user) {
        user userReturn=logininDao.findUser(user.getUsername());
        session.put("username",userReturn.getUsername());
        session.put("password",userReturn.getPassword());
        session.put("birthday",userReturn.getBirthday());
        session.put("sex",userReturn.getSex());
        session.put("address",userReturn.getAddress());
        session.put("no",userReturn.getId());
        return session;
    }

    @Override
    public int registerIf(user user) {
        return 0;
    }

    @Override
    public int updateIf(user user) {
        return 0;
    }

    @Override
    public int changepasswordIf(user user) {
        return 0;
    }
}
