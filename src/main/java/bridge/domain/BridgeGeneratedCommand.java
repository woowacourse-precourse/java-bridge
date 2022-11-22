package bridge.domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeGeneratedCommand {

    U(1),
    D(0);

    private final int number;

    private static final Map<Integer, BridgeGeneratedCommand> numbers =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(BridgeGeneratedCommand::getNumber, Function.identity())));

    BridgeGeneratedCommand(int number) {
        this.number = number;
    }

    private int getNumber() {
        return this.number;
    }

    public static String find(int number) {
        return numbers.get(number)
                .toString();
    }
}
