package bridge;

import java.util.List;

import static bridge.Application.bridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_POINT = "[ ";
    private final String END_POINT = " ]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        printBridge();
    }

    public void printBridge() {
        printUpBridge();
        printDownBridge();
    }

    public void printUpBridge() {
        StringBuilder sb = new StringBuilder();
        sb.append(START_POINT).append(JoinBridge(bridgeGame.getUpBridge())).append(END_POINT);
        System.out.print(sb);
        System.out.println();
    }

    public void printDownBridge() {
        StringBuilder sb = new StringBuilder();
        sb.append(START_POINT).append(JoinBridge(bridgeGame.getDownBridge())).append(END_POINT);
        System.out.println(sb);
    }

    public String JoinBridge(List<String> upBridge) {
        return String.join(" | ", upBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int gameCnt, int CURRENT_LOCATION, boolean successOrFail) {
        if(CURRENT_LOCATION==0 && successOrFail) retryAnswerIsSuccess(gameCnt);
    }

    public void retryAnswerIsSuccess(int gameCnt) {
        Message.gameResult();
        printBridge();
        Message.blank();
        Message.gameSuccess();
        Message.tryCount(gameCnt);
    }

    public void retryAnswerIsQuit(int gameCnt) {
        Message.gameResult();
        printBridge();
        Message.blank();
        Message.gameFail();
        Message.tryCount(gameCnt);
    }
}
