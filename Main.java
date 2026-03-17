import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Process> processes = InputHandler.getProcesses(sc);

        System.out.println("\nChoose Algorithm:");
        System.out.println("1. FCFS");
        System.out.println("2. SJF");
        System.out.println("3. Round Robin");

        int ch = sc.nextInt();

        if (ch == 1) {
            FCFS.run(processes);
        } else if (ch == 2) {
            SJF.run(processes);
        } else if (ch == 3) {
            System.out.print("Enter Time Quantum: ");
            int tq = sc.nextInt();
            RoundRobin.run(processes, tq);
        } else {
            System.out.println("Invalid choice");
        }
    }
}
