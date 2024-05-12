import java.util.ArrayList;
import java.util.Comparator;

public class SJF implements Runnable, Sorter,Scheduler {
    private ArrayList<Process> readyQueue = new ArrayList<>();
    private ArrayList<Process> processToQueue = new ArrayList<>();
    private GanttChart ganttChart;

    public SJF(ArrayList<Process> processes) {
        this.processToQueue.addAll(processes);
        ganttChart = new GanttChart();

    }
    public void addToQueue(Process process) {
        readyQueue.add(process);
    }

    public void removeFromQueue(Process process) {
        readyQueue.remove(process);
    }

    @Override
    public void run() {
        int timer = 0;

        while (!processToQueue.isEmpty() || !readyQueue.isEmpty()) {
            // Add arriving processes to ready queue
            int finalTimer = timer;
            readyQueue.addAll(processToQueue.stream()
                    .filter(process -> process.getArrivalTime() == finalTimer)
                    .toList());
            processToQueue.removeAll(readyQueue);

            if (!readyQueue.isEmpty()) {
                readyQueue.sort(Comparator.comparingInt(Process::getBurstTime)); // Sort by burst time
                Process currentProcess = readyQueue.get(0);
                if (!currentProcess.getHasExecuted()){
                    currentProcess.setTimeStarted(timer);
                    ganttChart.addProcess(currentProcess);
                }
                System.out.println("SJF"+"Executing process " + currentProcess.getPid() + " at time " + timer);

                currentProcess.updatePriority();
                while (currentProcess.getBurstTime() > 0) {
                    currentProcess.setBurstTime(currentProcess.getBurstTime() - 1);
                }
                System.out.println("Process " + currentProcess.getPid() + " completed at time " + timer);
                readyQueue.remove(currentProcess);
            } else {
                System.out.println("Idling at time " + timer);
            }
            timer++; // Increment the timer outside the if-else block
        }
    }
    public ArrayList<Process> getGanttChartArray() {
        return this.ganttChart.getProcesses();
    }
}
