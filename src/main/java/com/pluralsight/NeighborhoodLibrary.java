package com.pluralsight;

public class NeighborhoodLibrary {

    private static Book[] books = new Book[20]; //array that stores up to 20 books
    private static int numOfBooks = 6; //books added in total

    public static void main(String[] args) {
        //array of book objects with their properties
        books[0] = new Book(0, "345-123456", "The Ugly Duckling",false, "");
        books[1] = new Book(1, "967-333999", "The Bad Seed", false, "");
        books[2] = new Book(2, "867-378031", "Where The Wild Things Are", false, "");
        books[3] = new Book(3, "999-111222", "Go, Dog. Go!", false, "");
        books[4] = new Book(4,"203-597212", "The Napping House", false, "");
        books[5] = new Book(5, "444-111555", "Stellaluna", false, "");





    }
}
