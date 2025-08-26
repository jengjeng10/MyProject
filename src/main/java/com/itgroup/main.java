package com.itgroup;


import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GameManager manager = new GameManager();
        int MainMenu;


        while (true) {
            System.out.println("=====메인 메뉴=====");
            System.out.println("0 :종료 , 1: 회원가입 , 2: 회원탈퇴 , 3:총 회원수 4.모든 유저 정보 100: 다음메뉴 ");
            System.out.print("입력 : ");
            MainMenu = scan.nextInt();



            if (MainMenu == 100){
                characterMenu(scan);
            }

            switch(MainMenu){
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                case 1:
                    manager.insertUser();
                    break;
                case 2:
                    manager.deleteUser();
                    break;
                case 3:
                    manager.getSizeUser();
                    break;
                case 4:
                    manager.AllUserData();
                    break;
            }
        }
    }

    public static void characterMenu(Scanner scan) {
        int charMenuChoice;
        GameManager manager = new GameManager();

        while (true) {
            System.out.println("=====캐릭터 메뉴=====");
            System.out.println("1:캐릭터 정보 ,2:캐릭터 수정 ,3:캐릭터 삭제 , 4:모든 캐릭터 정보  100:다음메뉴 ,101:되돌아가기");
            System.out.print("입력 : ");
            charMenuChoice = scan.nextInt();


            if (charMenuChoice == 101) {
                break;
            } else if (charMenuChoice == 100) {
                itemMenu(scan);
            }
            switch(charMenuChoice){
                case 1:
                    manager.findCharacterInfo();
                    break;
                case 2:
                    manager.UpdateCharacterData();
                    break;
                case 3:
                    manager.deleteCharacter();
                    break;
                case 4:
                    manager.AllCharacterData();
                    break;
            }
        }
    }

    public static void itemMenu(Scanner scan){
        int itemMenuChoice;

        while(true){
            System.out.println("=====아이템 메뉴=====");
            System.out.println("1: 아이템 추가, 2: 아이템 제거 , 3: 아이템 정보확인 , 4:모든 아이템 정보확인 ,101:되돌아가기");
            System.out.print("입력 : ");
            itemMenuChoice = scan.nextInt();
            GameManager manager = new GameManager();

            if(itemMenuChoice == 101){
                break;
            }
            switch(itemMenuChoice){
                case 1:
                    manager.insertItem();
                    break;
                case 2:
                    manager.deleteItem();
                    break;
                case 3:
                    manager.findItemInfo();
                    break;
                case 4:
                    manager.allitemInfo();
                    break;

            }
        }

    }

}