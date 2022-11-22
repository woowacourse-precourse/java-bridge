package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeDirection> directions;

    public Bridge(List<String> directionWords) {
        this.directions = getBridgeDirections(directionWords);
    }

    private List<BridgeDirection> getBridgeDirections(List<String> directionWords) {
        return directionWords.stream()
                .map(BridgeDirection::wordToDirection)
                .collect(Collectors.toList());
    }

    public Answer canMove(int position, BridgeDirection direction) {
        boolean isEqual = directions.get(position) == direction;
        return Answer.of(isEqual);
    }

    public boolean isEnd(int position) {
        return position == directions.size();
    }
}
