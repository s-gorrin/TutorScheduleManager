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

        for (WeekDays day : WeekDays.values())
            System.out.printf("%s: %.2f\n", day, weekly.getHoursFromDay(day));
    }

    public static void main(String[] args) {
        TutorSchedule weekly = new TutorSchedule(new double[]{3, 1.75, 0, 1.75, 0, 0, 0},
                                            new WorkType[]{WorkType.LRC,
                                                           WorkType.EMBED,
                                                           WorkType.NONE,
                                                           WorkType.EMBED,
                                                           WorkType.NONE,
                                                           WorkType.NONE,
                                                           WorkType.NONE},
                                            "Seth Gorrin", 10769298, "CIS", true, true);


        System.out.printf("Total hours per week: %.2f\n", ((Schedule)weekly).getHoursPerWeek());
        System.out.printf("LRC hours per week: %.2f\n", weekly.getHoursPerWeek(WorkType.LRC));
        System.out.printf("Embedded hours per week: %.2f\n", weekly.getHoursPerWeek(WorkType.EMBED));
        System.out.println();
        printSchedule(weekly);

    }
}
