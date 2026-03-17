import java.util.*;

class InputHandler {
    public static ArrayList<Process> getProcesses(Scanner sc) {
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        ArrayList<Process> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter AT and BT for P" + (i + 1) + ": ");
            int at = sc.nextInt();
            int bt = sc.nextInt();
            list.add(new Process(i + 1, at, bt));
        }

        return list;
    }
}
