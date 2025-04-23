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
        books[4] = new Book(5, "203-597212", "The Napping House", true, "Amy");
        books[5] = new Book(6, "444-111555", "Stellaluna", false, "");

        Scanner scanner = new Scanner(System.in);
        int select = 0;

        System.out.println("\n--------Store Home Screen--------");

        while (true) { // making menu stay up until user closes out of application
            //display list of options that a user can choose from
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("3 - Exit"); // lets user close out of application
            System.out.print("Select Where You Want To Go: ");

            select = scanner.nextInt(); //takes number user enters
            scanner.nextLine(); // clears newline

            switch (select) {
                case 1:
                    showAvailableBooks(scanner); //calling on method to show books
                    break;
                case 2:
                    showCheckedOutBooks(); //calling on method to show checked out books
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
        for (int i = 0; i < numOfBooks; i++) { //loop that runs as long as i is less than numofbooks
            if (!books[i].isCheckedOut()) // checks if book is not checked out
                System.out.println("ID: " + books[i].getId() + "\nISBN: " + books[i].getIsbn() + "\nTitle: " + books[i].getTitle() + "\n"); // shows book information
        }

        System.out.print("Please enter the ID of the book or press 0 to return to Store Home Screen: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 0) return; //when user presses 0 it will return them to store home screen

        boolean found = false;
        for (int i = 0; i < numOfBooks; i++) { // loops through each book
            if (books[i].getId() == choice && !books[i].isCheckedOut()) { //checking if ID matches and is not checked out
                System.out.println("Please Enter Your Name: ");
                String name = scanner.nextLine(); // allows user to enter name
                books[i].checkOut(name); //checking book out user picked with name
                System.out.println("Thank you, " + name + "! " + "You have checked out: " + books[i].getTitle() + ".");
                found = true;
                break; // exits

            }
        }
        if (!found) { // if they put wrong info in or if book is unavailable
            System.out.println("Book is not available! Or invalid ID!");

        }
    }
// method that shows book that aren't available
        private static void showCheckedOutBooks() {
        Scanner scanner = new Scanner(System.in);
        boolean isCheckedOut = false;

            System.out.println("\nChecked Out Books");
            for (int i = 0; i < numOfBooks; i++) { //loop through each book in array
                if (books[i].isCheckedOut()) {// checks if book is checked out
                    isCheckedOut = true; //showing book is checked
                    System.out.println("ID: " +books[i].getId());
                    System.out.println("ISBN: " + books[i].getIsbn());
                    System.out.println("Title: " + books[i].getTitle());
                    System.out.println(); //line break
                }
            }
            if(!isCheckedOut){ //if no books are checked out
                System.out.println("No books are checked out!");
                System.out.println("Please press X to return to Store Home Page!");
                scanner.nextLine();
                return; //returns to Store Home Page
            }
            System.out.println("Please enter C to check in a book!");
            String letter = scanner.nextLine().toUpperCase();

            if(letter.equals("C")){
                System.out.println("Please enter the ID of the book you'd like to check in: ");
                int id = scanner.nextInt();
                scanner.nextLine();


                boolean isCheckedIn = false; // book is not checked in
                for (int i = 0; i < numOfBooks; i++){ // loop through array of books up to current amount
                    if (books[i].getId() == id && books[i].isCheckedOut()){  // checking both conditions to see if true-
                        isCheckedIn = true;
                        books[i].checkIn(); //checking in book user had picked
                        System.out.println("Thank you! " + books[i].getTitle() + " has been checked in.");
                        break; //exit loop

                    }

                    }
                if(!isCheckedIn){ //if book wasnt checked in, show error
                    System.out.println("Sorry! That was invalid. Please press X to return to Store Home Page!");
                    scanner.nextLine();
                    return;
                }
            }

        }
    }

