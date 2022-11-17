package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private List<BridgeDirection> directions;

    public Bridge(List<String> directionWords) {
        validateSize(directionWords);
        this.directions = getBridgeDirections(directionWords);
    }

    private void validateSize(List<String> location) {
        if (location.size() < 3 || location.size() > 20) {
            throw new IllegalArgumentException("다리의 길이는 3 ~ 20 사이의 숫자만 가능합니다.");
        }
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
}
