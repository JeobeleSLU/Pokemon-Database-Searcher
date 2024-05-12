import java.util.ArrayList;

public class SRTF implements Runnable,Sorter,Scheduler {
    private ArrayList<Process> readyQueue = new ArrayList<>();
    private ArrayList<Process> processToQueue = new ArrayList<>();
    private GanttChart ganttChart;

    public SRTF(ArrayList<Process> processes) {
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
        int idleStart = 0;
        int idleEnd = 0;
        boolean isIdling =false;
        try{

        while (!processToQueue.isEmpty() || !readyQueue.isEmpty()) {

            // Add arriving processes to ready queue
            for (Process process : processToQueue) {
                if (process.getArrivalTime() == timer) {
                    readyQueue.add(process);
                }
            }
            processToQueue.removeAll(readyQueue);
            readyQueue = Sorter.sortByBurstTime(readyQueue);

            if (!readyQueue.isEmpty()) {
                idleEnd = timer;
                Process currentProcess = readyQueue.get(0);
                if (!currentProcess.getHasExecuted()){
                    currentProcess.setTimeStarted(timer);
                    ganttChart.addProcess(currentProcess);
                }
                System.out.println("SRTF"+"Executing process " + currentProcess.getPid() + " at time " + timer);
                currentProcess.updatePriority();
                Thread.sleep(50);
                currentProcess.setBurstTime(currentProcess.getBurstTime() - 1);
                if (currentProcess.getBurstTime() == 0) {
                    System.out.println("Process " + currentProcess.getPid() + " completed at time " + timer);
                    readyQueue.remove(currentProcess);
                    currentProcess.setTimeEnd(timer);
                }
            } else {
                if(!isIdling){
                    idleStart = timer;
                }
                isIdling = true;
                String idleName= "Idle";
                System.out.println("Idling at time " + timer);
                Process process = new Process(idleName,timer,0,-1);
            }
            timer++;
        }
    }catch (InterruptedException e){

        }
    }


    public ArrayList<Process> getGanttChartArray() {
        return this.ganttChart.getProcesses();
    }

    /*todo: Create a functionality that first try to organize the list by arrival time
        using a loop check everytime if arrival time is == current time -> put the process
        that is inside an arraylist that is on ready queue then sort the process based on the
        remaining time. if the process have less remaining time then execute it
        then if it executed for 5 times it should increase priority
        */
    }


