package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        // Accepts input for number of rows and seats in Cinema
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        // Builds 2D array and assigns values to coordinates
        String[][] array = new String[rows + 1][seats + 1];
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

        // Prints Cinema seating chart
        System.out.println("Cinema:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // Accepts input for seat selection and calculates ticket price
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();
        int price = 0;
        if (rows * seats <= 60) {
            price = 10;
        } else if (rows * seats > 60) {
            int frontRows = rows / 2;
            price = rowNum <= frontRows ? 10 : 8;
        }
        System.out.println("Ticket price: $" + price);

        // Marks seat selection on Cinema seating chart
        array[rowNum][seatNum] = "B";
        System.out.println("Cinema:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}