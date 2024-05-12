import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main implements Sorter{
    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
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

            ArrayList<Process> rrArray = Sorter.sortByPriority(processes, 1);
        ArrayList<Process> srtfArray = processes.stream()
                .filter(p -> p.getPriority() == 2)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Process> sjfArray = processes.stream()
                .filter(p -> p.getPriority() == 3)
                .collect(Collectors.toCollection(ArrayList::new));


        /*
        *Todo: sort the array list based on the priority then it should spit out the priority
        * if it isnt == to that priority based on the scheduling it should remove that process
        * and revalidate the priority and sort it based on the priority
        *
        */
        RoundRobinScheduler rr = new RoundRobinScheduler(rrArray);
        SJF shortest = new SJF(sjfArray);
        SRTF shortesremain = new SRTF(srtfArray);

        Thread thread1 = new Thread(rr);
        Thread thread2 = new Thread(shortesremain);
        Thread thread3 = new Thread(shortest);

        thread1.start();
        thread2.start();
        thread3.start();


//        SJF sjf = new SJF(processes);
//        sjf.run();
//        SRTF srtf = new SRTF(processes);
//        srtf.run();

//        rrs.run();


    }
}