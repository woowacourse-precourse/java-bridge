package bridge.domain;

import bridge.util.Directions;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class PlayerBoard {
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]\n";
    private static final String DELIMITER = " | ";
    private static final String BLANK = " ";

    private final int endRound;

    private int gameRound;
    private List<String> upBridge;
    private List<String> downBridge;

    PlayerBoard(final int BRIDGE_SIZE) {
        gameRound = 0;
        endRound = BRIDGE_SIZE;
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    boolean isOver() {
        return gameRound == endRound;
    }

    int getGameRound() {
        return gameRound;
    }

    /**
     * 현재 PlayerBoard의 {@link #upBridge}와 {@link #downBridge}에<br/>
     * {@link #gameRound} 값 위치로 roundResult 값을 삽입한다.
     * <p>
     *  targetSide 값이 "U"일 경우 : {@link #upBridge}에 roundResult , {@link #downBridge}에 {@value BLANK} 삽입<br/>
     *  targetSide 값이 "D"일 경우 : {@link #downBridge}에 roundResult , {@link #upBridge}에 {@value BLANK} 삽입
     * </p>
     *
     * @param targetSide 문자열 "U" 혹은 "D"
     * @param roundResult 문자열 "O" 혹은 "X"  {@link bridge.domain.converter.ResultConverter#convertToMark(boolean)}
     * @see BridgeGame#move(String, String)
     * @see Directions
     */
    void addResultOfBridge(String targetSide, String roundResult) {
        if (targetSide.equals(Directions.UP.getValue())) {
            upBridge.add(gameRound, roundResult);
            downBridge.add(gameRound, BLANK);
        }
        if (targetSide.equals(Directions.DOWN.getValue())) {
            downBridge.add(gameRound, roundResult);
            upBridge.add(gameRound, BLANK);
        }
        gameRound++;
    }

    /**
     * side에 해당하는 방향의 다리 형태를 문자열로 반환한다
     * <p>
     *     {@value DELIMITER},{@value PREFIX},{@value SUFFIX} 값으로<br/>
     *     {@link StringJoiner } 객체를 생성하여 <br/>
     *     side 값 방향의 다리({@link #upBridge} / {@link #downBridge})에 대해<br/>
     *     상태를 문자열로 변환하여 반환한다.
     * </p>
     *
     * @param side 문자열 "U" 혹은 "D"
     * @return 다리 상태 문자열 변환 값
     * @see bridge.ui.OutputView#printMap(String, String)
     * @see BridgeGame#startRound()
     * @see Processor#getRoundResult(String, String)
     * @see Processor#getGameResult(boolean, int, PlayerBoard)
     * @see Directions
     */
    String getBridgeStatus(String side) {
        StringJoiner joiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (int i = 0; i < gameRound; i++) {
            if (side.equals(Directions.UP.getValue())) {
                joiner.add(upBridge.get(i));
            }
            if (side.equals(Directions.DOWN.getValue())) {
                joiner.add(downBridge.get(i));
            }
        }
        return joiner.toString();
    }
}
