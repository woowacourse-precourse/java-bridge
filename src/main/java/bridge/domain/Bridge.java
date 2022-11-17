package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;
    private static final String MIN_VALIDATION_ERROR_MESSAGE = "[ERROR] 다리의 최소 길이는 %d이상 입니다.";
    private static final String MAX_VALIDATION_ERROR_MESSAGE = "[ERROR] 다리의 최대 길이는 %d 입니다.";

    private List<Direction> directions;

    public Bridge(List<String> directionData) {
        validateLength(directionData);
        this.directions = makeDirectionsByStrings(directionData);
    }

    private void validateLength(List<String> directionData) {
        if (directionData.size() < MIN_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(String.format(MIN_VALIDATION_ERROR_MESSAGE, MIN_BRIDGE_LENGTH));
        }
        if (directionData.size() > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(String.format(MAX_VALIDATION_ERROR_MESSAGE, MAX_BRIDGE_LENGTH));
        }
    }


    private List<Direction> makeDirectionsByStrings(List<String> directionData) {
        List<Direction> result = new ArrayList<>();
        for (String direction : directionData) {
            result.add(Direction.getDirectionByString(direction));
        }
        return result;
    }


}
