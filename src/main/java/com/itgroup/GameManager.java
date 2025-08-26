package com.itgroup;

import com.itgroup.bean.Character;
import com.itgroup.bean.Item;
import com.itgroup.bean.User;
import com.itgroup.dao.CharacterDao;
import com.itgroup.dao.ItemDao;
import com.itgroup.dao.UserDao;

import java.util.List;
import java.util.Scanner;

public class GameManager {
    private UserDao udao = null;
    private CharacterDao cdao = null;
    private ItemDao idao = null;
    private Scanner scan = null;

    public GameManager() {
        this.udao = new UserDao();
        this.cdao = new CharacterDao();
        this.idao = new ItemDao();
        this.scan = new Scanner(System.in);
    }


    public void insertUser() {
        User bean = new User();
        int cnt = -1;

        System.out.print("아이디 입력 : ");
        String user_id = scan.next();

        System.out.print("비밀번호 입력 : ");
        String password = scan.next();

        System.out.print("닉네임 입력 : ");
        String user_nick_name = scan.next();

        System.out.print("이메일 입력 : ");
        String email = scan.next();

        System.out.print("이름 입력 : ");
        String username = scan.next();

        bean.setUser_id(user_id);
        bean.setPassword(password);
        bean.setUser_nick_name(user_nick_name);
        bean.setEmail(email);
        bean.setUsername(username);
        bean.setReg_date("2025/08/25");

        cnt = udao.insertUser(bean);

        if (cnt == -1) {
            System.out.println("회원 가입 실패");
        } else if (cnt == 1) {
            System.out.println("회원 아이디" + user_id + "로 가입 성공");
        }


    }

    public void deleteUser() {
        System.out.print("아이디 입력 : ");
        String id = scan.next();
        int cnt = -1;

        cnt = udao.deleteUser(id);

        if (cnt == -1) {
            System.out.println("회원 탈퇴 실패( 접속 오류)");
        } else if (cnt == 0) {
            System.out.println("탈퇴할 회원이 존재 하지 않습니다.");
        } else if (cnt > 0) {
            System.out.println("회원" + id + "탈퇴 완료");
        }

    }

    public void getSizeUser() {
        int cnt = udao.getSizeUser();
        String message;
        if (cnt == 0) {
            message = "검색된 회원이 존재하지 않습니다.";
        } else {
            message = "검색된 회원은 총 " + cnt + " 명 입니다.";
        }
        System.out.println(message);
    }

    public void AllUserData() {
        List<User> users = udao.AllUserData();
        System.out.println("아이디\t\t이름\t\t닉네임\t이메일\t\t\t비밀번호\t\t생성일");
        for (User bean : users) {
            String user_id = bean.getUser_id();
            String username = bean.getUsername();
            String user_nick_name = bean.getUser_nick_name();
            String email = bean.getEmail();
            String password = bean.getPassword();
            String reg_date = bean.getReg_date();
            String message = user_id + "\t" + username + "\t" + user_nick_name + "\t\t" + email + "\t" + password + "\t" + reg_date;
            System.out.println(message);
        }
    }

    public void findCharacterInfo() {
        System.out.print("캐릭터 유저 아이디 입력 :");
        String findid = scan.next();
        Character someone = cdao.findCharacterInfo(findid);

        if (someone == null) {
            System.out.println("캐릭터를 찾을 수 없습니다");
        } else {
            int char_id = someone.getChar_id();
            String user_id = someone.getUser_id();
            String char_name = someone.getChar_name();
            String char_class = someone.getChar_class();
            int char_level = someone.getChar_level();
            int hp = someone.getHp();
            int mp = someone.getMp();
            String created_at = someone.getCreated_at();
            String message = "캐릭터 고유번호: " + char_id + "\n캐릭터 유저 아이디: " + user_id + "\n캐릭터 이름: " + char_name + "\n캐릭터 직업 : " + char_class + "\n캐릭터 레벨 :" + char_level + "\n캐릭터 hp :" + hp + "\n캐릭터 mp : " + mp + "\n캐릭터 생성일 :" + created_at;
            System.out.println(message);
        }

    }

    public void UpdateCharacterData() {
        int cnt = -1;
        System.out.print("수정하고자 하는 캐릭터 id 입력: ");
        String findid = scan.next();

        Character bean = cdao.findCharacterInfo(findid);

        System.out.print("캐릭터 이름 변경 :");
        String char_name = scan.next();

        bean.setChar_name(char_name);

        cnt = cdao.UpdateCharacterData(bean);

        if (cnt == -1) {
            System.out.println("업데이트 실패");
        } else if (cnt == 1) {
            System.out.println("업데이트 성공");
        } else {

        }
    }

    public void deleteCharacter() {
        System.out.print("캐릭터 이름 입력 : ");
        String id = scan.next();
        int cnt = -1;

        cnt = cdao.deleteCharacter(id);

        if (cnt == -1) {
            System.out.println("캐릭터 삭제 실패(접속 오류)");
        } else if (cnt == 0) {
            System.out.println("삭제할 캐릭터 이름이 존재하지 않습니다.");
        } else if (cnt > 0) {
            System.out.println("캐릭터 " + id + "삭제 완료");
        }

    }

    public void AllCharacterData() {
        List<Character> characters = cdao.AllCharacterData();
        System.out.println("캐릭터번호\t유저아이디\t캐릭터이름\t클래스\t레벨\t생성일");
        for (Character bean : characters) {
            int char_id = bean.getChar_id();
            String user_id = bean.getUser_id();
            String char_name = bean.getChar_name();
            String char_class = bean.getChar_class();
            int char_level = bean.getChar_level();
            String created_at = bean.getCreated_at();
            ;
            String message = char_id + "\t" + user_id + "\t" + char_name + "\t" + char_class + "\t" + char_level + "\t" + created_at;
            System.out.println(message);
        }

    }

    public void insertItem() {
        Item bean = new Item();
        int cnt = -1;
        System.out.print("추가할 아이템의 이름 입력 :");
        String name = scan.next();
        System.out.print("추가할 아이템의 타입 설정 :");
        String type = scan.next();
        bean.setChar_id(-1);
        bean.setName(name);
        bean.setType(type);
        bean.setPower(20);
        bean.setPrice(1000);


        cnt = idao.insertItem(bean);


        if (cnt == -1) {
            System.out.println("커넥션 오류");

        } else {
            System.out.println("아이템 " + name + " 추가 완료");
        }

    }

    public void deleteItem() {
        System.out.print("삭제할 아이템 이름 입력 : ");
        String findname = scan.next();
        int cnt = -1;

        cnt = idao.deleteItem(findname);

        if (cnt == -1) {
            System.out.println("아이템 삭제 실패(접속 오류)");
        } else if (cnt == 0) {
            System.out.println("삭제할 아이템 이름이 존재하지 않습니다.");
        } else if (cnt > 0) {
            System.out.println("아이템 " + findname + "삭제 완료");
        }


    }

    public void findItemInfo() {
        System.out.print("찾을 아이템 이름 : ");
        String findname = scan.next();
        Item someone = idao.findItemInfo(findname);

        if (someone == null) {
            System.out.println("아이템을 찾을 수 없습니다.");
        } else {
            int item_id = someone.getItem_id();
            int char_id = someone.getChar_id();
            String name = someone.getName();
            String type = someone.getType();
            int power = someone.getPower();
            int price = someone.getPrice();
            String message = "아이템 고유번호: " + item_id + " \n소유중인 캐릭터 번호: " + char_id + "\n 아이템 이름: " + name + "\n아이템 타입 : " + type + " \n아이템 파워 : " + power + " \n 아이템 가격 : " + price;
            System.out.println(message);

        }
    }

    public void allitemInfo() {
        List<Item> Itemlist = idao.allitemInfo();

        System.out.println("소유한캐릭터번호\t아이템이름\t타입\t파워\t가격");
        for(Item bean: Itemlist){
            int char_id = bean.getChar_id();
            String name = bean.getName();
            String type = bean.getType();
            int power = bean.getPower();
            int price = bean.getPrice() ;

            String message = char_id + "\t" + name + "\t" + type + "\t" + power +"\t"+ price;
            System.out.println(message);
        }


    }
}
