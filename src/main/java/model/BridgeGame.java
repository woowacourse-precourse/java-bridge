package model;

import constant.GameConstant;
import controller.BridgeController;
import constant.StringConstant;
import domain.BridgeSize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGame {
    private static int tryNumber = GameConstant.FIRST_TRY.getConstant();

    public void run() {
        List<String> upSide = new ArrayList<>();
        List<String> downSide = new ArrayList<>();
        List<String> bridge = BridgeController.makeBridge();
        checkNextPath(bridge, upSide, downSide);
        BridgeController.printResult(upSide, downSide, tryNumber);
    }

    public List<String> move(String path) {
        List<String> bridgeByUser = new ArrayList<>();
        addPathInBridgeByUser(bridgeByUser, path);
//        countBridgeNumber();
        return Collections.unmodifiableList(bridgeByUser);
    }

    public void retry(List<String> bridge, List<String> upSide, List<String> downSide) {
        String retryOrQuit = BridgeController.getGameCommand();
        BridgeController.printRetryOrQuit(retryOrQuit);
        if (isUserInputRetry(retryOrQuit)) {
            countTryNumber();
            upSide.clear();
            downSide.clear();
            checkNextPath(bridge, upSide, downSide);
        }
    }

    private void addPathInBridgeByUser(List<String> bridgeByUser, String path) {
        bridgeByUser.add(path);
    }

    public void checkNextPath(List<String> bridge, List<String> upSide, List<String> downSide) {
        List<String> bridgeByUser = new ArrayList<>();
        bridgeByUser.add(BridgeController.getMoving());
        for (int i = 0; i < bridgeByUser.size(); i++) {
            if (BridgeSize.isUserInputDone(bridge, upSide)) {
                return;
            }
            if (bridgeByUser.get(i).equals(bridge.get(i)) && bridge.get(i).equals("U")) {
                BridgeController.printMoving(bridgeByUser.get(i));
                upSide.add(StringConstant.CORRECT_PATH.getConstant());
                downSide.add(StringConstant.BLANK.getConstant());
                BridgeController.printMap(upSide, downSide);
            }
            if (bridgeByUser.get(i).equals(bridge.get(i)) && bridge.get(i).equals("D")) {
                BridgeController.printMoving(bridgeByUser.get(i));
                upSide.add(StringConstant.BLANK.getConstant());
                downSide.add(StringConstant.CORRECT_PATH.getConstant());
                BridgeController.printMap(upSide, downSide);
            }
            if (BridgeSize.isUserInputDone(bridge, upSide)) {
                return;
            }
            if (!bridgeByUser.get(i).equals(bridge.get(i)) && bridge.get(i).equals("D")) {
                BridgeController.printMoving(bridgeByUser.get(i));
                upSide.add(StringConstant.WRONG_PATH.getConstant());
                downSide.add(StringConstant.BLANK.getConstant());
                BridgeController.printMap(upSide, downSide);
                retry(bridge, upSide, downSide);
            }
            if (!bridgeByUser.get(i).equals(bridge.get(i)) && bridge.get(i).equals("U")) {
                BridgeController.printMoving(bridgeByUser.get(i));
                upSide.add(StringConstant.BLANK.getConstant());
                downSide.add(StringConstant.WRONG_PATH.getConstant());
                BridgeController.printMap(upSide, downSide);
                retry(bridge, upSide, downSide);
            }
            if (!bridgeByUser.get(i).equals(bridge.get(i))) {
                break;
            }
            bridgeByUser.add(BridgeController.getMoving());
        }
    }

    private boolean isUserInputRetry(String retryOrQuit) {
        return retryOrQuit.equals(StringConstant.RETRY.getConstant());
    }

    private void countTryNumber() {
        tryNumber++;
    }
}
