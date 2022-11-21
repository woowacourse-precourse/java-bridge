package bridge.model;

import java.util.function.Function;

public enum Command {
    RETRY((BridgeGame bridgeGame)-> {
        bridgeGame.retry();
        return null;
    }, "R"),
    QUIT((BridgeGame bridgeGame)-> {
        bridgeGame.setGiveUp(true);
        return null;
    }, "Q");

    private final Function<BridgeGame, Void> expression;
    private final String symbol;

    Command(Function<BridgeGame, Void> expression, String symbol) {
        this.expression = expression;
        this.symbol = symbol;
    }

    public static Command fromSymbol(String symbol) {
        for (Command command : values()) {
            if (command.symbol.equals(symbol)){
                return command;
            }
        }

        throw new IllegalArgumentException("[ERROR] 올바르지 않은 명령어입니다.");
    }

    public void exec(BridgeGame bridgeGame){
        this.expression.apply(bridgeGame);
    }

    public String getSymbol() {
        return symbol;
    }
}
