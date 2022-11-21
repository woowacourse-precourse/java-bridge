package bridge.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Function;

public enum GameRecordFormat {
    NORMAL(true, (gameResult)->(gameResult)),
    BACK_SLASHED(false,(gameResult)->(GameRecordSymbol.BACK_SLASH.getSymbol()+gameResult));
    private boolean isFirst;
    private Function<String, String> maker;
    GameRecordFormat(boolean isFirst, Function<String, String> maker){
        this.isFirst=isFirst;
        this.maker=maker;
    }

    public String generate(String gameResult){
        return this.maker.apply(gameResult);
    }

}
