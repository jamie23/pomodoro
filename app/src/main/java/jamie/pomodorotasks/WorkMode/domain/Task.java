package jamie.pomodorotasks.WorkMode.domain;

import org.joda.time.DateTime;

public class Task {
    private String name;
    private DateTime startTime;
    private int pomodoros;

    public Task(String name, DateTime startTime) {
            this.name = name;
            this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public DateTime getStartTime() {
        return startTime;
    }
}
