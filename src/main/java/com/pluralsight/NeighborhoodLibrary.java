package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    private static Book[] books = new Book[20]; //array that stores up to 20 books
    private static int numOfBooks = 6; //books added in total

    public static void main(String[] args) {
        //array of book objects with their properties
        books[0] = new Book(1, "345-123456", "The Ugly Duckling", false, "");
        books[1] = new Book(2, "967-333999", "The Bad Seed", false, "");
        books[2] = new Book(3, "867-378031", "Where The Wild Things Are", false, "");
        books[3] = new Book(4, "999-111222", "Go, Dog. Go!", false, "");
        books[4] = new Book(5, "203-597212", "The Napping House", false, "");
        books[5] = new Book(6, "444-111555", "Stellaluna", false, "");

        Scanner scanner = new Scanner(System.in);
        int select = 0;

        System.out.println("\n--------Store Home Screen--------");

        while (true) {
            //display list of options that a user can choose from
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("3 - Exit"); // lets user close out of application
            System.out.print("Select Where You Want To Go: ");

            select = scanner.nextInt();
            scanner.nextLine(); // clears newline

            switch (select) {
                case 1:
                    showAvailableBooks(scanner);
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    System.out.println("Exiting From Store Home Screen!");
                    return; // exits from program
                default:
                    System.out.println("Invalid Command, Please pick 1-3!");
                    break;

            }
        }
    }

    // method that shows books that are available
    private static void showAvailableBooks(Scanner scanner) {
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < numOfBooks; i++) {
            if (!books[i].isCheckedOut()) // checks if book is not checked out
                System.out.println("ID: " + books[i].getId() + "\nISBN: " + books[i].getIsbn() + "\nTitle: " + books[i].getTitle() + "\n"); // shows book information
        }

        System.out.print("Please enter the ID of the book or press 0 to return to Store Home Screen: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 0) return;

        boolean found = false;
        for (int i = 0; i < numOfBooks; i++) {
            if (books[i].getId() == choice && !books[i].isCheckedOut()) {
                System.out.println("Please Enter Your Name: ");
                String name = scanner.nextLine();
                books[i].checkOut(name);
                System.out.println("Thank you, " + name + "! " + "You have checked out: " + books[i].getTitle() + ".");
                found = true;
                break; // exits

            }
        }
        if (!found) {
            System.out.println("Book is not available! Or invalid ID!");
        }
    }
// method that shows book that aren't available
        private static void showCheckedOutBooks() {
            System.out.println("\nChecked Out Books");
            for (int i = 0; i < numOfBooks; i++) {
                if (books[i].isCheckedOut()) { // checks if book is checked out
                    System.out.println(books[i]);
                }
            }
        }
    }

