package Dao;

import model.user;

import java.util.List;

public interface logininDao {
        public user findUser(String username);
        public int insertUser(user user);
        public int deleteUser(int id);
        public int updateUser(user user);
}
