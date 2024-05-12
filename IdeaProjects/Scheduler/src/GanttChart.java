import java.util.ArrayList;

public class GanttChart {
    private ArrayList<Process> processes;


    public GanttChart() {
        processes = new ArrayList<>();

    }

    public void addProcess(Process process) {
        processes.add(process);
    }

    public ArrayList<Process> getProcesses() {
        return processes;
    }

    public void displayChart() {
        System.out.println("Gantt Chart:");
        for (int i = 0; i < processes.size(); i++) {
            Process process = processes.get(i);

            System.out.println("Process " + process.getPid() + ": " + process.getTimeStarted() + " - " + process.getTimeEnd());
        }
    }
}
