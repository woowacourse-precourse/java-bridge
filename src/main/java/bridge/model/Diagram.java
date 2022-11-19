package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
    private List<String> upDiagram = new ArrayList<>();
    private List<String> downDiagram = new ArrayList<>();


    public void updateDiagrams(String position, Status status) {
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

    public void printDiagrams() {
        System.out.println(formatDiagram(upDiagram));
        System.out.println(formatDiagram(downDiagram));
    }

    private String formatDiagram(List<String> diagram) {
        return "[ " + String.join(" | ", diagram) + " ]";
    }

}
