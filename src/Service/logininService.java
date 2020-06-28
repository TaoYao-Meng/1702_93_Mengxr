package Service;

import model.user;

import java.util.Map;

public interface logininService {
    public int loginIf(String username,String password);
    public Map sessionPut(Map session,user user);
    public int registerIf(user user);
    public int updateIf(user user);
    public int changepasswordIf(user user);
}
