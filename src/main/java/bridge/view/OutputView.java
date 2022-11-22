package bridge.view;

import bridge.model.BridgeGame;
import bridge.model.Progress;
import bridge.model.constant.BridgePattern;
import bridge.model.constant.Command;
import bridge.model.constant.GameCondition;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static public void printMsg(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        printMsg("");
    }

    public void startMsg() {
        printMsg("다리 건너기 게임을 시작합니다.");
        printEmptyLine();
        printMsg("다리의 길이를 입력해주세요.");
    }

    public void printException(String text) {
        printMsg("[ERROR] " + text);
    }

    public void printSelectMsg() {
        //printEmptyLine();
        printMsg("이동할 칸을 선택해주세요. (" + BridgePattern.MOVE_UP.getDetail() + ": " + BridgePattern.MOVE_UP.getMove()
                + ", " + BridgePattern.MOVE_DOWN.getDetail() + ": " + BridgePattern.MOVE_DOWN.getMove() + ")");
    }

    public void printRetryMsg() {
        printEmptyLine();
        printMsg(
                "게임을 다시 시도할지 여부를 입력해주세요. (" + Command.DO_RETRY.getDetail() + ": " + Command.DO_RETRY.getCommand()
                        + ", " + Command.DO_QUIT.getDetail() + ": " + Command.DO_QUIT.getCommand() + ")");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Progress progress) {
        for (List<String> stage : progress.getProgress().values()) {
            printMsg(String.format("[ %s ]", String.join(" | ", stage)));
        }
        printEmptyLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, GameCondition gameCondition) {
        printEmptyLine();
        printMsg("최종 게임 결과");
        printMap(bridgeGame.exportProgress());
        printMsg("게임 성공 여부: " + gameCondition.getDetail());
        printMsg("총 시도한 횟수: " + bridgeGame.exportGameCount());
    }
}

