package bridge;

import static bridge.constant.NumberType.*;
import static bridge.constant.OutputViewConstant.DIVIDING_LINE;
import static bridge.constant.OutputViewConstant.FINAL_RESULT_MESSAGE;
import static bridge.constant.OutputViewConstant.GAME_SUCCESS_OR_FAIL_MESSAGE;
import static bridge.constant.OutputViewConstant.NEW_LINE;
import static bridge.constant.OutputViewConstant.PREFIX;
import static bridge.constant.OutputViewConstant.SPACE;
import static bridge.constant.OutputViewConstant.SUFFIX;
import static bridge.constant.OutputViewConstant.TOTAL_TRY_COUNT_MESSAGE;

import bridge.constant.BridgeMove;
import bridge.constant.GameStatus;
import bridge.constant.OutputViewConstant;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static boolean isAppendableDividingLine(List<BridgeMap> bridgeMaps, int index) {
        return bridgeMaps.size() != ONE.getValue() && index < bridgeMaps.size() - ONE.getValue();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeMap> bridgeMaps) {
        StringBuilder upStringBuilder = new StringBuilder();
        StringBuilder downStringBuilder = new StringBuilder();

        appendPrefix(upStringBuilder, downStringBuilder);
        makeMap(bridgeMaps, upStringBuilder, downStringBuilder);
        appendSuffix(upStringBuilder, downStringBuilder);
        String result = concatUpStringAndDownString(upStringBuilder, downStringBuilder);

        System.out.println(result);
    }

    private void makeMap(List<BridgeMap> bridgeMaps, StringBuilder upStringBuilder, StringBuilder downStringBuilder) {
        for (int index = 0; index < bridgeMaps.size(); index++) {
            BridgeMap bridgeMap = bridgeMaps.get(index);

            bridgeMapIsUp(upStringBuilder, downStringBuilder, bridgeMap);
            bridgeMapIsDown(upStringBuilder, downStringBuilder, bridgeMap);
            if (isAppendableDividingLine(bridgeMaps, index)) {
                appendDividingLine(upStringBuilder, downStringBuilder);
            }
        }
    }

    private void appendPrefix(StringBuilder upStringBuilder, StringBuilder downStringBuilder) {
        upStringBuilder.append(PREFIX.getSymbol());
        downStringBuilder.append(PREFIX.getSymbol());
    }

    private void bridgeMapIsUp(StringBuilder upStringBuilder, StringBuilder downStringBuilder, BridgeMap bridgeMap) {
        if (bridgeMap.getBridgeMove() == BridgeMove.UP) {
            upStringBuilder.append(bridgeMap.getMoveResult().getSymbol());
            downStringBuilder.append(SPACE.getSymbol());
        }
    }

    private void bridgeMapIsDown(StringBuilder upStringBuilder, StringBuilder downStringBuilder, BridgeMap bridgeMap) {
        if (bridgeMap.getBridgeMove() == BridgeMove.DOWN) {
            downStringBuilder.append(bridgeMap.getMoveResult().getSymbol());
            upStringBuilder.append(SPACE.getSymbol());
        }
    }

    private void appendDividingLine(StringBuilder upStringBuilder, StringBuilder downStringBuilder) {
        upStringBuilder.append(DIVIDING_LINE.getSymbol());
        downStringBuilder.append(DIVIDING_LINE.getSymbol());
    }

    private void appendSuffix(StringBuilder upStringBuilder, StringBuilder downStringBuilder) {
        upStringBuilder.append(SUFFIX.getSymbol());
        downStringBuilder.append(SUFFIX.getSymbol());
    }

    private String concatUpStringAndDownString(StringBuilder upStringBuilder, StringBuilder downStringBuilder) {
        upStringBuilder.append(NEW_LINE.getSymbol());
        upStringBuilder.append(downStringBuilder);
        upStringBuilder.append(NEW_LINE.getSymbol());

        return upStringBuilder.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameStat bridgeGameStat) {
        System.out.println(FINAL_RESULT_MESSAGE.getSymbol());

        printMap(bridgeGameStat.getBridgeMaps());
        printGameStatus(bridgeGameStat.getGameStatus());
        printCountOfGame(bridgeGameStat.getCountOfGame());
    }

    private void printGameStatus(GameStatus gameStatus) {
        System.out.println(GAME_SUCCESS_OR_FAIL_MESSAGE.getSymbol() + gameStatus.getMessage());
    }

    private void printCountOfGame(int countOfGame) {
        System.out.print(TOTAL_TRY_COUNT_MESSAGE.getSymbol() + countOfGame);
    }

    /**
     * 게임의 시작 문구를 정해진 형식에 맞춰 출력한다.
     */
    public void printIntroMessage() {
        System.out.println(OutputViewConstant.INTRO_MESSAGE.getSymbol());
    }
}