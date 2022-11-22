package bridge.view;

import bridge.model.Player;
import bridge.util.BridgeGameStatus;
import bridge.util.BridgeShapeInfo;
import bridge.util.OutputPharses;
import bridge.util.MoveMapIndex;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        printInfo(makePrintMapMsg(player));
        printInfo(OutputPharses.EMPTY_LINE.getMsg());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

    }

    /**
     * 게임 시작시 출력하는 메세지
     */
    public void printGameStartInfo() {
        printInfo(OutputPharses.START_MSG.getMsg());
        printInfo(OutputPharses.EMPTY_LINE.getMsg());
    }
    public void printInfo(String msg) {
        System.out.println(msg);
    }
    public StringJoiner getLineJoiner() {
        return new StringJoiner(" | ", "[ ", " ]");
    }
    public StringJoiner getMapPrintJoiner() {
        return new StringJoiner("\n");
    }
    /**
     * 이동 결과 출력 함수
     * @param player
     * @return
     */
    public String makePrintMapMsg(Player player) {
        StringJoiner upLine = getLineJoiner();
        StringJoiner downLine = getLineJoiner();

        for(List<String> playerMove : player.getPlayerMoveMap()) {
            List<String> msgList = setEachMsg(playerMove, upLine, downLine);
            upLine.add(msgList.get(MoveMapIndex.UP_INDEX.getMoveMapIndex()));
            downLine.add(msgList.get(MoveMapIndex.DOWN_INDEX.getMoveMapIndex()));
        }
        return getMapPrintJoiner().add(upLine.toString()).add(downLine.toString()).toString();
    }

    /**
     * 각 사용자의 이동 ["U"|"D", "O"|"X"] 에서 U인지 D인지 확인하는 함수
     * @param playerMove
     * @return
     */
    public boolean isUpLine(List<String> playerMove) {
        int shapeIndex = MoveMapIndex.BRIDGE_SHAPE_INDEX.getMoveMapIndex();
        if (BridgeShapeInfo.UP.getBridgeShape().equals(playerMove.get(shapeIndex))) {
            return true;
        }
        return false;
    }

    /**
     * 각 출력 라인에 넣을 값 설정하는 함수
     * @param playerMove
     * @param upLine
     * @param downLine
     * @return [UP_LINE 문자열, DOWN_LINE 문자열]
     */
    public List<String> setEachMsg(List<String> playerMove, StringJoiner upLine, StringJoiner downLine) {
        String bridgeShape = getCorrectShape(playerMove);
        return getEachMsg(isUpLine(playerMove), bridgeShape);
    }

    public String getCorrectShape(List<String> playerMove) {
        return playerMove.get(MoveMapIndex.CORRECT_INDEX.getMoveMapIndex());
    }

    public List<String> getEachMsg(boolean isUp, String bridgeShape) {
        if (isUp) {
            return List.of(bridgeShape, BridgeGameStatus.SPACEBAR.getGameStatus());
        }

        return List.of(BridgeGameStatus.SPACEBAR.getGameStatus(), bridgeShape);
    }

}
