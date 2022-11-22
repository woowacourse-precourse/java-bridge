package bridge.type;

import bridge.domain.Player;
import bridge.type.suppoter.RetrySupporter;
import bridge.view.OutputView;

import java.util.Optional;
import java.util.stream.Stream;

public enum RetryType implements RetrySupporter {

    RETRY("R") {
        @Override
        public int reset(Player player, OutputView outputView, int size) {
            player.removePositions();
            outputView.reset();
            size = 0;
            return size;
        }
    },
    END("Q"){
        @Override
        public int reset(Player player, OutputView outputView, int size) {
            return size;
        }
    },
    PASS( "P") {
        @Override
        public int reset(Player player, OutputView outputView, int size) {
            return size;
        }
    };

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

    public static boolean finish(RetryType retryType) {
        return RetryType.END.equals(retryType);
    }
}
