package model;


import controller.BridgeGameController;
import controller.InputController;
import controller.OutputController;
import model.BridgeStatus;
import util.Constants;
import view.InputView;

import java.util.List;


public class BridgeGame {
    private static int attempt = Constants.ONE;
    private static String resultStatus = "";
    private static String upBridge = "[ ";
    private static String downBridge = "[ ";

    public static boolean move(String upOrDown, List<String> bridge, int count) {
        String status = BridgeStatus.getStatus(upOrDown + bridge.get(count));
        resultStatus += status;
        if (count == Constants.ZERO) {
            return fillFirstBridge(upOrDown + bridge.get(count));
        }
        return fillBridge(count,bridge,upOrDown + bridge.get(count));
    }

    private static boolean fillBridge(int count,List<String> bridge,String checkFalse) {
        upBridge += " | " + resultStatus.charAt(count*2);
        downBridge += " | " + resultStatus.charAt(count*2+1) ;
        OutputController.deliverStatus(upBridge + " ]",downBridge + " ]");
        if (count == bridge.size() - Constants.ONE && checkFalse.charAt(Constants.ZERO) == checkFalse.charAt(Constants.ONE)) {
            OutputController.deliverResult(upBridge + " ]\n"+downBridge + " ]",Constants.SUCCESS,attempt);
            return true;
        }
        return checkInputAndBridge(checkFalse);
    }

    private static boolean fillFirstBridge(String checkFalse) {
        fillOneBlcok(String.valueOf(resultStatus.charAt(Constants.ZERO)),String.valueOf(resultStatus.charAt(Constants.ONE)));
        OutputController.deliverStatus(upBridge + " ]",downBridge + " ]");
        resetBridge();
        resetStatus();
        return checkInputAndBridge(checkFalse);
    }

    private static boolean checkInputAndBridge(String checkFalse) {
        if (checkFalse.charAt(Constants.ZERO) != checkFalse.charAt(Constants.ONE)) {
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

    public static boolean retry() {
        if (InputController.checkRestartOrExit().equals(Constants.EXIT)) {
            OutputController.deliverResult(upBridge + " ]\n"+downBridge + " ]",Constants.FAIL,attempt);
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