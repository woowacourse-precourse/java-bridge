package bridge.domain.game;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bridge.util.Constants.NO_MATCHING_MOVING_TYPE_FOUND;

public enum MovingType {
    MOVING_UP(1, "U"),
    MOVING_DOWN(0, "D");

    private final int numNotation;
    private final String engNotation;

    MovingType(int numNotation, String engNotation) {
        this.numNotation = numNotation;
        this.engNotation = engNotation;
    }

    private static final Map<Integer, MovingType> movingTypeByNumNotation =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(MovingType::getNumNotation, Function.identity())));

    private static final List<String> movingTypeEngNotations =
            Collections.unmodifiableList(Stream.of(MovingType.values())
                    .map(MovingType::getEngNotation)
                    .collect(Collectors.toList()));

    public int getNumNotation() {
        return this.numNotation;
    }

    public String getEngNotation() {
        return engNotation;
    }

    public static MovingType getMovingTypeByNumNotation(int numNotation) {
        return Optional
                .ofNullable(movingTypeByNumNotation.get(numNotation))
                .orElseThrow(() -> new IllegalArgumentException(NO_MATCHING_MOVING_TYPE_FOUND));
    }

    public static boolean isContains(String engNotation) {
        return movingTypeEngNotations.contains(engNotation);
    }
}
