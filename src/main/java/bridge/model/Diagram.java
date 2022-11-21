package bridge.model;

import static bridge.model.Position.returnByPosition;
import static bridge.model.Status.getDisplay;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
    private List<String> upDiagram = new ArrayList<>();
    private List<String> downDiagram = new ArrayList<>();

    public void updateDiagrams(Position position, Status status) {
        upDiagram.add(returnByPosition(Position.UP, position, getDisplay(status)));
        downDiagram.add(returnByPosition(Position.DOWN, position, getDisplay(status)));
    }

    private String formatDiagram(List<String> diagram) {
        return "[ " + String.join(" | ", diagram) + " ]";
    }

    public List<String> getFormattedDiagrams() {
        return List.of(formatDiagram(upDiagram), formatDiagram(downDiagram));
    }
}
