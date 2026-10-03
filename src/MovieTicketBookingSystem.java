//import java.util.Scanner;
//
//public class MovieTicketBookingSystem {
//
//    static Scanner sc = new Scanner(System.in);
//
//    // Theatre has 5 rows and 8 seats in each row
//    static boolean[][] seats = new boolean[5][8];
//
//    // Customer details for each seat
//    static String[][] customerNames = new String[5][8];
//
//    static String movieName = "Leo";
//    static double weekdayPrice = 150;
//    static double weekendPrice = 200;
//
//    static double totalRating = 0;
//    static int ratingCount = 0;
//
//    public static void main(String[] args) {
//
//        int choice;
//
//        do {
//            System.out.println("\n====================================");
//            System.out.println("       MOVIE TICKET BOOKING SYSTEM");
//            System.out.println("====================================");
//            System.out.println("1. Show Available Seats");
//            System.out.println("2. Book Ticket");
//            System.out.println("3. Cancel Ticket");
//            System.out.println("4. View Booking Details");
//            System.out.println("5. Rate Movie");
//            System.out.println("6. Show Movie Rating");
//            System.out.println("7. Exit");
//            System.out.println("====================================");
//
//            System.out.print("Enter your choice: ");
//            choice = sc.nextInt();
//
//            switch (choice) {
//
//                case 1:
//                    showSeats();
//                    break;
//
//                case 2:
//                    bookTicket();
//                    break;
//
//                case 3:
//                    cancelTicket();
//                    break;
//
//                case 4:
//                    viewBookingDetails();
//                    break;
//
//                case 5:
//                    rateMovie();
//                    break;
//
//                case 6:
//                    showRating();
//                    break;
//
//                case 7:
//                    System.out.println("Thank you for using Movie Ticket Booking System!");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice!");
//            }
//
//        } while (choice != 7);
//
//        sc.close();
//    }
//
//    // -----------------------------------------
//    // 1. SHOW AVAILABLE SEATS
//    // -----------------------------------------
//
//    static void showSeats() {
//
//        System.out.println("\n========== SEAT LAYOUT ==========");
//
//        System.out.println("       1  2  3  4  5  6  7  8");
//
//        for (int i = 0; i < seats.length; i++) {
//
//            System.out.print("Row " + (i + 1) + "  ");
//
//            for (int j = 0; j < seats[i].length; j++) {
//
//                if (seats[i][j]) {
//                    System.out.print("[X]");
//                } else {
//                    System.out.print("[O]");
//                }
//            }
//
//            System.out.println();
//        }
//
//        System.out.println("\nO = Available");
//        System.out.println("X = Booked");
//    }
//
//    // -----------------------------------------
//    // 2. BOOK TICKET
//    // -----------------------------------------
//
//    static void bookTicket() {
//
//        showSeats();
//
//        System.out.print("\nEnter your name: ");
//        sc.nextLine();
//        String name = sc.nextLine();
//
//        System.out.print("Enter row number (1-5): ");
//        int row = sc.nextInt();
//
//        System.out.print("Enter seat number (1-8): ");
//        int seat = sc.nextInt();
//
//        // Validate row and seat
//        if (row < 1 || row > 5 || seat < 1 || seat > 8) {
//
//            System.out.println("Invalid row or seat number!");
//            return;
//        }
//
//        // Convert user input to array index
//        int rowIndex = row - 1;
//        int seatIndex = seat - 1;
//
//        // Check whether seat is already booked
//        if (seats[rowIndex][seatIndex]) {
//
//            System.out.println("Sorry! This seat is already booked.");
//            return;
//        }
//
//        // Ask number of tickets
//        System.out.print("Enter number of tickets: ");
//        int ticketCount = sc.nextInt();
//
//        if (ticketCount <= 0) {
//
//            System.out.println("Invalid ticket count!");
//            return;
//        }
//
//        // Check available seats
//        int availableSeats = countAvailableSeats();
//
//        if (ticketCount > availableSeats) {
//
//            System.out.println("Not enough seats available!");
//            return;
//        }
//
//        // Weekend pricing
//        System.out.print("Is today weekend? (yes/no): ");
//        String day = sc.next();
//
//        double ticketPrice;
//
//        if (day.equalsIgnoreCase("yes")) {
//            ticketPrice = weekendPrice;
//        } else {
//            ticketPrice = weekdayPrice;
//        }
//
//        double totalAmount = ticketPrice * ticketCount;
//
//        // Coupon
//        System.out.print("Do you have a discount coupon? (yes/no): ");
//        String couponChoice = sc.next();
//
//        double discount = 0;
//
//        if (couponChoice.equalsIgnoreCase("yes")) {
//
//            System.out.print("Enter coupon code: ");
//            String coupon = sc.next();
//
//            if (coupon.equalsIgnoreCase("MOVIE10")) {
//
//                discount = totalAmount * 0.10;
//                System.out.println("10% discount applied!");
//
//            } else if (coupon.equalsIgnoreCase("MOVIE20")) {
//
//                discount = totalAmount * 0.20;
//                System.out.println("20% discount applied!");
//
//            } else {
//
//                System.out.println("Invalid coupon!");
//            }
//        }
//
//        double finalAmount = totalAmount - discount;
//
//        // Book selected seats
//        for (int i = 0; i < ticketCount; i++) {
//
//            System.out.println("\nSelect seat " + (i + 1));
//
//            showSeats();
//
//            System.out.print("Enter row: ");
//            int selectedRow = sc.nextInt();
//
//            System.out.print("Enter seat: ");
//            int selectedSeat = sc.nextInt();
//
//            if (selectedRow < 1 || selectedRow > 5 ||
//                    selectedSeat < 1 || selectedSeat > 8) {
//
//                System.out.println("Invalid seat!");
//                i--;
//                continue;
//            }
//
//            int r = selectedRow - 1;
//            int s = selectedSeat - 1;
//
//            if (seats[r][s]) {
//
//                System.out.println("Seat already booked!");
//                i--;
//
//            } else {
//
//                seats[r][s] = true;
//                customerNames[r][s] = name;
//
//                System.out.println("Seat " + selectedRow + "-" + selectedSeat
//                        + " booked successfully!");
//            }
//        }
//
//        System.out.println("\n=================================");
//        System.out.println("         BOOKING SUMMARY");
//        System.out.println("=================================");
//        System.out.println("Customer Name : " + name);
//        System.out.println("Movie         : " + movieName);
//        System.out.println("Tickets       : " + ticketCount);
//        System.out.println("Ticket Price  : ₹" + ticketPrice);
//        System.out.println("Total Amount  : ₹" + totalAmount);
//        System.out.println("Discount      : ₹" + discount);
//        System.out.println("Final Amount  : ₹" + finalAmount);
//        System.out.println("=================================");
//    }
//
//    // -----------------------------------------
//    // 3. CANCEL TICKET
//    // -----------------------------------------
//
//    static void cancelTicket() {
//
//        showSeats();
//
//        System.out.print("\nEnter row number: ");
//        int row = sc.nextInt();
//
//        System.out.print("Enter seat number: ");
//        int seat = sc.nextInt();
//
//        if (row < 1 || row > 5 || seat < 1 || seat > 8) {
//
//            System.out.println("Invalid row or seat!");
//            return;
//        }
//
//        int rowIndex = row - 1;
//        int seatIndex = seat - 1;
//
//        if (!seats[rowIndex][seatIndex]) {
//
//            System.out.println("This seat is not booked.");
//            return;
//        }
//
//        System.out.println("Booking found for: "
//                + customerNames[rowIndex][seatIndex]);
//
//        System.out.print("Are you sure you want to cancel? (yes/no): ");
//        String confirm = sc.next();
//
//        if (confirm.equalsIgnoreCase("yes")) {
//
//            seats[rowIndex][seatIndex] = false;
//            customerNames[rowIndex][seatIndex] = null;
//
//            System.out.println("Ticket cancelled successfully!");
//
//        } else {
//
//            System.out.println("Cancellation cancelled.");
//        }
//    }
//
//    // -----------------------------------------
//    // 4. VIEW BOOKING DETAILS
//    // -----------------------------------------
//
//    static void viewBookingDetails() {
//
//        System.out.println("\n========== BOOKING DETAILS ==========");
//
//        boolean found = false;
//
//        for (int i = 0; i < seats.length; i++) {
//
//            for (int j = 0; j < seats[i].length; j++) {
//
//                if (seats[i][j]) {
//
//                    found = true;
//
//                    System.out.println(
//                            "Customer : " + customerNames[i][j]
//                                    + " | Row : " + (i + 1)
//                                    + " | Seat : " + (j + 1)
//                    );
//                }
//            }
//        }
//
//        if (!found) {
//            System.out.println("No bookings available.");
//        }
//    }
//
//    // -----------------------------------------
//    // 5. RATE MOVIE
//    // -----------------------------------------
//
//    static void rateMovie() {
//
//        System.out.print("\nEnter rating for " + movieName
//                + " (1-5): ");
//
//        double rating = sc.nextDouble();
//
//        if (rating < 1 || rating > 5) {
//
//            System.out.println("Rating must be between 1 and 5.");
//            return;
//        }
//
//        totalRating = totalRating + rating;
//        ratingCount++;
//
//        System.out.println("Thank you for rating the movie!");
//    }
//
//    // -----------------------------------------
//    // 6. SHOW MOVIE RATING
//    // -----------------------------------------
//
//    static void showRating() {
//
//        System.out.println("\n========== MOVIE RATING ==========");
//
//        if (ratingCount == 0) {
//
//            System.out.println("No ratings available yet.");
//
//        } else {
//
//            double averageRating = totalRating / ratingCount;
//
//            System.out.println("Movie : " + movieName);
//            System.out.println("Average Rating : "
//                    + averageRating + " / 5");
//            System.out.println("Total Ratings : " + ratingCount);
//        }
//    }
//
//    // -----------------------------------------
//    // COUNT AVAILABLE SEATS
//    // -----------------------------------------
//
//    static int countAvailableSeats() {
//
//        int count = 0;
//
//        for (int i = 0; i < seats.length; i++) {
//
//            for (int j = 0; j < seats[i].length; j++) {
//
//                if (!seats[i][j]) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
//}
//
//import java.util.Scanner;
//
//public class MovieTicketBookingSystem {
//
//    static Scanner sc = new Scanner(System.in);
//
//    // 5 rows x 8 seats
//    static boolean[][] seats = new boolean[5][8];
//
//    // Store customer name for each seat
//    static String[][] customerNames = new String[5][8];
//
//    // Movie details
//    static String[] movies = {
//            "Leo",
//            "GOAT",
//            "Jailer",
//            "Vettaiyan"
//    };
//
//    static boolean[] movieAvailable = {
//            true,
//            true,
//            true,
//            false
//    };
//
//    // Selected movie
//    static String selectedMovie = "";
//
//    // Ticket prices
//    static double weekdayPrice = 150;
//    static double weekendPrice = 200;
//
//    // Rating
//    static double totalRating = 0;
//    static int ratingCount = 0;
//
//
//    public static void main(String[] args) {
//
//        int choice;
//
//        do {
//
//            System.out.println("\n======================================");
//            System.out.println("      MOVIE TICKET BOOKING SYSTEM");
//            System.out.println("======================================");
//
//            System.out.println("1. Show Movie Availability");
//            System.out.println("2. Show Available Seats");
//            System.out.println("3. Book Ticket");
//            System.out.println("4. Cancel Ticket");
//            System.out.println("5. View Booking Details");
//            System.out.println("6. Rate Movie");
//            System.out.println("7. Show Movie Rating");
//            System.out.println("8. Exit");
//
//            System.out.println("======================================");
//
//            System.out.print("Enter your choice: ");
//            choice = sc.nextInt();
//
//            switch (choice) {
//
//                case 1:
//                    showMovieAvailability();
//                    break;
//
//                case 2:
//                    showSeats();
//                    break;
//
//                case 3:
//                    bookTicket();
//                    break;
//
//                case 4:
//                    cancelTicket();
//                    break;
//
//                case 5:
//                    viewBookingDetails();
//                    break;
//
//                case 6:
//                    rateMovie();
//                    break;
//
//                case 7:
//                    showRating();
//                    break;
//
//                case 8:
//                    System.out.println("\nThank you for using Movie Ticket Booking System!");
//                    break;
//
//                default:
//                    System.out.println("\nInvalid choice!");
//            }
//
//        } while (choice != 8);
//
//        sc.close();
//    }
//
//
//    // ==================================================
//    // 1. SHOW MOVIE AVAILABILITY
//    // ==================================================
//
//    static void showMovieAvailability() {
//
//        System.out.println("\n========== MOVIE AVAILABILITY ==========");
//
//        for (int i = 0; i < movies.length; i++) {
//
//            System.out.print((i + 1) + ". " + movies[i]);
//
//            if (movieAvailable[i]) {
//                System.out.println(" - Available");
//            } else {
//                System.out.println(" - Not Available");
//            }
//        }
//
//        System.out.println("========================================");
//    }
//
//
//    // ==================================================
//    // 2. SHOW AVAILABLE SEATS
//    // ==================================================
//
//    static void showSeats() {
//
//        System.out.println("\n========== SEAT LAYOUT ==========");
//
//        System.out.println("        1   2   3   4   5   6   7   8");
//
//        for (int i = 0; i < seats.length; i++) {
//
//            System.out.print("Row " + (i + 1) + "  ");
//
//            for (int j = 0; j < seats[i].length; j++) {
//
//                if (seats[i][j]) {
//                    System.out.print("[X] ");
//                } else {
//                    System.out.print("[O] ");
//                }
//            }
//
//            System.out.println();
//        }
//
//        System.out.println("\nO = Available");
//        System.out.println("X = Booked");
//    }
//
//
//    // ==================================================
//    // 3. BOOK TICKET
//    // ==================================================
//
//    static void bookTicket() {
//
//        // First show movies
//        showMovieAvailability();
//
//        System.out.print("\nSelect movie number: ");
//        int movieChoice = sc.nextInt();
//
//        // Validate movie choice
//        if (movieChoice < 1 || movieChoice > movies.length) {
//
//            System.out.println("Invalid movie choice!");
//            return;
//        }
//
//        // Check movie availability
//        if (!movieAvailable[movieChoice - 1]) {
//
//            System.out.println("Sorry! This movie is currently not available.");
//            return;
//        }
//
//        selectedMovie = movies[movieChoice - 1];
//
//        System.out.println("\nSelected Movie: " + selectedMovie);
//
//        // Show seats
//        showSeats();
//
//        sc.nextLine();
//
//        System.out.print("\nEnter customer name: ");
//        String name = sc.nextLine();
//
//        System.out.print("Enter number of tickets: ");
//        int ticketCount = sc.nextInt();
//
//        if (ticketCount <= 0) {
//
//            System.out.println("Invalid ticket count!");
//            return;
//        }
//
//        // Check available seats
//        int availableSeats = countAvailableSeats();
//
//        if (ticketCount > availableSeats) {
//
//            System.out.println("Not enough seats available!");
//            System.out.println("Available seats: " + availableSeats);
//            return;
//        }
//
//
//        // ==========================================
//        // WEEKEND PRICING
//        // ==========================================
//
//        System.out.print("Is today weekend? (yes/no): ");
//        String day = sc.next();
//
//        double ticketPrice;
//
//        if (day.equalsIgnoreCase("yes")) {
//
//            ticketPrice = weekendPrice;
//
//        } else {
//
//            ticketPrice = weekdayPrice;
//        }
//
//
//        double totalAmount = ticketPrice * ticketCount;
//
//
//        // ==========================================
//        // DISCOUNT COUPON
//        // ==========================================
//
//        System.out.print("Do you have a discount coupon? (yes/no): ");
//        String couponChoice = sc.next();
//
//        double discount = 0;
//
//        if (couponChoice.equalsIgnoreCase("yes")) {
//
//            System.out.print("Enter coupon code: ");
//            String coupon = sc.next();
//
//            if (coupon.equalsIgnoreCase("MOVIE10")) {
//
//                discount = totalAmount * 0.10;
//
//                System.out.println("10% discount applied!");
//
//            } else if (coupon.equalsIgnoreCase("MOVIE20")) {
//
//                discount = totalAmount * 0.20;
//
//                System.out.println("20% discount applied!");
//
//            } else {
//
//                System.out.println("Invalid coupon!");
//            }
//        }
//
//
//        double finalAmount = totalAmount - discount;
//
//
//        // ==========================================
//        // SELECT SEATS
//        // ==========================================
//
//        for (int i = 0; i < ticketCount; i++) {
//
//            System.out.println("\nSelect Seat " + (i + 1));
//
//            showSeats();
//
//            System.out.print("Enter row number (1-5): ");
//            int row = sc.nextInt();
//
//            System.out.print("Enter seat number (1-8): ");
//            int seat = sc.nextInt();
//
//
//            // Validate row and seat
//            if (row < 1 || row > 5 ||
//                    seat < 1 || seat > 8) {
//
//                System.out.println("Invalid row or seat!");
//                i--;
//                continue;
//            }
//
//
//            int rowIndex = row - 1;
//            int seatIndex = seat - 1;
//
//
//            // Check seat availability
//            if (seats[rowIndex][seatIndex]) {
//
//                System.out.println("This seat is already booked!");
//
//                i--;
//
//            } else {
//
//                seats[rowIndex][seatIndex] = true;
//
//                customerNames[rowIndex][seatIndex] = name;
//
//                System.out.println(
//                        "Seat " + row + "-" + seat +
//                                " booked successfully!"
//                );
//            }
//        }
//
//
//        // ==========================================
//        // BOOKING SUMMARY
//        // ==========================================
//
//        System.out.println("\n======================================");
//        System.out.println("          BOOKING SUMMARY");
//        System.out.println("======================================");
//
//        System.out.println("Customer Name : " + name);
//        System.out.println("Movie         : " + selectedMovie);
//        System.out.println("Tickets       : " + ticketCount);
//        System.out.println("Ticket Price  : ₹" + ticketPrice);
//        System.out.println("Total Amount  : ₹" + totalAmount);
//        System.out.println("Discount      : ₹" + discount);
//        System.out.println("Final Amount  : ₹" + finalAmount);
//
//        System.out.println("======================================");
//        System.out.println("       Booking Successful!");
//        System.out.println("======================================");
//    }
//
//
//    // ==================================================
//    // 4. CANCEL TICKET
//    // ==================================================
//
//    static void cancelTicket() {
//
//        showSeats();
//
//        System.out.print("\nEnter row number: ");
//        int row = sc.nextInt();
//
//        System.out.print("Enter seat number: ");
//        int seat = sc.nextInt();
//
//
//        if (row < 1 || row > 5 ||
//                seat < 1 || seat > 8) {
//
//            System.out.println("Invalid row or seat!");
//            return;
//        }
//
//
//        int rowIndex = row - 1;
//        int seatIndex = seat - 1;
//
//
//        // Check booking
//        if (!seats[rowIndex][seatIndex]) {
//
//            System.out.println("This seat is not booked.");
//            return;
//        }
//
//
//        System.out.println(
//                "Booking found for: " +
//                        customerNames[rowIndex][seatIndex]
//        );
//
//
//        System.out.print(
//                "Are you sure you want to cancel? (yes/no): "
//        );
//
//        String confirm = sc.next();
//
//
//        if (confirm.equalsIgnoreCase("yes")) {
//
//            seats[rowIndex][seatIndex] = false;
//
//            customerNames[rowIndex][seatIndex] = null;
//
//            System.out.println(
//                    "Ticket cancelled successfully!"
//            );
//
//        } else {
//
//            System.out.println(
//                    "Ticket cancellation cancelled."
//            );
//        }
//    }
//
//
//    // ==================================================
//    // 5. VIEW BOOKING DETAILS
//    // ==================================================
//
//    static void viewBookingDetails() {
//
//        System.out.println("\n========== BOOKING DETAILS ==========");
//
//        boolean found = false;
//
//
//        for (int i = 0; i < seats.length; i++) {
//
//            for (int j = 0; j < seats[i].length; j++) {
//
//                if (seats[i][j]) {
//
//                    found = true;
//
//                    System.out.println(
//                            "Customer : " +
//                                    customerNames[i][j] +
//
//                                    " | Row : " +
//                                    (i + 1) +
//
//                                    " | Seat : " +
//                                    (j + 1)
//                    );
//                }
//            }
//        }
//
//
//        if (!found) {
//
//            System.out.println(
//                    "No bookings available."
//            );
//        }
//    }
//
//
//    // ==================================================
//    // 6. RATE MOVIE
//    // ==================================================
//
//    static void rateMovie() {
//
//        showMovieAvailability();
//
//        System.out.print(
//                "\nEnter movie number to rate: "
//        );
//
//        int movieChoice = sc.nextInt();
//
//
//        if (movieChoice < 1 ||
//                movieChoice > movies.length) {
//
//            System.out.println(
//                    "Invalid movie choice!"
//            );
//
//            return;
//        }
//
//
//        if (!movieAvailable[movieChoice - 1]) {
//
//            System.out.println(
//                    "This movie is not available."
//            );
//
//            return;
//        }
//
//
//        System.out.print(
//                "Enter rating for " +
//                        movies[movieChoice - 1] +
//                        " (1-5): "
//        );
//
//        double rating = sc.nextDouble();
//
//
//        if (rating < 1 || rating > 5) {
//
//            System.out.println(
//                    "Rating must be between 1 and 5."
//            );
//
//            return;
//        }
//
//
//        totalRating = totalRating + rating;
//
//        ratingCount++;
//
//
//        System.out.println(
//                "Thank you for rating the movie!"
//        );
//    }
//
//
//    // ==================================================
//    // 7. SHOW MOVIE RATING
//    // ==================================================
//
//    static void showRating() {
//
//        System.out.println("\n========== MOVIE RATING ==========");
//
//
//        if (ratingCount == 0) {
//
//            System.out.println(
//                    "No ratings available yet."
//            );
//
//        } else {
//
//            double averageRating =
//                    totalRating / ratingCount;
//
//
//            System.out.println(
//                    "Movie : " + selectedMovie
//            );
//
//            System.out.println(
//                    "Average Rating : " +
//                            averageRating +
//                            " / 5"
//            );
//
//            System.out.println(
//                    "Total Ratings : " +
//                            ratingCount
//            );
//        }
//    }
//
//
//    // ==================================================
//    // COUNT AVAILABLE SEATS
//    // ==================================================
//
//    static int countAvailableSeats() {
//
//        int count = 0;
//
//
//        for (int i = 0; i < seats.length; i++) {
//
//            for (int j = 0; j < seats[i].length; j++) {
//
//                if (!seats[i][j]) {
//
//                    count++;
//                }
//            }
//        }
//
//
//        return count;
//    }
//}

//import java.util.Scanner;
//
//public class MovieTicketBookingSystem {
//
//    static Scanner sc = new Scanner(System.in);
//
//    // Movie details
//    static String[] movies = {
//            "Leo",
//            "GOAT",
//            "Jailer",
//            "Vettaiyan"
//    };
//
//    // Movie availability
//    static boolean[] movieAvailable = {
//            true,
//            true,
//            true,
//            false
//    };
//
//    // 3D array:
//    // Movie -> Row -> Seat
//    // 4 movies, 5 rows, 8 seats
//    static boolean[][][] seats = new boolean[4][5][8];
//
//    // Customer names:
//    // Movie -> Row -> Seat
//    static String[][][] customerNames = new String[4][5][8];
//
//    // Movie ratings
//    static double[] totalRatings = new double[4];
//    static int[] ratingCounts = new int[4];
//
//    // Ticket prices
//    static double weekdayPrice = 150.0;
//    static double weekendPrice = 200.0;
//
//
//    public static void main(String[] args) {
//
//        int choice;
//
//        do {
//
//            System.out.println("\n========================================");
//            System.out.println("       MOVIE TICKET BOOKING SYSTEM");
//            System.out.println("========================================");
//            System.out.println("1. Show Movie Availability");
//            System.out.println("2. Show Available Seats");
//            System.out.println("3. Book Ticket");
//            System.out.println("4. Cancel Ticket");
//            System.out.println("5. View Booking Details");
//            System.out.println("6. Rate Movie");
//            System.out.println("7. Show Movie Rating");
//            System.out.println("8. Exit");
//            System.out.println("========================================");
//
//            System.out.print("Enter your choice: ");
//            choice = sc.nextInt();
//
//            switch (choice) {
//
//                case 1:
//                    showMovieAvailability();
//                    break;
//
//                case 2:
//                    showAvailableSeats();
//                    break;
//
//                case 3:
//                    bookTicket();
//                    break;
//
//                case 4:
//                    cancelTicket();
//                    break;
//
//                case 5:
//                    viewBookingDetails();
//                    break;
//
//                case 6:
//                    rateMovie();
//                    break;
//
//                case 7:
//                    showMovieRating();
//                    break;
//
//                case 8:
//                    System.out.println("\nThank you for using the system!");
//                    break;
//
//                default:
//                    System.out.println("\nInvalid choice!");
//            }
//
//        } while (choice != 8);
//
//        sc.close();
//    }
//
//
//    // =====================================================
//    // 1. SHOW MOVIE AVAILABILITY
//    // =====================================================
//
//    static void showMovieAvailability() {
//
//        System.out.println("\n========== MOVIE AVAILABILITY ==========");
//
//        for (int i = 0; i < movies.length; i++) {
//
//            System.out.print((i + 1) + ". " + movies[i]);
//
//            if (movieAvailable[i]) {
//                System.out.println(" - Available");
//            } else {
//                System.out.println(" - Not Available");
//            }
//        }
//
//        System.out.println("========================================");
//    }
//
//
//    // =====================================================
//    // 2. SHOW AVAILABLE SEATS
//    // =====================================================
//
//    static void showAvailableSeats() {
//
//        showMovieAvailability();
//
//        System.out.print("\nSelect movie number: ");
//        int movieNumber = sc.nextInt();
//
//        if (!isValidMovie(movieNumber)) {
//            return;
//        }
//
//        int movieIndex = movieNumber - 1;
//
//        if (!movieAvailable[movieIndex]) {
//            System.out.println("Sorry! This movie is not available.");
//            return;
//        }
//
//        displaySeats(movieIndex);
//    }
//
//
//    // =====================================================
//    // DISPLAY SEATS
//    // =====================================================
//
//    static void displaySeats(int movieIndex) {
//
//        System.out.println("\n========== SEAT LAYOUT ==========");
//        System.out.println("Movie: " + movies[movieIndex]);
//        System.out.println();
//        System.out.println("       1   2   3   4   5   6   7   8");
//
//        for (int row = 0; row < seats[movieIndex].length; row++) {
//
//            System.out.print("Row " + (row + 1) + " ");
//
//            for (int seat = 0;
//                 seat < seats[movieIndex][row].length;
//                 seat++) {
//
//                if (seats[movieIndex][row][seat]) {
//                    System.out.print("[X] ");
//                } else {
//                    System.out.print("[O] ");
//                }
//            }
//
//            System.out.println();
//        }
//
//        System.out.println();
//        System.out.println("O = Available");
//        System.out.println("X = Booked");
//    }
//
//
//    // =====================================================
//    // 3. BOOK TICKET
//    // =====================================================
//
//    static void bookTicket() {
//
//        showMovieAvailability();
//
//        System.out.print("\nSelect movie number: ");
//        int movieNumber = sc.nextInt();
//
//        if (!isValidMovie(movieNumber)) {
//            return;
//        }
//
//        int movieIndex = movieNumber - 1;
//
//        if (!movieAvailable[movieIndex]) {
//
//            System.out.println(
//                    "Sorry! This movie is not available."
//            );
//
//            return;
//        }
//
//        System.out.println(
//                "\nSelected Movie: " + movies[movieIndex]
//        );
//
//        displaySeats(movieIndex);
//
//        sc.nextLine();
//
//        System.out.print("Enter customer name: ");
//        String customerName = sc.nextLine();
//
//        if (customerName.trim().isEmpty()) {
//
//            System.out.println("Customer name cannot be empty.");
//            return;
//        }
//
//        System.out.print("Enter number of tickets: ");
//        int ticketCount = sc.nextInt();
//
//        if (ticketCount <= 0) {
//
//            System.out.println(
//                    "Ticket count must be greater than 0."
//            );
//
//            return;
//        }
//
//        int availableSeats = countAvailableSeats(movieIndex);
//
//        if (ticketCount > availableSeats) {
//
//            System.out.println(
//                    "Not enough seats available."
//            );
//
//            System.out.println(
//                    "Available seats: " + availableSeats
//            );
//
//            return;
//        }
//
//
//        // =================================================
//        // WEEKEND PRICING
//        // =================================================
//
//        System.out.print(
//                "Is today weekend? (yes/no): "
//        );
//
//        String day = sc.next();
//
//        double ticketPrice;
//
//        if (day.equalsIgnoreCase("yes")) {
//
//            ticketPrice = weekendPrice;
//
//        } else if (day.equalsIgnoreCase("no")) {
//
//            ticketPrice = weekdayPrice;
//
//        } else {
//
//            System.out.println(
//                    "Please enter only yes or no."
//            );
//
//            return;
//        }
//
//
//        // Calculate total
//        double totalAmount = ticketPrice * ticketCount;
//
//
//        // =================================================
//        // DISCOUNT COUPON
//        // =================================================
//
//        double discount = 0.0;
//
//        System.out.print(
//                "Do you have a discount coupon? (yes/no): "
//        );
//
//        String couponChoice = sc.next();
//
//        if (couponChoice.equalsIgnoreCase("yes")) {
//
//            System.out.print("Enter coupon code: ");
//            String coupon = sc.next();
//
//            if (coupon.equalsIgnoreCase("MOVIE10")) {
//
//                discount = totalAmount * 10.0 / 100.0;
//
//                System.out.println(
//                        "10% discount applied."
//                );
//
//            } else if (coupon.equalsIgnoreCase("MOVIE20")) {
//
//                discount = totalAmount * 20.0 / 100.0;
//
//                System.out.println(
//                        "20% discount applied."
//                );
//
//            } else {
//
//                System.out.println(
//                        "Invalid coupon code."
//                );
//            }
//
//        } else if (!couponChoice.equalsIgnoreCase("no")) {
//
//            System.out.println(
//                    "Please enter only yes or no."
//            );
//
//            return;
//        }
//
//
//        // Final amount
//        double finalAmount = totalAmount - discount;
//
//
//        // =================================================
//        // SELECT SEATS
//        // =================================================
//
//        for (int i = 0; i < ticketCount; i++) {
//
//            System.out.println(
//                    "\nSelect seat " + (i + 1)
//            );
//
//            displaySeats(movieIndex);
//
//            System.out.print("Enter row number (1-5): ");
//            int row = sc.nextInt();
//
//            System.out.print("Enter seat number (1-8): ");
//            int seat = sc.nextInt();
//
//            if (row < 1 || row > 5 ||
//                    seat < 1 || seat > 8) {
//
//                System.out.println(
//                        "Invalid row or seat number."
//                );
//
//                i--;
//                continue;
//            }
//
//            int rowIndex = row - 1;
//            int seatIndex = seat - 1;
//
//            if (seats[movieIndex][rowIndex][seatIndex]) {
//
//                System.out.println(
//                        "This seat is already booked."
//                );
//
//                i--;
//
//            } else {
//
//                seats[movieIndex][rowIndex][seatIndex] = true;
//
//                customerNames[movieIndex][rowIndex][seatIndex]
//                        = customerName;
//
//                System.out.println(
//                        "Seat " + row + "-" + seat +
//                                " booked successfully."
//                );
//            }
//        }
//
//
//        // =================================================
//        // BOOKING SUMMARY
//        // =================================================
//
//        System.out.println("\n========================================");
//        System.out.println("             BOOKING SUMMARY");
//        System.out.println("========================================");
//
//        System.out.println(
//                "Customer Name : " + customerName
//        );
//
//        System.out.println(
//                "Movie         : " + movies[movieIndex]
//        );
//
//        System.out.println(
//                "Tickets       : " + ticketCount
//        );
//
//        System.out.printf(
//                "Ticket Price  : ₹%.2f%n",
//                ticketPrice
//        );
//
//        System.out.printf(
//                "Total Amount  : ₹%.2f%n",
//                totalAmount
//        );
//
//        System.out.printf(
//                "Discount      : ₹%.2f%n",
//                discount
//        );
//
//        System.out.printf(
//                "Final Amount  : ₹%.2f%n",
//                finalAmount
//        );
//
//        System.out.println("========================================");
//        System.out.println("        Booking Successful!");
//        System.out.println("========================================");
//    }
//
//
//    // =====================================================
//    // 4. CANCEL TICKET
//    // =====================================================
//
//    static void cancelTicket() {
//
//        showMovieAvailability();
//
//        System.out.print("\nSelect movie number: ");
//        int movieNumber = sc.nextInt();
//
//        if (!isValidMovie(movieNumber)) {
//            return;
//        }
//
//        int movieIndex = movieNumber - 1;
//
//        if (!movieAvailable[movieIndex]) {
//
//            System.out.println(
//                    "This movie is not available."
//            );
//
//            return;
//        }
//
//        displaySeats(movieIndex);
//
//        System.out.print("\nEnter row number: ");
//        int row = sc.nextInt();
//
//        System.out.print("Enter seat number: ");
//        int seat = sc.nextInt();
//
//        if (row < 1 || row > 5 ||
//                seat < 1 || seat > 8) {
//
//            System.out.println(
//                    "Invalid row or seat number."
//            );
//
//            return;
//        }
//
//        int rowIndex = row - 1;
//        int seatIndex = seat - 1;
//
//        if (!seats[movieIndex][rowIndex][seatIndex]) {
//
//            System.out.println(
//                    "This seat is not booked."
//            );
//
//            return;
//        }
//
//        System.out.println(
//                "Customer: " +
//                        customerNames[movieIndex][rowIndex][seatIndex]
//        );
//
//        System.out.print(
//                "Are you sure you want to cancel? (yes/no): "
//        );
//
//        String confirm = sc.next();
//
//        if (confirm.equalsIgnoreCase("yes")) {
//
//            seats[movieIndex][rowIndex][seatIndex] = false;
//
//            customerNames[movieIndex][rowIndex][seatIndex]
//                    = null;
//
//            System.out.println(
//                    "Ticket cancelled successfully."
//            );
//
//        } else if (confirm.equalsIgnoreCase("no")) {
//
//            System.out.println(
//                    "Cancellation cancelled."
//            );
//
//        } else {
//
//            System.out.println(
//                    "Please enter only yes or no."
//            );
//        }
//    }
//
//
//    // =====================================================
//    // 5. VIEW BOOKING DETAILS
//    // =====================================================
//
//    static void viewBookingDetails() {
//
//        System.out.println("\n========== BOOKING DETAILS ==========");
//
//        boolean found = false;
//
//        for (int movie = 0; movie < movies.length; movie++) {
//
//            for (int row = 0; row < seats[movie].length; row++) {
//
//                for (int seat = 0;
//                     seat < seats[movie][row].length;
//                     seat++) {
//
//                    if (seats[movie][row][seat]) {
//
//                        found = true;
//
//                        System.out.println(
//                                "Movie    : " +
//                                        movies[movie]
//                        );
//
//                        System.out.println(
//                                "Customer : " +
//                                        customerNames[movie][row][seat]
//                        );
//
//                        System.out.println(
//                                "Row      : " +
//                                        (row + 1)
//                        );
//
//                        System.out.println(
//                                "Seat     : " +
//                                        (seat + 1)
//                        );
//
//                        System.out.println(
//                                "----------------------------------"
//                        );
//                    }
//                }
//            }
//        }
//
//        if (!found) {
//
//            System.out.println(
//                    "No bookings available."
//            );
//        }
//    }
//
//
//    // =====================================================
//    // 6. RATE MOVIE
//    // =====================================================
//
//    static void rateMovie() {
//
//        showMovieAvailability();
//
//        System.out.print(
//                "\nSelect movie number: "
//        );
//
//        int movieNumber = sc.nextInt();
//
//        if (!isValidMovie(movieNumber)) {
//            return;
//        }
//
//        int movieIndex = movieNumber - 1;
//
//        if (!movieAvailable[movieIndex]) {
//
//            System.out.println(
//                    "This movie is not available."
//            );
//
//            return;
//        }
//
//        System.out.print(
//                "Enter rating for " +
//                        movies[movieIndex] +
//                        " (1-5): "
//        );
//
//        double rating = sc.nextDouble();
//
//        if (rating < 1 || rating > 5) {
//
//            System.out.println(
//                    "Rating must be between 1 and 5."
//            );
//
//            return;
//        }
//
//        totalRatings[movieIndex]
//                = totalRatings[movieIndex] + rating;
//
//        ratingCounts[movieIndex]++;
//
//        System.out.println(
//                "Thank you for rating the movie."
//        );
//    }
//
//
//    // =====================================================
//    // 7. SHOW MOVIE RATING
//    // =====================================================
//
//    static void showMovieRating() {
//
//        showMovieAvailability();
//
//        System.out.print(
//                "\nSelect movie number: "
//        );
//
//        int movieNumber = sc.nextInt();
//
//        if (!isValidMovie(movieNumber)) {
//            return;
//        }
//
//        int movieIndex = movieNumber - 1;
//
//        if (ratingCounts[movieIndex] == 0) {
//
//            System.out.println(
//                    "No ratings available for " +
//                            movies[movieIndex]
//            );
//
//            return;
//        }
//
//        double averageRating =
//                totalRatings[movieIndex]
//                        / ratingCounts[movieIndex];
//
//        System.out.println(
//                "\nMovie: " + movies[movieIndex]
//        );
//
//        System.out.printf(
//                "Average Rating: %.2f / 5%n",
//                averageRating
//        );
//
//        System.out.println(
//                "Total Ratings: " +
//                        ratingCounts[movieIndex]
//        );
//    }
//
//
//    // =====================================================
//    // COUNT AVAILABLE SEATS
//    // =====================================================
//
//    static int countAvailableSeats(int movieIndex) {
//
//        int count = 0;
//
//        for (int row = 0;
//             row < seats[movieIndex].length;
//             row++) {
//
//            for (int seat = 0;
//                 seat < seats[movieIndex][row].length;
//                 seat++) {
//
//                if (!seats[movieIndex][row][seat]) {
//
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
//
//
//    // =====================================================
//    // VALIDATE MOVIE NUMBER
//    // =====================================================
//
//    static boolean isValidMovie(int movieNumber) {
//
//        if (movieNumber < 1 ||
//                movieNumber > movies.length) {
//
//            System.out.println(
//                    "Invalid movie number."
//            );
//
//            return false;
//        }
//
//        return true;
//    }
//}

import java.util.Scanner;

public class MovieTicketBookingSystem {

    static Scanner sc = new Scanner(System.in);

    // Movie details
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

    // 2D ARRAY FOR SEATS
    // 5 rows and 8 seats
    static boolean[][] seats = new boolean[5][8];

    // Customer name for each seat
    static String[][] customerNames = new String[5][8];

    // Selected movie
    static String selectedMovie = "";

    // Ticket prices
    static double weekdayPrice = 150.0;
    static double weekendPrice = 200.0;

    // Movie rating
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


    // =====================================================
    // 1. SHOW MOVIE AVAILABILITY
    // =====================================================

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


    // =====================================================
    // 2. SHOW AVAILABLE SEATS
    // =====================================================

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


    // =====================================================
    // DISPLAY SEATS
    // =====================================================

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


    // =====================================================
    // 3. BOOK TICKET
    // =====================================================

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


        // =================================================
        // WEEKEND PRICING
        // =================================================

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


        // Total amount
        double totalAmount =
                ticketPrice * ticketCount;


        // =================================================
        // DISCOUNT COUPON
        // =================================================

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


        // Final amount
        double finalAmount =
                totalAmount - discount;


        // =================================================
        // SELECT SEATS
        // =================================================

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


            // Check row and seat
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


            // Check whether seat is booked
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


        // =================================================
        // BOOKING SUMMARY
        // =================================================

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


    // =====================================================
    // 4. CANCEL TICKET
    // =====================================================

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


    // =====================================================
    // 5. VIEW BOOKING DETAILS
    // =====================================================

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


    // =====================================================
    // 6. RATE MOVIE
    // =====================================================

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


    // =====================================================
    // 7. SHOW MOVIE RATING
    // =====================================================

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


    // =====================================================
    // COUNT AVAILABLE SEATS
    // =====================================================

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


    // =====================================================
    // FIND MOVIE
    // =====================================================

    static int findMovie(String movieName) {

        for (int i = 0; i < movies.length; i++) {

            if (movies[i].equalsIgnoreCase(movieName)) {

                return i;
            }
        }

        return -1;
    }
}