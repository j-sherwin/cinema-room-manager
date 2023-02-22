package cinema;

import java.util.Scanner;

public class Cinema {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }


    public static void buyTicket(String[][] array, int a, int b) {
        Scanner scanner = new Scanner(System.in);
        // Accepts input for seat selection and calculates ticket price
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();
        int price = 0;
        if (a * b <= 60) {
            price = 10;
        } else if (a * b > 60) {
            int frontRows = a / 2;
            price = rowNum <= frontRows ? 10 : 8;
        }
        System.out.println("Ticket price: $" + price);

        // Marks seat selection on Cinema seating chart
        array[rowNum][seatNum] = "B";
    }

    public static void seatChart(String[][] arr) {
        System.out.println("Cinema:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] buildArray(int a, int b) {
        String[][] array = new String[a + 1][b + 1];
        array[0][0] = " ";
        for (int i = 1; i < array[0].length; i++) {
            array[0][i] = String.valueOf(i);
        }
        for (int i = 1; i < array.length; i++) {
            array[i][0] = String.valueOf(i);
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                array[i][j] = "S";
            }
        }
        return array;
    }

    public static void main(String[] args) {
        // Write your code here
        // Accepts input for number of rows and seats in Cinema
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        // Builds 2D array and assigns values to coordinates
        String[][] array = buildArray(rows, seats);
        while (true) {
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    seatChart(array);
                    break;
                case 2:
                    buyTicket(array, rows, seats);
                    break;
                case 0:
                    return;
            }
        }
    }
}
