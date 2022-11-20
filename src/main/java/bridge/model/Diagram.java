package bridge.model;

import static bridge.model.Status.getDisplay;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
    private List<String> upDiagram = new ArrayList<>();
    private List<String> downDiagram = new ArrayList<>();


    public void updateDiagrams(Position position, Status status) {
        if (position == Position.UP) {
            upDiagram.add(getDisplay(status));
            downDiagram.add(" ");
            printDiagrams();
        }
        if (position == Position.DOWN) {
                upDiagram.add(" ");
                downDiagram.add(getDisplay(status));
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
