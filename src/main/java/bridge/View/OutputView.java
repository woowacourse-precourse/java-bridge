package bridge.View;

import bridge.Model.BridgeGame;

import java.util.List;

import static bridge.Constant.Constant.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Deprecated
    public void printAnswer(List<String> map) {
        StringBuilder AnswerUp = new StringBuilder();
        StringBuilder AnswerDown = new StringBuilder();
        for (String bridge : map) {
            if (bridge == "U") {
                AnswerUp.append("[ O ]");
                AnswerDown.append("[   ]");
            } else if (bridge == "D") {
                AnswerUp.append("[   ]");
                AnswerDown.append("[ O ]");
            }
        }
        System.out.println(AnswerUp);
        System.out.println(AnswerDown);
    }

    public String[] printMap(List<String> UpBridge, List<String> DownBridge) {
        String Up = FRONT_BRACKET + printAsBridge(UpBridge) + BACK_BRACKET;
        String Down = FRONT_BRACKET + printAsBridge(DownBridge) + BACK_BRACKET;
        System.out.println(FRONT_BRACKET + printAsBridge(UpBridge) + BACK_BRACKET);
        System.out.println(FRONT_BRACKET + printAsBridge(DownBridge) + BACK_BRACKET);
        return new String[]{Up, Down};
    }

    public static String printAsBridge(List<String> resultBridge) {
        return String.join(" | ", resultBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printResult(List<String> UpBridge, List<String> DownBridge, BridgeGame bridgeGame) {
        System.out.println(TOTAL_GAME_RESULT);
        System.out.println(FRONT_BRACKET + printAsBridge(UpBridge) + BACK_BRACKET);
        System.out.println(FRONT_BRACKET + printAsBridge(DownBridge) + BACK_BRACKET);
        System.out.println(SUCCESS_FAIL + bridgeGame.whenSuccess());
        System.out.println(TOTAL_COUNT + bridgeGame.getTotalCnt());
    }
}
