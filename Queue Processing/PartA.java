import java.util.Scanner;

public class PartA {

    public static void main(String[] args) {
        SinglyLinkedList<String[]> myList = new SinglyLinkedList<String[]>();
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter list to be processed: ");
        createList(myList, scnr.nextLine());
        System.out.println("Number of Cycles to Process: " + Processes(myList));
    }

    public static void createList (SinglyLinkedList<String[]> myList, String input) {
        String[] p = input.split(";");

        for (String process : p) {
            char start = process.charAt(0);
            int startIndex = 0;
            String resourceNeeded;

            for (int i = 0; i < process.length(); i++) {
                start = process.charAt(i);
                if (start != '(') {
                    startIndex = startIndex + 1;
                }
                else {
                    break;
                }
            }

            resourceNeeded = process.substring(startIndex + 1, process.length() - 1);

            String[] second = resourceNeeded.split(",");
            
            myList.addLast(second);
        }
    }

    public static int Processes (SinglyLinkedList<String[]> myList) {
        String[] back = myList.removeFirst();
        String[] front = myList.removeFirst();
        String[] resources = new String[3]; //can i do this? hard code 3?
        int resourceInc = back.length;
        int numProcesses = 1;

        for (int i = 0; i < back.length; i++) {
            resources[i] = back[i];
        }

        while (front != null) {
            boolean matched = false;
                for (int i = 0; i < resourceInc; i++) {
                    if (matched == false) {
                        for (int j = 0; j < front.length; j++) {
                            if (resources[i].equals(front[j])) {
                                back = front;
                                front = myList.removeFirst();
                                matched = true;
                                numProcesses++;
                                break;
                            }
                        }
                    }
                }
                if (matched == false) {
                    for (String r : front) {
                        resources[resourceInc] = r;
                        resourceInc++;
                    }
                    back = front;
                    front = myList.removeFirst();
                }
                else if (matched == true) {
                    for (int m = 0; m < resources.length; m++) {
                        resources[m] = null;
                    }
                    for (int m = 0; m < back.length; m++) {
                        resources[m] = back[m];
                    }
                    resourceInc = back.length;
                }
        }
        

        return numProcesses;
    }
}
