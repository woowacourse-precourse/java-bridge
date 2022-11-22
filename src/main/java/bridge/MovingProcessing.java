package bridge;

import java.util.ArrayList;
import java.util.List;

public class MovingProcessing {

    private final InputView inputView;
    private final RandomBridge randomBridge;
    private final OutputView outputView;
    private final List<String> upSide;
    private final List<String> downSide;

    public MovingProcessing() {
        inputView = new InputView();
        randomBridge = new RandomBridge();
        randomBridge.initBridge();
        outputView = new OutputView();
        upSide = new ArrayList<>();
        downSide = new ArrayList<>();
    }

    /**
     * 사용자로부터 움직임(U, D)을 입력받습니다.
     */
    public boolean readMove() {
        List<String> bridge = randomBridge.getBridge();
        while (upSide.size() < bridge.size()) {
            String input = inputView.readMoving();
            if (input.length() == 0)
                continue;
            if (!compareBridgeToInput(input, bridge)) {
                return false;
            }
        }
        return true;
    }

    //이부분 바꿀 수 있다면 노력해보자

    /**
     * 랜덤으로 입력된 브릿지를 매개변수로 사용자의 입력과 매치한다.
     */
    public boolean compareBridgeToInput(final String input, final List<String> bridge) {
        boolean isSuccess = true;
        int index = upSide.size();
        isSuccess = jumpToBridge(input, bridge.get(index));
        outputView.printMap(upSide, downSide);
        if (!isSuccess) {
            return isSuccess;
        }
        return isSuccess;
    }

    private boolean jumpToBridge(final String input, final String bridge) {
        boolean isEquals = input.equals(bridge);
        if (!isEquals) {
            selectedBridgeIsFail(input);
            return false;
        }
        selectedBridgeIsSucceed(input);
        return true;
    }

    private void selectedBridgeIsSucceed(final String input) {
        if (input.equals("U")) {
            upSide.add("O");
            downSide.add(" ");
        }
        if (input.equals("D")) {
            upSide.add(" ");
            downSide.add("O");
        }
    }

    private void selectedBridgeIsFail(final String input) {
        if (input.equals("U")) {
            upSide.add("X");
            downSide.add(" ");
        }
        if (input.equals("D")) {
            upSide.add(" ");
            downSide.add("X");
        }
    }

    public List<String> getUpSide() {
        return upSide;
    }

    public List<String> getDownSide() {
        return downSide;
    }

}
