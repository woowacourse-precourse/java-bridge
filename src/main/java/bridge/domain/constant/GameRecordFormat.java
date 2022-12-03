package bridge.domain.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Function;

public enum GameRecordFormat {
    NORMAL(true, (gameResult) -> (gameResult)),
    BACK_SLASHED(false, (gameResult) -> (GameRecordSymbol.BACK_SLASH.getSymbol() + gameResult));
    private final boolean isFirst;
    private final Function<String, String> maker;

    GameRecordFormat(boolean isFirst, Function<String, String> maker) {
        this.isFirst = isFirst;
        this.maker = maker;
    }

    private static boolean isFirstTrial(GameRecordFormat gameRecordFormat, boolean isFirst) {
        return gameRecordFormat.isFirst == isFirst;
    }

    public static GameRecordFormat findByTrial(boolean isFirst) {
        return Arrays.stream(GameRecordFormat.values())
                .filter(gameRecordFormat -> GameRecordFormat.isFirstTrial(gameRecordFormat, isFirst))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public String generate(String gameResult) {
        return this.maker.apply(gameResult);
    }

}
