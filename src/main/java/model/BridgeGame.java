package model;

import controller.BridgeController;
import constant.StringConstant;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    int countTryNumber = 1;
    private int bridgeNumber = 0;

    public void run() {
        try {
            List<String> upSide = new ArrayList<>();
            List<String> downSide = new ArrayList<>();
            List<String> bridge = BridgeController.makeBridge();
            checkCorrectPath(bridge, upSide, downSide);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<String> addUserMove(List<String> bridge, String path) {
        BridgeController.printMoving(path);
        List<String> bridgeByUser = new ArrayList<>();

        if (isUserPathEqualsBridge(bridge, path)) {
            addCorrectPath(bridgeByUser, path);
        }
        if (!isUserPathEqualsBridge(bridge, path)) {
            addWrongPath(bridgeByUser, path);
        }
        bridgeNumber++;
        return bridgeByUser;
    }

    public void addWrongPath(List<String> isCorrectBridge, String path) {
        isCorrectBridge.add(path);
        isCorrectBridge.add(StringConstant.WRONG_PATH.getConstant());
    }

    public void addCorrectPath(List<String> isCorrectBridge, String path) {
        isCorrectBridge.add(path);
        isCorrectBridge.add(StringConstant.CORRECT_PATH.getConstant());
    }

    public boolean isUserPathEqualsBridge(List<String> bridge, String path){
        return bridge.get(bridgeNumber).equals(path);
    }

    public void checkCorrectPath(List<String> bridge, List<String> upSide, List<String> downSide) {
        if (bridge.size() == upSide.size()) {
            BridgeController.printResult(upSide, downSide, countTryNumber);
            return;
        }
        List<String> userMove = getUserMove(bridge);

        if (userMove.get(0).equals("U") && userMove.get(1).equals("O")) {
            upSide.add(StringConstant.CORRECT_PATH.getConstant());
            downSide.add(" ");
            BridgeController.printMap(upSide, downSide);
            checkCorrectPath(bridge, upSide, downSide);
        }
        if (userMove.get(0).equals("D") && userMove.get(1).equals("O")) {
            upSide.add(" ");
            downSide.add(StringConstant.CORRECT_PATH.getConstant());
            BridgeController.printMap(upSide, downSide);
            checkCorrectPath(bridge, upSide, downSide);
        }
        if (userMove.get(0).equals("U") && userMove.get(1).equals("X")) {
            upSide.add(StringConstant.WRONG_PATH.getConstant());
            downSide.add(" ");
            BridgeController.printMap(upSide, downSide);
            retry(bridge, upSide, downSide);
        }
        if (userMove.get(0).equals("U") && userMove.get(1).equals("X")) {
            upSide.add(" ");
            downSide.add(StringConstant.WRONG_PATH.getConstant());
            BridgeController.printMap(upSide, downSide);
            retry(bridge, upSide, downSide);
        }
    }

    public List<String> getUserMove(List<String> bridge) {
        return addUserMove(bridge, BridgeController.getMoving());
    }

    public void retry(List<String> bridge, List<String> upSide, List<String> downSide) {
        String retryOrQuit = BridgeController.getGameCommand();
        BridgeController.printRetryOrQuit(retryOrQuit);
        if (isUserInputRetry(retryOrQuit)) {
            countTryNumber++;
            checkCorrectPath(bridge, upSide, downSide);
        }
        if (isUserInputQuit(retryOrQuit)) {
            BridgeController.printResult(upSide, downSide, countTryNumber);
        }
    }

    public boolean isUserInputRetry(String retryOrQuit) {
        return retryOrQuit.equals(StringConstant.RETRY.getConstant());
    }

    public boolean isUserInputQuit(String retryOrQuit) {
        return retryOrQuit.equals(StringConstant.QUIT.getConstant());
    }
}
