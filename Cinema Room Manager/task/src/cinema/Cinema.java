package cinema;

import java.util.Objects;
import java.util.Scanner;

public class Cinema {

    static float seatsPurchased = 0;
    static int currentInc = 0;
    static int income = 0;
    static float totalSeats = 0;

    public static void income(int a, int b) {
        if (a * b <= 60) {
            income = a * b * 10;
        } else  {
            int frontRows = a / 2;
            int backRows = b - frontRows;
            income = frontRows * a * 10 + backRows * a * 8;
        }
    }
    public static void menu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void stats() {
        System.out.printf("Number of purchased tickets: %.0f%n" , seatsPurchased);
        System.out.printf("Percentage: %.2f%%%n" , seatsPurchased/totalSeats * 100);
        System.out.printf("Current income: $%d%n" , currentInc);
        System.out.printf("Total income: $%d%n" , income);
    }

    public static void buyTicket(String[][] array, int a, int b) {
        Scanner scanner = new Scanner(System.in);
        boolean seatTaken = false;
        while (!seatTaken) {
            // Accepts input for seat selection and calculates ticket price
            System.out.println("Enter a row number:");
            int rowNum = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNum = scanner.nextInt();
            if (rowNum < 1 || rowNum > array.length - 1 || seatNum < 1 || seatNum > array[0].length - 1) {
                System.out.println("Wrong input!");
            } else if (Objects.equals(array[rowNum][seatNum], "B")) {
                System.out.println("That ticket has already been purchased!");
            } else {
                array[rowNum][seatNum] = "B";
                int price = 0;
                if (a * b <= 60) {
                    price = 10;
                } else if (a * b > 60) {
                    int frontRows = a / 2;
                    price = rowNum <= frontRows ? 10 : 8;
                }
                System.out.println("Ticket price: $" + price);
                //Adds seats purchased
                seatsPurchased++;
                //Adds to total income
                currentInc += price;
                seatTaken = true;
            }
        }
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
        //calculate income
        income(rows, seats);
        totalSeats = rows * seats;
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
                case 3:
                    stats();
                    break;
                case 0:
                    return;
            }
        }
    }
}
