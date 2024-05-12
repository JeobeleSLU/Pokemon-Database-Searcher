import java.util.ArrayList;

public class Process {
    private int pid;
    private int arrivalTime;
    private int burstTime;
    private int priority;
    private volatile boolean isRunning;
    private int timesExecuted;
    private int timeStarted ;
    private int timeEnd;
    private boolean hasExecuted;
    private String idle;

    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        timesExecuted = 0;
        isRunning = false;
        hasExecuted = false;

    }
    public Process(String idle, int arrivalTime, int burstTime, int priority) {
        this.idle = idle;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        timesExecuted = 0;
        isRunning = false;
        hasExecuted = false;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setTimeStarted(int timeStarted) {
        this.timeStarted = timeStarted;
    }

    public int getTimesExecuted() {
        return timesExecuted;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }


    public Process() {
        this.pid = 0;
        this.arrivalTime = 0;
        this.burstTime = 0;
        this.priority = 0;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    void updatePriority(){
        this.hasExecuted = true;
        timesExecuted++;
        if (timesExecuted == 5){
            priority--;
            timesExecuted = 0;
        }
        if (priority < 0 ){
            this.priority = 1;

        }else if (priority > 3){
            this.priority =3;
        }
    }

    public int getTimeStarted() {
        return timeStarted;
    }

    public int getTimeEnd() {
        return timeEnd;
    }


    void lowerPriority(){
        this.hasExecuted = true;
        timesExecuted++;
        if (timesExecuted == 5){
            priority++;
            timesExecuted = 0;
        }
        if (priority < 0 ){
            this.priority = 1;

        }else if (priority > 3){
            this.priority =3;
        }
    }
    boolean getHasExecuted() {
        return hasExecuted;
    }
}
