package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] array = new char[3][3];
        boolean a = true;

        int i, j, x, y;
        // выводим пустой массив
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]='_');
                System.out.print(" ");
            }
            System.out.println();
        }

        char player = 'O';


        int f = 0;
        while (a && f != 9) {

            System.out.println("Игрок номер " + ((player>>4)-3) + " введите номер ячейки по горизонтали, куда хотите поставить свою фигуру 0..2");
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();
            System.out.println("Игрок номер " + ((player>>4)-3) + " введите номер ячейки по вертикали, куда хотите поставить свою фигуру 0..2");
            Scanner scanner1 = new Scanner(System.in);
            y = scanner1.nextInt();
            if (x>=0 && x<=2 && y>=0 && y<=2) {
                for (i = 0; i <= 2; i++) {
                    for (j = 0; j <= 2; j++) {
                        if (array[x][y] == 95) {       //если ячейка, куда хочет поставить знак  игрок свободна , то поставить в нее знак и вывести массив
                            array[x][y] = player;
                            f++;
                            for (i = 0; i <= 2; i++) {
                                for (j = 0; j <= 2; j++) {
                                    System.out.print(array[i][j] + " ");
                                }
                                System.out.println();
                            }
                            if (f != 9 && (array[0][0] != 95 && array[0][0] == array[1][1] && array[1][1] == array[2][2]) ||
                                    (array[0][0] != 95 && array[0][0] == array[0][1] && array[0][1] == array[0][2]) ||
                                    (array[0][0] != 95 && array[0][0] == array[1][0] && array[1][0] == array[2][0]) ||
                                    (array[1][0] != 95 && array[1][0] == array[1][1] && array[1][1] == array[1][2]) ||
                                    (array[2][0] != 95 && array[2][0] == array[2][1] && array[2][1] == array[2][2]) ||
                                    (array[0][1] != 95 && array[0][1] == array[1][1] && array[1][1] == array[2][1]) ||
                                    (array[0][2] != 95 && array[0][2] == array[1][2] && array[1][2] == array[2][2]) ||
                                    (array[2][0] != 95 && array[2][0] == array[1][1] && array[1][1] == array[0][2])) {
                                System.out.println("Игрок номер " + ((player >> 4) - 3) + " выиграл");
                                a = false;
                                break;
                            } else if (f != 9) {
                                if (player == 'O') {
                                    player = 'X';
                                } else {
                                    player = 'O';
                                }
                            } else {
                                System.out.println("Ничья. Игра окончена");
                            }

                        } else {
                            System.out.println("Эта ячейка занята. Введите координаты повторно.");
                            break;
                        }
                        break;
                    }
                    break;
                }
            }
            else {
                System.out.println("Введите корректные координаты");
            }

        }
    }
}