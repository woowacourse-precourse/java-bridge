package bridge.path;

import bridge.command.Movement;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Path {

    private static class Pair<K, V> {

        final K key;
        final V value;

        Pair(
                final K key,
                final V value
        ) {
            this.key = key;
            this.value = value;
        }
    }

    private final List<List<Pair<Movement, Result>>> evaluations;

    private Path(final List<Pair<Movement, Movement>> actualMovementToExpectedMovement) {
        evaluations = actualMovementToExpectedMovement.stream()
                .map(Path::createStageWith)
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Pair<Movement, Result>> createStageWith(final Pair<Movement, Movement> pair) {
        return Stream.of(Movement.values())
                .map(movement -> new Pair<>(movement, classify(pair, movement)))
                .collect(Collectors.toUnmodifiableList());
    }

    private static Result classify(
            final Pair<Movement, Movement> actualMovementToExpectedMovement,
            final Movement movement
    ) {
        if (movement == actualMovementToExpectedMovement.value) {
            if (movement == actualMovementToExpectedMovement.key) {
                return Result.O;
            }
            return Result.X;
        }
        return Result.UNSELECTED;
    }

    public static Path of(
            final List<Movement> actualMovements,
            final List<Movement> expectedMovements
    ) {
        return new Path(pairs(actualMovements, expectedMovements));
    }

    private static List<Pair<Movement, Movement>> pairs(
            final List<Movement> actualMovements,
            final List<Movement> expectedMovements
    ) {
        final int size = Math.min(actualMovements.size(), expectedMovements.size());
        return IntStream.range(0, size)
                .mapToObj(idx -> new Pair<>(actualMovements.get(idx), expectedMovements.get(idx)))
                .collect(Collectors.toUnmodifiableList());
    }

    public String format(final EnumMap<Result, String> format) {
        return evaluations.stream()
                .flatMap(stages -> stages.stream().map(stage -> new Pair<>(stage.key, format.get(stage.value))))
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(stages -> stages.key,
                                LinkedHashMap::new,
                                Collectors.mapping(stage -> stage.value,
                                        Collectors.joining(format.get(Result.DELIMITER),
                                                format.get(Result.PREFIX),
                                                format.get(Result.SUFFIX)))),
                        movementToString -> String.join("\n", movementToString.values())));
    }
}
