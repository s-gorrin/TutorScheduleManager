public class TutorSchedule extends Schedule {
    private final WorkType[] typePerDay = new WorkType[Schedule.DAYS];

    public TutorSchedule() {
        super();
        for (int i = 0; i < Schedule.DAYS; i++) {
            typePerDay[i] = WorkType.NOT_WORKING;
        }
    }

    public TutorSchedule(double[] inputHours) {
        super(inputHours);
        for (int i = 0; i < Schedule.DAYS; i++) {
            typePerDay[i] = WorkType.NOT_WORKING;
        }
    }

    public TutorSchedule(double[] inputHours, WorkType[] inputType) {
        super(inputHours);
        System.arraycopy(inputType, 0, typePerDay, 0, Schedule.DAYS);
    }

    public WorkType getTypeFromDay(int day) {
        // POST-CONDITION: type of work for a given day-by-int is returned
        return typePerDay[day];
    }

    public WorkType getTypeFromDay(WeekDays day) {
        // POST-CONDITION: type of work for a given day is returned
        return typePerDay[day.ordinal()];
    }
}
