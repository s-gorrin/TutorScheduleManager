public class Main {
    public static void main(String[] args) {
        Schedule skeddy = new Schedule(new double[]{3, 1.75, 0, 1.75, 0, 0, 0});

        System.out.printf("Total hours per week: %.2f\n", skeddy.getHoursPerWeek());
        System.out.printf("Monday hours: %.2f\n", skeddy.getHoursFromDay(WeekDays.MONDAY));

    }
}
