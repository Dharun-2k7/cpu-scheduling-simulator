import java.util.*;

class FCFS {

    public static void run(ArrayList<Process> p) {

        System.out.println("\n=== FCFS (First Come First Serve) ===");

        System.out.println("\nConcept:");
        System.out.println("- Processes execute in order of arrival");
        System.out.println("- Non-preemptive scheduling");
        System.out.println("- Once started, process runs till completion");

        System.out.println("\nReal-world Example:");
        System.out.println("- Like people waiting in a queue");

        System.out.println("\n--- Starting Simulation ---");

        p.sort(Comparator.comparingInt(a -> a.at));

        Queue<Process> ready = new LinkedList<>();

        int time = 0, completed = 0, n = p.size(), index = 0;
        Process current = null;
        int remaining = 0;

        while (completed < n) {

            while (index < n && p.get(index).at == time) {
                ready.add(p.get(index));
                index++;
            }

            System.out.println("\nTime " + time + ":");

            // Ready Queue
            System.out.print("  Ready Queue: ");
            if (ready.isEmpty()) System.out.print("EMPTY");
            else for (Process pr : ready) System.out.print("P" + pr.pid + " ");
            System.out.println();

            // Select process
            if (current == null && !ready.isEmpty()) {
                current = ready.poll();
                remaining = current.bt;
                System.out.println("  Selected: P" + current.pid);
            }

            // Execute
            if (current != null) {
                System.out.println("  Running: P" + current.pid + " (remaining: " + remaining + ")");
                remaining--;

                if (remaining == 0) {
                    current.ct = time + 1;
                    current.tat = current.ct - current.at;
                    current.wt = current.tat - current.bt;

                    System.out.println("  Completed: P" + current.pid);

                    current = null;
                    completed++;
                }
            } else {
                System.out.println("  CPU Idle");
            }

            time++;
        }

        OutputHandler.printTable(p);
        OutputHandler.printAvg(p);
    }
}
