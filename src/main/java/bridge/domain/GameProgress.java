package bridge.domain;

import static bridge.constant.Const.*;

public class GameProgress {

    private StringBuilder mapState;
    private StringBuilder result;
    private String failOrSuccess;
    private final Player player;
    private final Bridge bridge;

    public GameProgress(Player player, Bridge bridge) {
        this.player = player;
        this.bridge = bridge;
    }

    public StringBuilder getMapState() {
        mapState = decideMapState();
        return mapState;
    }

    public StringBuilder getResult() {
        result = decideResult();
        return result;
    }

    public String getFailOrSuccess() {
        return failOrSuccess;
    }

    public void decideFailOrSuccess() {
        failOrSuccess = FAIL;

        if ((player.getIndex() + 1) == bridge.size() && player.getAlive()) {
            failOrSuccess = SUCCESS;
        }
    }

    private StringBuilder decideMapState() {
        StringBuilder mapState = new StringBuilder();
        mapState.append(upOrDownStepStateInBridge(UP)).append("\n")
                .append(upOrDownStepStateInBridge(DOWN)).append("\n");
        return mapState;
    }

    private StringBuilder decideResult() {
        StringBuilder result = new StringBuilder();
        result.append(lastMap()).append("\n");
        result.append(whetherFailOrSuccess());
        result.append(numberOfRetry());
        return result;
    }

    private StringBuilder upOrDownStepStateInBridge(String position) {
        StringBuilder printOfMap = new StringBuilder();
        passedStepState(printOfMap, position);
        nowStepState(printOfMap, position);
        convertLastLetter(printOfMap);
        return printOfMap;
    }

    private void passedStepState(StringBuilder printOfMap, String position) {
        for (int index = 0; index < player.getIndex(); index++) {
            if (bridge.canPlayerCross(index, position)) {
                printOfMap.append(VERTICAL_BAR).append(O);
            }

            if (!bridge.canPlayerCross(index, position)) {
                printOfMap.append(VERTICAL_BAR).append(BLANK);
            }
        }
    }

    private void nowStepState(StringBuilder printOfMap, String position) {
        if (player.getAlive()) { // 플레이어가 살아있을 떄
            stepStateWhenPlayerIsAlive(printOfMap, position);
        }

        if (!player.getAlive()) { // 플레이어가 죽었을 때
            stepStateWhenPlayerIsNotAlive(printOfMap, position);
        }
    }

    private void stepStateWhenPlayerIsAlive(StringBuilder printOfMap, String position) {
        if (bridge.canPlayerCross(player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(O);
        }

        if (!bridge.canPlayerCross(player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(BLANK);
        }
    }

    private void stepStateWhenPlayerIsNotAlive(StringBuilder printOfMap, String position) {
        if (bridge.canPlayerCross(player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(BLANK);
        }

        if (!bridge.canPlayerCross(player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(X);
        }
    }

    private void convertLastLetter(StringBuilder printOfMap) {
        printOfMap.setCharAt(0, LEFT_SQUARE_BRACKET);
        printOfMap.append(RIGHT_SQUARE_BRACKET);
    }

    private String lastMap() {
        return GAME_RESULT + "\n" + mapState;
    }

    private String whetherFailOrSuccess() {
        return GAME_SUCCESS + failOrSuccess + "\n";
    }

    private String numberOfRetry() {
        return NUMBER_OF_RETRY + player.getNumberOfRetry() + "\n";
    }
}
