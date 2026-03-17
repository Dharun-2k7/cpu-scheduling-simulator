import java.util.*;

class SJF {

    public static void run(ArrayList<Process> p) {

        System.out.println("\n=== SJF (Shortest Job First) ===");

        System.out.println("\nConcept:");
        System.out.println("- Process with smallest burst time is selected");
        System.out.println("- Non-preemptive scheduling");
        System.out.println("- Minimizes average waiting time");

        System.out.println("\nDrawback:");
        System.out.println("- Long processes may starve");

        System.out.println("\n--- Starting Simulation ---");

        int n = p.size();
        boolean[] done = new boolean[n];
        int completed = 0, time = 0;

        while (completed < n) {

            System.out.println("\nTime " + time + ":");

            ArrayList<Process> available = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (!done[i] && p.get(i).at <= time) {
                    available.add(p.get(i));
                }
            }

            // Print ready queue
            System.out.print("  Ready Queue: ");
            if (available.isEmpty()) System.out.print("EMPTY");
            else for (Process pr : available) System.out.print("P" + pr.pid + " ");
            System.out.println();

            int idx = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!done[i] && p.get(i).at <= time && p.get(i).bt < min) {
                    min = p.get(i).bt;
                    idx = i;
                }
            }

            if (idx == -1) {
                System.out.println("  CPU Idle");
                time++;
                continue;
            }

            Process x = p.get(idx);

            System.out.println("  Selected: P" + x.pid);
            System.out.println("  Running till completion...");

            time += x.bt;

            x.ct = time;
            x.tat = x.ct - x.at;
            x.wt = x.tat - x.bt;

            System.out.println("  Completed at time " + time);

            done[idx] = true;
            completed++;
        }

        OutputHandler.printTable(p);
        OutputHandler.printAvg(p);
    }
}
