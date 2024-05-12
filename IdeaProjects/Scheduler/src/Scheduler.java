public interface Scheduler extends Runnable {
    void addToQueue(Process process);

    void removeFromQueue(Process process);
}