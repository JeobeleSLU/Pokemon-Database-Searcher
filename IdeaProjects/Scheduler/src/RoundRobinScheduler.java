import java.util.ArrayList;

public class RoundRobinScheduler implements Scheduler {
    private final int quantumTime = 3;
    ArrayList<Process> readyQueue = new ArrayList<>();
    ArrayList<Process> processToQueue = new ArrayList<>();

    public RoundRobinScheduler(ArrayList<Process> processes) {
        this.processToQueue.addAll(processes);
        ganttChart = new GanttChart();
    }
    public void addToQueue(Process process) {
        readyQueue.add(process);
    }

    public void removeFromQueue(Process process) {
        readyQueue.remove(process);
    }
    private GanttChart ganttChart;


    @Override
    public void run() {
        int timer = 0;
        int quantumTimer = 0;
        int quantumCounter = 0;


        while (!readyQueue.isEmpty() || !processToQueue.isEmpty()) {

            // Add arriving processes to ready queue
            int finalTimer = timer;
            readyQueue.addAll(processToQueue.stream()
                    .filter(process -> process.getArrivalTime() == finalTimer)
                    .toList());
            processToQueue.removeAll(readyQueue);

            if (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.get(0);
                System.out.println("rr"+"Executing process " + currentProcess.getPid() + " at time " + timer);
                currentProcess.lowerPriority();
                System.out.println(currentProcess.getPriority());
                currentProcess.setBurstTime(currentProcess.getBurstTime() - 1);

                quantumTimer++;
                if (quantumTimer == quantumTime || currentProcess.getBurstTime() == 0) {
                    quantumTimer = 0;
                    quantumCounter++;
                    if (quantumCounter == 5) {
                        currentProcess.updatePriority();
                        quantumCounter = 0;
                    }
                    if (currentProcess.getBurstTime() == 0) {
                        System.out.println("Process " + currentProcess.getPid() + " completed at time " + timer);
                        readyQueue.remove(currentProcess);
                    } else {
                        readyQueue.remove(currentProcess);
                        readyQueue.add(currentProcess);
                    }
                }
            } else {
                System.out.println("Idling at time " + timer);
            }
            timer++;

        }
    }
    public ArrayList<Process> getGanttChartArray() {
        return this.ganttChart.getProcesses();
    }
}
