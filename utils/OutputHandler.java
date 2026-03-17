import java.util.*;

class OutputHandler {

    public static void printTable(ArrayList<Process> p) {
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");

        for (Process x : p) {
            System.out.println("P" + x.pid + "\t" + x.at + "\t" + x.bt + "\t"
                    + x.ct + "\t" + x.tat + "\t" + x.wt);
        }
    }

    public static void printAvg(ArrayList<Process> p) {
        double avg_wt = 0, avg_tat = 0;

        for (Process x : p) {
            avg_wt += x.wt;
            avg_tat += x.tat;
        }

        avg_wt /= p.size();
        avg_tat /= p.size();

        System.out.println("\nAverage Waiting Time = " + avg_wt);
        System.out.println("Average Turnaround Time = " + avg_tat);
    }
}
