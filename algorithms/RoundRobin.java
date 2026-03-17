import java.util.*;

class RoundRobin {

    public static void run(ArrayList<Process> p, int tq) {

        System.out.println("\n=== Round Robin Scheduling ===");

        System.out.println("\nConcept:");
        System.out.println("- Each process gets fixed time quantum");
        System.out.println("- Preemptive scheduling");
        System.out.println("- Ensures fairness");

        System.out.println("\n--- Starting Simulation ---");

        int n = p.size();
        int[] rem = new int[n];

        for (int i = 0; i < n; i++)
            rem[i] = p.get(i).bt;

        Queue<Integer> q = new LinkedList<>();
        boolean[] inQueue = new boolean[n];

        int time = 0;
        q.add(0);
        inQueue[0] = true;

        while (!q.isEmpty()) {

            int i = q.poll();
            Process x = p.get(i);

            System.out.println("\nTime " + time + ":");

            System.out.print("  Ready Queue: ");
            for (int idx : q) System.out.print("P" + p.get(idx).pid + " ");
            System.out.println();

            System.out.println("  Selected: P" + x.pid);

            if (rem[i] > tq) {
                System.out.println("  Running for " + tq + " units");
                rem[i] -= tq;
                time += tq;
            } else {
                System.out.println("  Running till completion");
                time += rem[i];
                rem[i] = 0;

                x.ct = time;
                x.tat = x.ct - x.at;
                x.wt = x.tat - x.bt;

                System.out.println("  Completed at time " + time);
            }

            for (int j = 1; j < n; j++) {
                if (!inQueue[j] && p.get(j).at <= time) {
                    q.add(j);
                    inQueue[j] = true;
                }
            }

            if (rem[i] > 0)
                q.add(i);
        }

        OutputHandler.printTable(p);
        OutputHandler.printAvg(p);
    }
}
