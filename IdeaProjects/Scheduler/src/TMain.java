import java.util.ArrayList;
import java.util.Random;

public class TMain {
    public static void main(String[] args) {
        // Create processes
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 0, 6, 2));
        processes.add(new Process(2, 1, 5, 1));
        processes.add(new Process(3, 2, 4, 3));
        processes.add(new Process(1, 999, 53, 2));
        processes.add(new Process(2, 1000, 20, 1));
        processes.add(new Process(3, 1000, 33, 3));
        processes.add(new Process(4, 993, 99, 3));
        processes.add(new Process(5, 1000, 41, 2));
        processes.add(new Process(6, 999, 53, 2));
        processes.add(new Process(7, 1000, 20, 1));
        processes.add(new Process(8, 1000, 33, 1));
        processes.add(new Process(9, 993, 99, 1));
        processes.add(new Process(10, 1000, 41, 3));


        // Create dispatcher
        Dispatcher dispatcher = new Dispatcher(processes);

        // Start scheduling algorithms
        Thread sjfThread = new Thread(dispatcher.getSJFScheduler());
        Thread srtfThread = new Thread(dispatcher.getSRTFScheduler());
        Thread rrThread = new Thread(dispatcher.getRoundRobinScheduler());

        sjfThread.start();
        rrThread.start();
        srtfThread.start();
        if (srtfThread.isInterrupted()){
            System.out.println("SJF thread interrupted");
        }
    }
}
