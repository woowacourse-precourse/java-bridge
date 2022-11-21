package bridge.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public enum GameRecord {

    UPSIDE(BridgeDirection.UP, (result)->List.of(result, GameRecordSymbol.SPACING.getSymbol())),
    DOWNSIDE(BridgeDirection.DOWN, (result)->List.of(GameRecordSymbol.SPACING.getSymbol(), result));
    private BridgeDirection direction;
    private Function<String, List<String>> generator;
    GameRecord(BridgeDirection bridgeDirection, Function generator){
        this.direction = bridgeDirection;
        this.generator=generator;
    }

    private static boolean isSameDirection(GameRecord gameRecord, BridgeDirection direction){
        return gameRecord.direction==direction;
    }
    public static GameRecord findLocation(BridgeDirection direction){
        return Arrays.stream(GameRecord.values())
                .filter(gameRecord -> GameRecord.isSameDirection(gameRecord, direction))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

}
