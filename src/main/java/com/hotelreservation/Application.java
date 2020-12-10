package com.hotelreservation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Application {
    Scanner scanner = new Scanner(System.in);
    HotelManagementSystem hotelManagementSystem = new HotelManagementSystem();

    public static void main(String[] args) throws ParseException {

        System.out.println("Welcome to Hotel Reservation System");

        Application application = new Application();
        application.provideUserOption();
    }

    public void provideUserOption() throws ParseException {
        while (true) {
            System.out.println("Choose Options " +
                    "\n1. Add Hotel" +
                    "\n2. Find Cheapest Hotel " +
                    "\n3. find best rated cheapest hotel");
            String userOption = scanner.next();
            switch (userOption) {
                case "1":
                    addHotel();
                    break;
                case "2":
                    findCheapestHotel();
                case "3":
                    findCheapestHotel1();
                    break;
                case "10":
                    System.exit(0);
            }
        }
    }

    public void addHotel() {
        Hotel hotel = new Hotel();
        System.out.println("Enter Hotel Name");
        String name = scanner.next();
        System.out.println("Enter weekday rate ");
        float rate = scanner.nextFloat();
        System.out.println("Enter weekend rate");
        float weekendRate = scanner.nextFloat();
        System.out.println("Enter rating for hotel");
        int rating = scanner.nextInt();
        System.out.println("Enter rate for reward customer");
        float rateForRewardCustomer = scanner.nextFloat();

        hotel.setName(name);
        hotel.setRate(rate);
        hotel.setWeekendRate(weekendRate);
        hotel.setRating(rating);
        hotelManagementSystem.hotelList.add(hotel);
        System.out.println(hotelManagementSystem.hotelList + "\n");
    }

    public void findCheapestHotel() throws ParseException {

        System.out.println("Enter check-In Date : (dd/mm/yyyy)");
        String checkInDate = scanner.next();
        System.out.println("Enter check-Out Date : (dd/mm/yyyy)");
        String checkOutDate = scanner.next();

        String Day1 = hotelManagementSystem.findDayOfWeek(checkInDate);
        String Day2 = hotelManagementSystem.findDayOfWeek(checkOutDate);

        int days = hotelManagementSystem.findDateDifference(checkInDate, checkOutDate);
        System.out.println("Number of days stying in hotel " + days);

        Hotel cheapestHotel = hotelManagementSystem.findCheapestHotel(days);
        float totalRate = cheapestHotel.getRate() * days;

        Hotel cheapestHotel2 = hotelManagementSystem.findCheapestHotel(days);
        float totalWeekendRate = cheapestHotel.getWeekendRate() * 2;

        if (Day1.equalsIgnoreCase("Saturday") | Day1.equalsIgnoreCase("Sunday") | Day2.equalsIgnoreCase("Saturday") | Day2.equalsIgnoreCase("Sunday")) {
            System.out.println("Best hotel availble on weekend  " + cheapestHotel.getName() + " having rate $" + totalWeekendRate);
        } else {
            System.out.println("Cheapest hotel is " + cheapestHotel2.getName() + " having rate $" + totalRate);
        }
    }

    public void findCheapestHotel1() throws ParseException {

        System.out.println("Enter check-In Date : (dd/mm/yyyy)");
        String checkInDate = scanner.next();
        System.out.println("Enter check-Out Date : (dd/mm/yyyy)");
        String checkOutDate = scanner.next();

        String Day1 = hotelManagementSystem.findDayOfWeek(checkInDate);
        String Day2 = hotelManagementSystem.findDayOfWeek(checkOutDate);

        int days = hotelManagementSystem.findDateDifference(checkInDate, checkOutDate);
        System.out.println("Number of days stying in hotel " + days);

        Hotel cheapestHotel = hotelManagementSystem.findCheapestHotel(days);
        float totalRate = cheapestHotel.getRate() * days;

        ArrayList<Hotel> bestRatedList = new ArrayList<Hotel>();
        for (Hotel hotel : hotelManagementSystem.hotelList) {

            if (hotel.getRating() >= 4) {
                bestRatedList.add(hotel);
            }
        }
        System.out.println("\n All Best rated hotel is :" +bestRatedList +"\n");
        System.out.println("Best rated hotel which have really less cost is : \n");
        System.out.println("You can choose any 1 of this best rated hotel \n");
        bestRatedList.stream();
        bestRatedList.sort(Comparator.comparing(Hotel::getRate));
        bestRatedList.forEach((Hotel H) -> System.out.println("HotelName = " +H.getName() + ", Hotel Rate = "+ H.getRate() + ", Hotel Rating = " + H.getRating()));
        System.out.println("-------------------------------------------------");
    }
}