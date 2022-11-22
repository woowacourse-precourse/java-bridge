package bridge;

import bridge.command.Movement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<Movement> possibleMovements;

    private Bridge(final List<Movement> possibleMovements) {
        this.possibleMovements = Collections.unmodifiableList(possibleMovements);
    }

    public static Bridge of(final List<String> possibleMovementCommands) {
        final List<Movement> possibleMovements = possibleMovementCommands.stream()
                .map(Movement::commandOf)
                .collect(Collectors.toList());
        return new Bridge(possibleMovements);
    }
}
