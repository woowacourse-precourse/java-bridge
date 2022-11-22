package bridge.model;

import static bridge.model.Position.returnByPosition;
import static bridge.model.SurviveAndDie.getDisplay;
import static bridge.util.Constants.BRIDGE_END;
import static bridge.util.Constants.BRIDGE_SEPARATER;
import static bridge.util.Constants.BRIDGE_START;

import java.util.ArrayList;
import java.util.List;

public class Diagram {

    private List<String> upDiagram = new ArrayList<>();
    private List<String> downDiagram = new ArrayList<>();

    public void updateDiagrams(Position position, SurviveAndDie surviveAndDie) {
        upDiagram.add(Position.returnByPosition(Position.UP, position, getDisplay(surviveAndDie)));
        downDiagram.add(Position.returnByPosition(Position.DOWN, position, getDisplay(surviveAndDie)));
    }

    private String formatDiagram(List<String> diagram) {
        return BRIDGE_START + String.join(BRIDGE_SEPARATER, diagram) + BRIDGE_END;
    }

    public List<String> getFormattedDiagrams() {
        return List.of(formatDiagram(upDiagram), formatDiagram(downDiagram));
    }
}
