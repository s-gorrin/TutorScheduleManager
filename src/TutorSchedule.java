/*
 * Name: Seth Gorrin
 * Class: CS 622
 * Project: Tutor Schedule Manager
 * Date: 15 January 2022
 * File: TutorSchedule.java
 */

public class TutorSchedule extends Schedule implements Tutor {
    private final double[] embedHoursPerDay = new double[Schedule.DAYS];

    private String name;
    private int ID;
    private String department;
    private boolean embedded;
    private boolean LRC;


    // Constructors
    public TutorSchedule() {
        // No inputs, set everything to default values
        super();
        for (int i = 0; i < Schedule.DAYS; i++)
            embedHoursPerDay[i] = 0;

        name = null;
        ID = 0;
        department = null;
        embedded = false;
        LRC = false;
    }

    public TutorSchedule(String name, int ID, String department) {
        // Set Tutor information but no schedule information
        super();
        for (int i = 0; i < Schedule.DAYS; i++)
            embedHoursPerDay[i] = 0;

        this.name = name;
        this.ID = ID;
        this.department = department;
        embedded = false;
        LRC = false;
    }

    public TutorSchedule(double[] hoursLRC, double[] hoursEmbed) {
        // Set schedule hours but no Tutor information
        super(hoursLRC);
        System.arraycopy(hoursEmbed, 0, embedHoursPerDay, 0, Schedule.DAYS);

        name = null;
        ID = 0;
        department = null;
        embedded = getHoursPerWeek(WorkType.EMBED) > 0;
        LRC = getHoursPerWeek(WorkType.LRC) > 0;
    }

    public TutorSchedule(double[] hoursLRC, double[] hoursEmbed, String name, int ID, String department) {
        // Set all variables with passed-in input
        super(hoursLRC);
        System.arraycopy(hoursEmbed, 0, embedHoursPerDay, 0, Schedule.DAYS);

        this.name = name;
        this.ID = ID;
        this.department = department;
        embedded = getHoursPerWeek(WorkType.EMBED) > 0;
        LRC = getHoursPerWeek(WorkType.LRC) > 0;
    }


    // Setters
    public void setEmbedHoursPerDay(double[] hoursEmbed) {
        System.arraycopy(hoursEmbed, 0, embedHoursPerDay, 0, Schedule.DAYS);

        embedded = getHoursPerWeek(WorkType.EMBED) > 0;
    }

    public void setLRCHoursPerDay(double[] inputHours) {
        super.setHoursPerDay(inputHours);

        LRC = getHoursPerWeek(WorkType.LRC) > 0;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setType(boolean embedded, boolean LRC) {
        this.embedded = embedded;
        this.LRC = LRC;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public String getDepartment() {
        return department;
    }
    public boolean getEmbedded() {
        return embedded;
    }
    public boolean getLRC() {
        return LRC;
    }

    public double getHoursFromDay(int day, WorkType type) {
        // POST-CONDITION: embedded hours per day is returned from a day-by-int
        if (type == WorkType.BOTH)
            return super.getHoursFromDay(day) + embedHoursPerDay[day];
        if (type == WorkType.LRC)
            return super.getHoursFromDay(day);
        if (type == WorkType.EMBED)
            return embedHoursPerDay[day];
        return 0;
    }

    public double getHoursFromDay(WeekDays day, WorkType type) {
        // POST-CONDITION: embedded hours per day is returned from a WeekDay
        if (type == WorkType.BOTH)
            return super.getHoursFromDay(day) + embedHoursPerDay[day.ordinal()];
        if (type == WorkType.LRC)
            return super.getHoursFromDay(day);
        if (type == WorkType.EMBED)
            return embedHoursPerDay[day.ordinal()];
        return 0;
    }

    public WorkType getTypeFromDay(int day) {
        // POST-CONDITION: type of work for a given day-by-int is returned
        WorkType result = WorkType.NONE;
        double LRC = super.getHoursFromDay(day);
        double embed = this.getHoursFromDay(day);

        if (LRC > 0 && embed > 0)
            result = WorkType.BOTH;
        else if (LRC > 0)
            result = WorkType.LRC;
        else if (embed > 0)
            result = WorkType.EMBED;

        return result;
    }

    public double getHoursPerWeek() {
        // POST-CONDITION: total hours per week from both work types is returned
        double result = 0;

        for (double hours : embedHoursPerDay)
            result += hours;

        return result + super.getHoursPerWeek();
    }

    public double getHoursPerWeek(WorkType type) {
        // POST-CONDITION: total number of hours per week of the requested work type is returned
        double result = 0;

        if (type == WorkType.BOTH)
            return this.getHoursPerWeek();

        if (type == WorkType.LRC)
            for (double hours : embedHoursPerDay)
                result += hours;

        if (type == WorkType.EMBED)
            result = super.getHoursPerWeek();

        return result;
    }
}
