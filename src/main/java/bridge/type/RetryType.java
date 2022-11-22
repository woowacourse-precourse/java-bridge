package bridge.type;

import bridge.domain.Player;
import bridge.type.suppoter.RetrySupporter;
import bridge.view.OutputView;

import java.util.Optional;
import java.util.stream.Stream;

public enum RetryType implements RetrySupporter {

    RETRY(0, "R") {
        @Override
        public int reset(Player player, OutputView outputView, int size) {
            player.removePositions();
            outputView.reset();
            size = 0;
            return size;
        }
    },
    END(-1, "Q"){
        @Override
        public int reset(Player player, OutputView outputView, int size) {
            return size;
        }
    },
    PASS(1, "P") {
        @Override
        public int reset(Player player, OutputView outputView, int size) {
            return size;
        }
    };

    private final int statusCode;
    private final String symbol;

    RetryType(int statusCode, String symbol) {
        this.statusCode = statusCode;
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

    public int getStatusCode() {
        return statusCode;
    }
}
