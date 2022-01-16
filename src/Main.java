/*
 * Name: Seth Gorrin
 * Class: CS 622
 * Project: Tutor Schedule Manager
 * Date: 15 January 2022
 * File: Main.java
 */


public class Main {

    public static void printSchedule(TutorSchedule weekly) {
        // POST-CONDITION: a printout of the weekly schedule with tutor info is on the console
        System.out.printf("Hours per day for %s\n", weekly.getName());

        // Print each line with day title-capitalized and left aligned with 11 characters in the first column
        for (WeekDays enumDay : WeekDays.values()) {
            String day = enumDay.toString().charAt(0) + enumDay.toString().substring(1).toLowerCase();

            System.out.printf("%-11s-  %.2f\n", day, weekly.getHoursFromDay(enumDay, WorkType.BOTH));
        }
    }

    public static void main(String[] args) {
        TutorSchedule weekly = new TutorSchedule(new double[]{3, 0, 0, 0, 0, 0, 0},
                                                 new double[]{0, 1.75, 0, 1.75, 0, 0, 0},
                                            "Seth Gorrin", 10769298, "CIS");


        System.out.printf("Total hours per week: %.2f\n", ((Schedule)weekly).getHoursPerWeek());
        System.out.printf("LRC hours per week: %.2f\n", weekly.getHoursPerWeek(WorkType.LRC));
        System.out.printf("Embedded hours per week: %.2f\n", weekly.getHoursPerWeek(WorkType.EMBED));
        System.out.println();
        printSchedule(weekly);

    }
}
