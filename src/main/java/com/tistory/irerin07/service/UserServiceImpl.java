package com.tistory.irerin07.service;

import com.tistory.irerin07.dao.UserDao;
import com.tistory.irerin07.dao.UserDaoImpl;
import com.tistory.irerin07.dto.User;
import com.tistory.irerin07.util.ConnectionContextHolder;
import com.tistory.irerin07.util.DBUtil;

import java.sql.Connection;

public class UserServiceImpl implements UserService{
    private static UserService instance = new UserServiceImpl();
    private UserServiceImpl(){}
    public static UserService getInstance(){
        return instance;
    }
    @Override
    public void addUser(User user) {
        Connection conn = null;
        UserDao userDao = UserDaoImpl.getInstance();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            userDao.addUser(user);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    @Override
    public String getPasswdByEmail(String email) {
        String passwd = null;
        UserDao userDao = UserDaoImpl.getInstance();
        try(Connection conn = DBUtil.getInstance().getConnection();) {
            ConnectionContextHolder.setConnection(conn);
            passwd = userDao.getPasswdByEmail(email);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return passwd;
    }

    @Override
    public Long getIdByEmail(String email) {
        Long id = 0L;
        UserDao userDao = UserDaoImpl.getInstance();
        try(Connection conn = DBUtil.getInstance().getConnection();) {
            ConnectionContextHolder.setConnection(conn);
            id = userDao.getIdByEmail(email);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public String getNicknameByEmail(String email) {
        String nickName = null;
        UserDao userDao = UserDaoImpl.getInstance();
        try(Connection conn = DBUtil.getInstance().getConnection();) {
            ConnectionContextHolder.setConnection(conn);
            nickName = userDao.getNickNameByEmail(email);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return nickName;
    }
}
