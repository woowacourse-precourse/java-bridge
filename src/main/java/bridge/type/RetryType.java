package bridge.type;

import java.util.Optional;
import java.util.stream.Stream;

public enum RetryType {

    RETRY("R"),
    END("Q"),
    PASS("P");

    private final String symbol;

    RetryType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Optional<RetryType> matchSymbol(String readGameCommand) {
        return Stream.of(values())
                .filter(retryType -> retryType.getSymbol().equals(readGameCommand))
                .findFirst();
    }
}
