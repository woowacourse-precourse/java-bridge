package bridge.model;

import static bridge.util.Constants.BRIDGE_END;
import static bridge.util.Constants.BRIDGE_SEPARATER;
import static bridge.util.Constants.BRIDGE_START;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Diagram {

    private List<String> upDiagram = new ArrayList<>();
    private List<String> downDiagram = new ArrayList<>();

    public void updateDiagrams(Position position, SurviveAndDie surviveOrDie) {
        upDiagram.add(surviveOrDie.getDisplay(position.isRightPlace(Position.UP)));
        downDiagram.add(surviveOrDie.getDisplay(position.isRightPlace(Position.DOWN)));
    }

    private String formatDiagram(List<String> diagram) {
        StringJoiner result = new StringJoiner(BRIDGE_SEPARATER, BRIDGE_START, BRIDGE_END);
        diagram.stream().forEach(element -> result.add(element));
        return result.toString();
    }

    public List<String> getFormattedDiagrams() {
        return List.of(formatDiagram(upDiagram), formatDiagram(downDiagram));
    }
}
