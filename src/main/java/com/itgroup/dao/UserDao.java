package com.itgroup.dao;

import com.itgroup.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends SuperDao{

    public UserDao(){
    super();

    }

    public int insertUser(User bean) {
        int cnt = -1;

        String sql = "insert into users(user_id , username , user_nick_name, email, password, reg_date)";
        sql += "values(?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstmt = null;


        try{
            conn =super.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,bean.getUser_id());
            pstmt.setString(2,bean.getUsername());
            pstmt.setString(3,bean.getUser_nick_name());
            pstmt.setString(4,bean.getEmail());
            pstmt.setString(5,bean.getPassword());
            pstmt.setString(6,bean.getReg_date());


            cnt = pstmt.executeUpdate();
            conn.commit();
        }catch(Exception ex) {
            ex.printStackTrace();
            try{
                conn.rollback();
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }finally{
            try{
                if(pstmt != null){pstmt.close();}
                if(conn != null){conn.close();}

            }catch(Exception ex){
                ex.printStackTrace();
            }

        }





        return cnt;
    }

    public int deleteUser(String id) {
        int cnt = -1;
        String sql = "delete from users where user_id = ? ";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            cnt = pstmt.executeUpdate();
            conn.commit();
        } catch (Exception ex) {
            try {
                conn.rollback();

            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


            return cnt;
        }
    }

    public int getSizeUser() {
        String sql = "select count(*) as cnt from users ";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        int cnt = 0;


        try{
        conn = super.getConnection();
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        if(rs.next()){
            cnt = rs.getInt("cnt");
        }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }



        return cnt;
    }

    public List<User> AllUserData() {
        List<User> users = new ArrayList<User>();
        String sql = "select * from Users ";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
            User bean = new User();
            bean.setUser_id(rs.getString("user_id"));
            bean.setUsername(rs.getString("username"));
            bean.setUser_nick_name(rs.getString("user_nick_name"));
            bean.setEmail(rs.getString("email"));
            bean.setPassword(rs.getString("password"));
            bean.setReg_date(rs.getString("reg_date"));

                users.add(bean);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }



        return users;
    }
}
