import java.util.Scanner;

public class MovieTicketBookingSystem {

    static Scanner sc = new Scanner(System.in);


    static String[] movies = {
            "Leo",
            "GOAT",
            "Jailer",
            "Vettaiyan"
    };

    static boolean[] movieAvailable = {
            true,
            true,
            true,
            false
    };


    static boolean[][] seats = new boolean[5][8];

    static String[][] customerNames = new String[5][8];

    static String selectedMovie = "";

    static double weekdayPrice = 150.0;
    static double weekendPrice = 200.0;

    static double totalRating = 0.0;
    static int ratingCount = 0;


    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("      MOVIE TICKET BOOKING SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Show Movie Availability");
            System.out.println("2. Show Available Seats");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. View Booking Details");
            System.out.println("6. Rate Movie");
            System.out.println("7. Show Movie Rating");
            System.out.println("8. Exit");

            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showMovieAvailability();
                    break;

                case 2:
                    showAvailableSeats();
                    break;

                case 3:
                    bookTicket();
                    break;

                case 4:
                    cancelTicket();
                    break;

                case 5:
                    viewBookingDetails();
                    break;

                case 6:
                    rateMovie();
                    break;

                case 7:
                    showMovieRating();
                    break;

                case 8:
                    System.out.println(
                            "\nThank you for using Movie Ticket Booking System!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }




    static void showMovieAvailability() {

        System.out.println("\n========== MOVIE AVAILABILITY ==========");

        for (int i = 0; i < movies.length; i++) {

            System.out.print(movies[i]);

            if (movieAvailable[i]) {
                System.out.println(" - Available");
            } else {
                System.out.println(" - Not Available");
            }
        }

        System.out.println("========================================");
    }




    static void showAvailableSeats() {

        showMovieAvailability();

        System.out.print("\nEnter movie name: ");
        String movieName = sc.next();

        int movieIndex = findMovie(movieName);

        if (movieIndex == -1) {

            System.out.println("Movie not found!");
            return;
        }

        if (!movieAvailable[movieIndex]) {

            System.out.println(
                    "Sorry! This movie is not available."
            );

            return;
        }

        selectedMovie = movies[movieIndex];

        displaySeats();
    }

//

    static void displaySeats() {

        System.out.println("\n========== SEAT LAYOUT ==========");

        System.out.println(
                "Movie: " + selectedMovie
        );

        System.out.println();

        System.out.println(
                "       1   2   3   4   5   6   7   8"
        );

        for (int row = 0; row < seats.length; row++) {

            System.out.print(
                    "Row " + (row + 1) + " "
            );

            for (int seat = 0; seat < seats[row].length; seat++) {

                if (seats[row][seat]) {

                    System.out.print("[X] ");

                } else {

                    System.out.print("[O] ");
                }
            }

            System.out.println();
        }

        System.out.println();
        System.out.println("O = Available");
        System.out.println("X = Booked");
    }




    static void bookTicket() {

        showMovieAvailability();

        System.out.print("\nEnter movie name: ");
        String movieName = sc.next();

        int movieIndex = findMovie(movieName);

        if (movieIndex == -1) {

            System.out.println("Movie not found!");
            return;
        }

        if (!movieAvailable[movieIndex]) {

            System.out.println(
                    "Sorry! This movie is not available."
            );

            return;
        }

        selectedMovie = movies[movieIndex];

        System.out.println(
                "\nSelected Movie: " + selectedMovie
        );

        displaySeats();

        sc.nextLine();

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        if (customerName.trim().isEmpty()) {

            System.out.println(
                    "Customer name cannot be empty."
            );

            return;
        }

        System.out.print("Enter number of tickets: ");
        int ticketCount = sc.nextInt();

        if (ticketCount <= 0) {

            System.out.println(
                    "Ticket count must be greater than 0."
            );

            return;
        }

        int availableSeats = countAvailableSeats();

        if (ticketCount > availableSeats) {

            System.out.println(
                    "Not enough seats available."
            );

            System.out.println(
                    "Available seats: " + availableSeats
            );

            return;
        }




        System.out.print(
                "Is today weekend? (yes/no): "
        );

        String day = sc.next();

        double ticketPrice;

        if (day.equalsIgnoreCase("yes")) {

            ticketPrice = weekendPrice;

        } else if (day.equalsIgnoreCase("no")) {

            ticketPrice = weekdayPrice;

        } else {

            System.out.println(
                    "Please enter only yes or no."
            );

            return;
        }


        double totalAmount =
                ticketPrice * ticketCount;




        double discount = 0.0;

        System.out.print(
                "Do you have a discount coupon? (yes/no): "
        );

        String couponChoice = sc.next();

        if (couponChoice.equalsIgnoreCase("yes")) {

            System.out.print("Enter coupon code: ");
            String coupon = sc.next();

            if (coupon.equalsIgnoreCase("MOVIE10")) {

                discount =
                        totalAmount * 10.0 / 100.0;

                System.out.println(
                        "10% discount applied."
                );

            } else if (coupon.equalsIgnoreCase("MOVIE20")) {

                discount =
                        totalAmount * 20.0 / 100.0;

                System.out.println(
                        "20% discount applied."
                );

            } else {

                System.out.println(
                        "Invalid coupon code."
                );
            }

        } else if (!couponChoice.equalsIgnoreCase("no")) {

            System.out.println(
                    "Please enter only yes or no."
            );

            return;
        }


        double finalAmount =
                totalAmount - discount;



        for (int i = 0; i < ticketCount; i++) {

            System.out.println(
                    "\nSelect Seat " + (i + 1)
            );

            displaySeats();

            System.out.print(
                    "Enter row number (1-5): "
            );

            int row = sc.nextInt();

            System.out.print(
                    "Enter seat number (1-8): "
            );

            int seat = sc.nextInt();


            if (row < 1 || row > 5 ||
                    seat < 1 || seat > 8) {

                System.out.println(
                        "Invalid row or seat number."
                );

                i--;
                continue;
            }


            int rowIndex = row - 1;
            int seatIndex = seat - 1;


            if (seats[rowIndex][seatIndex]) {

                System.out.println(
                        "This seat is already booked."
                );

                i--;

            } else {

                seats[rowIndex][seatIndex] = true;

                customerNames[rowIndex][seatIndex]
                        = customerName;

                System.out.println(
                        "Seat " + row + "-" + seat +
                                " booked successfully."
                );
            }
        }




        System.out.println("\n======================================");
        System.out.println("           BOOKING SUMMARY");
        System.out.println("======================================");

        System.out.println(
                "Customer Name : " + customerName
        );

        System.out.println(
                "Movie         : " + selectedMovie
        );

        System.out.println(
                "Tickets       : " + ticketCount
        );

        System.out.printf(
                "Ticket Price  : ₹%.2f%n",
                ticketPrice
        );

        System.out.printf(
                "Total Amount  : ₹%.2f%n",
                totalAmount
        );

        System.out.printf(
                "Discount      : ₹%.2f%n",
                discount
        );

        System.out.printf(
                "Final Amount  : ₹%.2f%n",
                finalAmount
        );

        System.out.println("======================================");
        System.out.println(
                "        Booking Successful!"
        );
        System.out.println("======================================");
    }




    static void cancelTicket() {

        if (selectedMovie.equals("")) {

            System.out.println(
                    "Please select a movie first."
            );

            return;
        }

        displaySeats();

        System.out.print(
                "\nEnter row number: "
        );

        int row = sc.nextInt();

        System.out.print(
                "Enter seat number: "
        );

        int seat = sc.nextInt();


        if (row < 1 || row > 5 ||
                seat < 1 || seat > 8) {

            System.out.println(
                    "Invalid row or seat number."
            );

            return;
        }


        int rowIndex = row - 1;
        int seatIndex = seat - 1;


        if (!seats[rowIndex][seatIndex]) {

            System.out.println(
                    "This seat is not booked."
            );

            return;
        }


        System.out.println(
                "Customer: " +
                        customerNames[rowIndex][seatIndex]
        );


        System.out.print(
                "Are you sure you want to cancel? (yes/no): "
        );

        String confirm = sc.next();


        if (confirm.equalsIgnoreCase("yes")) {

            seats[rowIndex][seatIndex] = false;

            customerNames[rowIndex][seatIndex] = null;

            System.out.println(
                    "Ticket cancelled successfully."
            );

        } else if (confirm.equalsIgnoreCase("no")) {

            System.out.println(
                    "Cancellation cancelled."
            );

        } else {

            System.out.println(
                    "Please enter only yes or no."
            );
        }
    }



    static void viewBookingDetails() {

        System.out.println(
                "\n========== BOOKING DETAILS =========="
        );

        boolean found = false;

        for (int row = 0; row < seats.length; row++) {

            for (int seat = 0;
                 seat < seats[row].length;
                 seat++) {

                if (seats[row][seat]) {

                    found = true;

                    System.out.println(
                            "Movie    : " + selectedMovie
                    );

                    System.out.println(
                            "Customer : " +
                                    customerNames[row][seat]
                    );

                    System.out.println(
                            "Row      : " + (row + 1)
                    );

                    System.out.println(
                            "Seat     : " + (seat + 1)
                    );

                    System.out.println(
                            "--------------------------------"
                    );
                }
            }
        }

        if (!found) {

            System.out.println(
                    "No bookings available."
            );
        }
    }



    static void rateMovie() {

        showMovieAvailability();

        System.out.print(
                "\nEnter movie name: "
        );

        String movieName = sc.next();

        int movieIndex = findMovie(movieName);

        if (movieIndex == -1) {

            System.out.println(
                    "Movie not found!"
            );

            return;
        }

        if (!movieAvailable[movieIndex]) {

            System.out.println(
                    "This movie is not available."
            );

            return;
        }

        System.out.print(
                "Enter rating for " +
                        movies[movieIndex] +
                        " (1-5): "
        );

        double rating = sc.nextDouble();


        if (rating < 1 || rating > 5) {

            System.out.println(
                    "Rating must be between 1 and 5."
            );

            return;
        }


        totalRating =
                totalRating + rating;

        ratingCount++;


        System.out.println(
                "Thank you for rating " +
                        movies[movieIndex] + "!"
        );
    }



    static void showMovieRating() {

        if (ratingCount == 0) {

            System.out.println(
                    "\nNo ratings available yet."
            );

            return;
        }


        double averageRating =
                totalRating / ratingCount;


        System.out.println(
                "\n========== MOVIE RATING =========="
        );

        System.out.println(
                "Movie: " + selectedMovie
        );

        System.out.printf(
                "Average Rating: %.2f / 5%n",
                averageRating
        );

        System.out.println(
                "Total Ratings: " + ratingCount
        );
    }



    static int countAvailableSeats() {

        int count = 0;

        for (int row = 0;
             row < seats.length;
             row++) {

            for (int seat = 0;
                 seat < seats[row].length;
                 seat++) {

                if (!seats[row][seat]) {

                    count++;
                }
            }
        }

        return count;
    }



    static int findMovie(String movieName) {

        for (int i = 0; i < movies.length; i++) {

            if (movies[i].equalsIgnoreCase(movieName)) {

                return i;
            }
        }

        return -1;
    }
}