package bridge.Entity;

import bridge.BridgeNumberGenerator;
import bridge.View.InputValidate;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> userBridge = new ArrayList<>();
        for (int i=0;i<size;i++) {
            userBridge.add(checkedNumber());
        }
        return userBridge;
    }

    private String checkedNumber() {
        String input;
        outputView.guideEnterBridgeSize();
        while (!isValidate(input = inputView.readMoving()))
            outputView.guideEnterMove();
        return input;
    }

    private boolean isValidate(String input) {
        try {
            InputValidate inputValidate = new InputValidate();
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

}
