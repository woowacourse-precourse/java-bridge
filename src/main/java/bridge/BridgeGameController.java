package bridge;

import static bridge.InputView.*;
import static bridge.OutputView.*;

import java.util.List;

public class BridgeGameController {
    public static void ShowFinalMap(List<String> playerList, List<String> BRIDGE_ANSWER) {
        String("최종 게임 결과");
        printMap(playerList, BRIDGE_ANSWER);
    }

    public static void ShowFinalResult(Boolean success, int tryCount) {
        printResult(success, tryCount);
    }

    public static String RepeatReadMoving() {
        while (true) {
            try {
                return InputView.readMoving();
            } catch (IllegalArgumentException e) {
                OutputView.String("[ERROR] 유효한 값이 아닙니다.");
            }
        }
    }

    public static void ShowResult(String playerInput, List<String> playerList, List<String> BRIDGE_ANSWER) {
        String(playerInput);
        printMap(playerList, BRIDGE_ANSWER);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static Boolean RepeatRetry() {
        Boolean result = false;
        while (true) {
            try {
                result = AnalyzeRetryInput(readGameCommand());
                break;
            } catch (IllegalArgumentException e) { OutputView.String("[ERROR] 유효한 값이 아닙니다."); }
        }
        return result;
    }

    private static Boolean AnalyzeRetryInput(String string) {
        if (string.equals("R")) { return true; }
        if (string.equals("Q")) { return false; }
        return false;
    }
}