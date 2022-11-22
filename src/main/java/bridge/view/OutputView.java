package bridge.view;

import bridge.model.BridgeGame;
import bridge.model.BridgeType;
import bridge.model.ContinueType;
import bridge.model.GameStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR = "[ERROR] ";

    private static final String selectionGuide = String.join(", ", new ArrayList<>() {{
        for (BridgeType bridge : BridgeType.values()) {
            add(String.format("%s: %s", bridge.getPosition(), bridge.getCommand()));
        }
    }});

    private static final String continueGuide = String.join(", ", new ArrayList<>() {{
        for (ContinueType continueType : ContinueType.values()) {
            add(String.format("%s: %s", continueType.getDescription(), continueType.getCommand()));
        }
    }});

    public void printGameStart() {
        out("다리 건너기 게임을 시작합니다.");
    }

    public void printRequestBridgeLength() {
        blank();
        out("다리의 길이를 입력해주세요.");
    }

    public void printExceptionMessage(String text) {
        out(ERROR + text);
    }

    public void printRequestMoveBridge() {
        blank();
        out(String.format("이동할 칸을 선택해주세요. (%s)", selectionGuide));
    }

    public void printWantToContinue() {
        blank();
        out(String.format("게임을 다시 시도할지 여부를 입력해주세요. (%s)", continueGuide));
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map<BridgeType, List<String>> bridgeMoveLog) {
        for (List<String> log : bridgeMoveLog.values()) {
            out(String.format("[ %s ]", String.join(" | ", log)));
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, GameStatus resultStatus) {
        blank();
        out("최종 게임 결과");
        printMap(bridgeGame.getLog());
        blank();
        out(String.format("게임 성공 여부: %s", resultStatus.getState()));
        out(String.format("총 시도한 횟수: %d", bridgeGame.getTryCount()));
    }

    private void out(String text) {
        System.out.println(text);
    }

    private void blank() {
        System.out.println();
    }
}
