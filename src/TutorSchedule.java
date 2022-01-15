/*
 * Name: Seth Gorrin
 * Class: CS 622
 * Project: Tutor Schedule Manager
 * Date: 15 January 2022
 * File: TutorSchedule.java
 */

public class TutorSchedule extends Schedule implements Tutor {
    private final WorkType[] typePerDay = new WorkType[Schedule.DAYS];

    private String name;
    private int ID;
    private String department;
    private boolean embedded;
    private boolean LRC;

    public TutorSchedule() {
        super();
        for (int i = 0; i < Schedule.DAYS; i++)
            typePerDay[i] = WorkType.NONE;

        name = null;
        ID = 0;
        department = null;
        embedded = false;
        LRC = false;
    }

    public TutorSchedule(String name, int ID, String department, boolean embedded, boolean LRC) {
        super();
        for (int i = 0; i < Schedule.DAYS; i++)
            typePerDay[i] = WorkType.NONE;

        this.name = name;
        this.ID = ID;
        this.department = department;
        this.embedded = embedded;
        this.LRC = LRC;
    }

    public TutorSchedule(double[] inputHours) {
        super(inputHours);
        for (int i = 0; i < Schedule.DAYS; i++) {
            typePerDay[i] = WorkType.NONE;
        }

        name = null;
        ID = 0;
        department = null;
        embedded = false;
        LRC = false;
    }

    public TutorSchedule(double[] inputHours, WorkType[] inputType,
                         String name, int ID, String department, boolean embedded, boolean LRC) {
        super(inputHours);
        System.arraycopy(inputType, 0, typePerDay, 0, Schedule.DAYS);

        this.name = name;
        this.ID = ID;
        this.department = department;
        this.embedded = embedded;
        this.LRC = LRC;
    }

    public WorkType getTypeFromDay(int day) {
        // POST-CONDITION: type of work for a given day-by-int is returned
        return typePerDay[day];
    }

    public WorkType getTypeFromDay(WeekDays day) {
        // POST-CONDITION: type of work for a given day is returned
        return typePerDay[day.ordinal()];
    }

    public double getHoursPerWeek(WorkType type) {
        // POST-CONDITION: total number of hours per week of a certain type is returned
        double result = 0;

        for (int i = 0; i < Schedule.DAYS; i++) {
            if (getTypeFromDay(i) == type)
                result += getHoursFromDay(i);
        }

        return result;
    }

    // Setters
    public void setTypePerDay(WorkType[] inputType) {
        embedded = false;
        LRC = false;

        for (int i = 0; i < Schedule.DAYS; i++) {
            typePerDay[i] = inputType[i];
            if (inputType[i] == WorkType.EMBED)
                embedded = true;
            if (inputType[i] == WorkType.LRC)
                LRC = true;
        }
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

    public String getName() {
        return name;
    }



}
