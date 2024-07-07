package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Eichi> Eichis = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String cmd;
        int listNumber = 1;

        while (true) {
            System.out.println("== 프로그램 시작 ==");
            System.out.print("명령어) ");
            cmd = scanner.nextLine();

            if (cmd.equals("add")) {
                int id = listNumber;
                System.out.print("제목) ");
                String title = scanner.nextLine();
                System.out.print("내용) ");
                String body = scanner.nextLine();

                Eichi eichi = new Eichi(id, title, body);
                Eichis.add(eichi);

                System.out.println(id + "번글이 작성되었습니다.");
                listNumber++;

            } else if (cmd.equals("list")) {
                System.out.println("번호/제목/내용");
                for (int i = Eichis.size() - 1; i >= 0; i--) {
                    Eichi eichi = Eichis.get(i);
                    System.out.println(eichi.getId() + " / " + eichi.getTitle() + " / " + eichi.getBody());
                }

            } else if (cmd.split(" ")[0].equals("delete")) {
                int id = Integer.parseInt(cmd.split(" ")[1]);

                for (int i = Eichis.size() - 1; i >= 0; i--) {
                    Eichi eichi = Eichis.get(i);
                    if (eichi.getId() == id) {
                        Eichis.remove(eichi);
                    }
                }
                System.out.println(id + "번 글이 삭제되었습니다.");

            } else if (cmd.split(" ")[0].equals("modify")) {
                int id = Integer.parseInt(cmd.split(" ")[1]);

                for (int i = Eichis.size() - 1; i >= 0; i--) {
                    Eichi eichi = Eichis.get(i);
                    if (eichi.getId() == id) {
                        System.out.println("기존 제목 : " + eichi.getTitle());
                        System.out.println("기존 내용 : " + eichi.getBody());
                        System.out.print("새 제목 : ");
                        String newTitle = scanner.nextLine();
                        System.out.print("새 내용 : ");
                        String newBody = scanner.nextLine();

                        eichi.setTitle(newTitle);
                        eichi.setBody(newBody);

                        System.out.println(id + "번 게시글이 수정되었습니다");
                    }

                }
            } else if (cmd.equals("exit")) {
                System.out.println("== 프로그램 종료 ==");
                break;
            }
        }
        scanner.close();
    }
}