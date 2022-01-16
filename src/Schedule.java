/*
 * Name: Seth Gorrin
 * Class: CS 622
 * Project: Tutor Schedule Manager
 * Date: 15 January 2022
 * File: Schedule.java
 */

public abstract class Schedule {
    public static final int DAYS = 7;

    private final double[] hoursPerDay = new double[DAYS];

    public Schedule() {
        for (int i = 0; i < DAYS; i++)
            hoursPerDay[i] = 0;
    }

    public Schedule(double[] inputWeek) {
        System.arraycopy(inputWeek, 0, hoursPerDay, 0, DAYS);
    }

    public double getHoursFromDay(int day) {
        // POST-CONDITION: the number of hours corresponding with the given day-by-int was returned
        return hoursPerDay[day];
    }
    public double getHoursFromDay(WeekDays day) {
        // POST-CONDITION: the number of hours corresponding with the given day was returned
        return hoursPerDay[day.ordinal()];
    }

    public double getHoursPerWeek() {
        // POST-CONDITION: the sum of all the hours for the week was returned
        double result = 0;

        for (double day : hoursPerDay)
            result += day;

        return result;
    }

    public void setHoursPerDay(double[] inputHours) {
        System.arraycopy(inputHours, 0, hoursPerDay, 0, DAYS);
    }

}
