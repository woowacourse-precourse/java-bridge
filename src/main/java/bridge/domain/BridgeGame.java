package bridge.domain;

import bridge.controller.BridgeController;
import bridge.service.BridgeService;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static List<String> answerBridge = BridgeService.getAnswerBridge();
    private static int answerCount = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String move(String dir) {
        if (answerBridge.get(answerCount).equals(dir)) {
            answerCount++;
            return "O";
        }
        return "X";
    }

    public static void compareMove(String dir) {
        System.out.println(answerBridge);
        while (true) {
            String answer = BridgeService.moveBridge();
            BridgeService.viewBridge();
            int check = breakCompare(answer);
            if (check != 0) {
                breakRun(check);
                break;
            }
            dir = BridgeService.getInitMoveRow();
        }
    }

    public static int breakCompare(String answer) {
        if (answer.equals("X")) {
            return 1;
        }
        if (answerCount == BridgeService.getInputSize()) {
            return 2;
        }
        return 0;
    }

    public static void breakRun(int check) {
        if (check == 1) {
            BridgeService.getInitRetryQuit();
        }
        if (check == 2) {
            answerCount = 0;
            BridgeService.viewFinalResult(true);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void retry() {
        answerCount = 0;
        BridgeService.resetBridge();
        BridgeController.makeBridge(BridgeService.getInputSize());
        BridgeController.initMoveRow();
        BridgeController.compareMove();
    }
}
