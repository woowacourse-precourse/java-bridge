package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bridge {
    private final List<Position> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = Stream.iterate(0, i-> i<bridge.size(), i->i+1)
                .map(i -> Position.of(i+1, bridge.get(i)))
                .collect(Collectors.toList());
    }

    public static Bridge of(List<String> generatedBridge) {
        return new Bridge(generatedBridge);
    }

    public Result play(Position nextPosition) {
        if (isLastPosition(nextPosition)) {
            return Result.WIN;
        }
        if (contains(nextPosition)) {
            return Result.KEEP;
        }
        return Result.LOSE;
    }

    private boolean isLastPosition(Position nextPosition) {
        return bridge.get(bridge.size()-1).equals(nextPosition);
    }

    private boolean contains(Position nextPosition) {
        return bridge.contains(nextPosition);
    }
}

