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
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean success, int totalCount) {
        printInfo(OutputPharses.SUCCESS_MSG.getMsg() + getSuccessMsg(success));
        printInfo(OutputPharses.COUNT_MSG.getMsg() + integerToString(totalCount));
    }

    public String getSuccessMsg(boolean success) {
        if (success) {
            return BridgeGameStatus.SUCCESS.getGameStatus();
        }
        return BridgeGameStatus.FAILED.getGameStatus();
    }

    public String integerToString(int value) {
        return Integer.toString(value);
    }

    /**
     * 기본 메세지 출력용 함수
     * @param msg
     */
    public void printInfo(String msg) {
        System.out.println(msg);
    }

    public void printEmptyLn(){
        printInfo(OutputPharses.EMPTY_LINE.getMsg());
    }

    /**
     * 다리 출력용 Map의 규격을 만들기 위한 함수
     * @return
     */
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
        String upLine = getMapString(player.getUpMoveMap());
        String downLine = getMapString(player.getDownMoveMap());

        return getMapPrintJoiner().add (upLine).add(downLine).toString();
    }

    public String getMapString(List<String> moveMap) {
        StringJoiner line = getLineJoiner();
        for (String move : moveMap) {
            line.add(move);
        }
        return line.toString();
    }
}
