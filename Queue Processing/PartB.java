import java.util.Random;

public class PartB {

    public static void main(String[] args) {
        SinglyLinkedList<String[]> processesList = new SinglyLinkedList<String[]>();
        addToProcessesList(processesList, 20);
        Processes(processesList);
    }

    public static void addToProcessesList(SinglyLinkedList<String[]> processesList, int numProcesses) {
        for (int i = 0; i < numProcesses; i++) {
            processesList.addLast(randomResources());
        }
    }
   
    private static String[] randomResources() {
        Random rand = new Random();
        boolean forA = false;
        boolean forB = false;
        boolean forC = false;
        int counter = 0;
        
        int numResources = rand.nextInt(3) + 1; 
        String[] resources = new String[numResources];

        while (counter < numResources) {
            int typeResource = rand.nextInt(3);
            if (typeResource == 0) {
                if (forA == false) {
                    resources[counter] = "A";
                    forA = true;
                    counter++;
                }
            }
            else if (typeResource == 1) {
                if (forB == false) {
                    resources[counter] = "B";
                    forB = true;
                    counter++;
                }
            }
            else if (typeResource == 2) {
                if (forC == false) {
                    resources[counter] = "C";
                    forC = true;
                    counter++;
                }
            }
        }

        return resources;
    }

    public static int Processes (SinglyLinkedList<String[]> processesList) {
        String[] back = processesList.removeFirst();
        String[] front = processesList.removeFirst();
        String[] resources = new String[3]; 
        int resourceInc = back.length;
        int numProcesses = 1;

        for (int i = 0; i < back.length; i++) {
            resources[i] = back[i];
        }

        while (front != null) {
            boolean matched = false;
                for (int i = 0; i < resourceInc && !matched; i++) {
                    if (matched == false) {
                        for (int j = 0; j < front.length; j++) {
                            if (resources[i].equals(front[j])) {
                                back = front;
                                front = processesList.removeFirst();
                                matched = true;
                                numProcesses++;
                                break;
                            }
                        }
                    }
                }

                if (!matched) {
                    for (String r : front) {
                        if (resourceInc < resources.length) {
                            resources[resourceInc++] = r;
                        }
                    }
                    back = front;
                    front = processesList.removeFirst();
                }
                else {
                    for (int m = 0; m < resources.length; m++) {
                        resources[m] = null;
                    }
                    for (int m = 0; m < back.length; m++) {
                        resources[m] = back[m];
                    }
                    resourceInc = back.length;

                    addToProcessesList(processesList, 2);

                    if (numProcesses % 100 == 0) {
                        System.out.println("Length of processes at cycle " + numProcesses + ": " + processesList.size());
                        System.out.println();
                    }
                    if (numProcesses >= 1000) {
                        System.out.println("We have a total of " + processesList.size() + " left.");
                        break;
                    }
                }
                
        }
        

        return numProcesses;
    }
}
