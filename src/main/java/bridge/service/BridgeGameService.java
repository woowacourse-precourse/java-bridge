package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {
    private final BridgeMaker bridgeMaker;

    public BridgeGameService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> initializeGame() {
        OutputView.printStart();
        return bridgeMaker.makeBridge(getSize());
    }

    private int getSize() {
        int size = 0;
        while (size == 0) {
            try {
                OutputView.printInputBridgeSize();
                size = InputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return size;
    }

    public Status proceedGame(List<String> bridge) {
        List<String> userMoving = new ArrayList<>();
        while (bridge.size() >= userMoving.size()) {
            userMoving.add(getMoving());
            OutputView.printMap(bridge, userMoving);
            if (!isSuccess(bridge, userMoving)) {
                return Status.FAIL;
            }
        }
        return Status.SUCCESS;
    }

    private String getMoving() {
        String moving = "";
        while (moving.equals("")) {
            try {
                OutputView.printInputMoving();
                moving = InputView.readMoving();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return moving;
    }

    private boolean isSuccess(List<String> bridge, List<String> userMoving) {
        for (int index = 0; index < userMoving.size(); index++) {
            String bridgeValue = bridge.get(index);
            String userValue = userMoving.get(index);

            if (!bridgeValue.equals(userValue)) {
                return false;
            }
        }
        return true;
    }
}
