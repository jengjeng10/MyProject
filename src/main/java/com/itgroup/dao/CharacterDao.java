package com.itgroup.dao;

import com.itgroup.bean.Character;
import com.itgroup.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CharacterDao extends SuperDao{

    public CharacterDao(){
        super();
    }

    public Character findCharacterInfo(String findid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Character bean = null ;

        String sql = "select * from characters where user_id = ? ";

                try{
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,findid);
                rs = pstmt.executeQuery();

                if(rs.next()){
                    bean = new Character();
                    bean.setChar_id(rs.getInt("char_id"));
                    bean.setUser_id(rs.getString("user_id"));
                    bean.setChar_name(rs.getString("char_name"));
                    bean.setChar_class(rs.getString("char_class"));
                    bean.setChar_level(rs.getInt("char_level"));
                    bean.setHp(rs.getInt("hp"));
                    bean.setMp(rs.getInt("mp"));
                    bean.setCreated_at(rs.getString("created_at"));
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


        return bean;
    }

    public int UpdateCharacterData(Character bean) {
        int cnt = -1;
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update characters set char_name = ? where user_id = ? ";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getChar_name());
            pstmt.setString(2, bean.getUser_id());

            cnt = pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null){ pstmt.close();}
                if (conn != null) {conn.close();}
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }



        return cnt;
    }



    public int deleteCharacter(String id) {
        int cnt = -1;
        String sql = "delete from characters where char_name = ? ";
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



        }
        return cnt;
    }


    public List<Character> AllCharacterData() {
        List<Character> characters = new ArrayList<Character>();
        String sql = "select * from characters ";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                Character bean = new Character();
                bean.setChar_id(rs.getInt("char_id"));
                bean.setUser_id(rs.getString("user_id"));
                bean.setChar_name(rs.getString("char_name"));
                bean.setChar_class(rs.getString("char_class"));
                bean.setChar_level(rs.getInt("char_level"));
                bean.setCreated_at(rs.getString("created_at"));

                characters.add(bean);
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
        return characters;
    }
}
