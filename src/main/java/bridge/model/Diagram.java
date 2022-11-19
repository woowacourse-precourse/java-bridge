package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Diagram {


    private static List<String> upDiagram = new ArrayList<>();
    private static List<String> downDiagram = new ArrayList<>();


    public static void paintDiagrams(String position, Status status) {
        if (position.equals("U")) {
            if (status == Status.SURVIVE) {
                upDiagram.add("O");
                downDiagram.add(" ");
                printDiagrams();
                return;
            }
            upDiagram.add("X");
            downDiagram.add(" ");
            printDiagrams();
            return;
        }
        if (position.equals("D")) {
            if (status == Status.SURVIVE) {
                upDiagram.add(" ");
                downDiagram.add("O");
                printDiagrams();
                return;
            }
            upDiagram.add(" ");
            downDiagram.add("X");
            printDiagrams();
        }
    }

    public static void printDiagrams() {
        System.out.println(upDiagram);
        System.out.println(downDiagram);

    }

    public static List<String> getUpDiagram() {
        return upDiagram;
    }

    public static List<String> getDownDiagram() {
        return downDiagram;
    }
}
