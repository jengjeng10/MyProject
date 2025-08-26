package com.itgroup.dao;

import com.itgroup.bean.Character;
import com.itgroup.bean.Item;
import com.itgroup.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDao extends SuperDao {
    public ItemDao() {
        super();
    }


    public int insertItem(Item bean) {
        int cnt = -1;
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into items (item_id, char_id, name, type, power, price) ";
        sql += "values (items_seq.NEXTVAL,  ?, ? ,? ,?, ?) ";


        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getChar_id());
            pstmt.setString(2, bean.getName());
            pstmt.setString(3, bean.getType());
            pstmt.setInt(4, bean.getPower());
            pstmt.setInt(5, bean.getPrice());

            cnt = pstmt.executeUpdate();
            conn.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
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

    public int deleteItem(String findname) {
        int cnt = -1;
        String sql = "delete from items where name = ? ";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, findname);

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

    public Item findItemInfo(String findname) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Item bean = null ;

        String sql = "select * from items where name = ? ";

        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,findname);
            rs = pstmt.executeQuery();

            if(rs.next()){
                bean = new Item();
                bean.setItem_id(rs.getInt("item_id"));
                bean.setChar_id(rs.getInt("char_id"));
                bean.setName(rs.getString("name"));
                bean.setType(rs.getString("type"));
                bean.setPower(rs.getInt("power"));
                bean.setPrice(rs.getInt("price"));
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

    public List<Item> allitemInfo() {
        List<Item> itemList = new ArrayList<Item>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from items ";

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Item bean = new Item();
                bean.setItem_id(rs.getInt("item_id"));
                bean.setChar_id(rs.getInt("char_id"));
                bean.setName(rs.getString("name"));
                bean.setType(rs.getString("type"));
                bean.setPower(rs.getInt("power"));
                bean.setPrice(rs.getInt("price"));

                itemList.add(bean);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try {
                if (rs != null) {
                    rs.close();
                }
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




        return itemList;
    }
}
