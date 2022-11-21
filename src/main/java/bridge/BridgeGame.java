package bridge;

import controller.OutputController;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static int attempt = 1;
    private static String resultStatus = "";
    private static String upBridge = "[ ";
    private static String downBridge = "[ ";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean move(String upOrDown, List<String> bridge, int count) {
        String status = BridgeStatus.getStatus(upOrDown + bridge.get(count));
        resultStatus += status;
        if (count == 0) {
            fillFirstBridge(upOrDown + bridge.get(count));
            return false;
        }
        return fillBridge(count,bridge,upOrDown + bridge.get(count));
    }

    private static boolean fillBridge(int count,List<String> bridge,String checkFalse) {
        upBridge += " | " + resultStatus.charAt(count*2);
        downBridge += " | " + resultStatus.charAt(count*2+1) ;
        OutputController.deliverStatus(upBridge + " ]",downBridge + " ]");
        if (count == bridge.size() - 1 && resultStatus.contains("O")) {
            OutputController.deliverResult(upBridge + " ]\n"+downBridge + " ]","성공",attempt);
            return true;
        }
        return checkInputAndBridge(checkFalse);
    }

    private static boolean fillFirstBridge(String checkFalse) { //여기서 다리를 완성하고 출력은 OutputView에서 해주고 싶은데
        fillOneBlcok(String.valueOf(resultStatus.charAt(0)),String.valueOf(resultStatus.charAt(1)));
        OutputController.deliverStatus(upBridge + " ]",downBridge + " ]");
        resetBridge();
        resetStatus();
        return checkInputAndBridge(checkFalse);
    }

    private static boolean checkInputAndBridge(String checkFalse) {
        if (checkFalse.charAt(0) != checkFalse.charAt(1)) {
            return retry();
        }
        return false;
    }

    private static void resetStatus() {
        for (int i = 0; i < resultStatus.length() / 2; i++) {
            if (i != resultStatus.length() / 2 - 1) {
                fillOneBlcok(resultStatus.charAt(i*2)+ " |",resultStatus.charAt(i*2+1)+" |");
            }
            fillOneBlcok(String.valueOf(resultStatus.charAt(i*2)),String.valueOf(resultStatus.charAt(i*2+1)));
        }
    }

    private static void fillOneBlcok(String up, String down) {
        upBridge += up;
        downBridge += down;
    }

    private static void resetBridge() {
        upBridge = "[ ";
        downBridge = "[ ";
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry() {
        if (InputView.readGameCommand().equals("Q")) {
            OutputController.deliverResult(upBridge + " ]\n"+downBridge + " ]","실패",attempt);
            return true;
        }
        resetInfo();
        return false;
    }

    private static void resetInfo() {
        attempt ++;
        resetBridge();
        resultStatus = "";
        BridgeGameController.setCount();
    }
}