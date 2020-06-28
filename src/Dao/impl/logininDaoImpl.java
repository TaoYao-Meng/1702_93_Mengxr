package Dao.impl;

import Dao.logininDao;
import model.user;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import utils.HbUtils;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class logininDaoImpl implements logininDao {
    @Resource
    private QueryRunner queryRunner;

    @Override
    public user findUser(String username) {
        String sql="select * from user where username=?";
        try{
            return queryRunner.query(sql,new BeanHandler<user>(user.class),username);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int insertUser(user user) {
        String sql="insert into user (id,username,password,sex,birthday,address,age,major,name,repass,telephone) values(?,?,?,?,?,?,?,?,?,?,?,)";
        System.out.println(sql);
        Object []params={user.getId(),user.getUsername(),user.getPassword(),user.getSex(),user.getBirthday()
        ,user.getAddress(),user.getAge(),user.getMajor(),user.getName(),user.getRepass(),user.getTelephone()};
        try{
            return queryRunner.update(sql,params);
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteUser(int id) {
        String sql="delete from user where id=?";
        try{
            return queryRunner.update(sql,id);
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateUser(user user) {
        String sql="update user set username=?,password=?,sex=?,birthday=?,address=?,age=?,major=?,name=?,repass=?,telephone=? where id=?";
        Object []params={user.getUsername(),user.getPassword(),user.getSex(),user.getBirthday()
                ,user.getAddress(),user.getAge(),user.getMajor(),user.getName(),user.getRepass(),user.getTelephone()};
        try{
            return queryRunner.update(sql,params);
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }


}
