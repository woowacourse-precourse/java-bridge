package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public int requestReadBridgeSize() {
        InputView inputView = new InputView();
        int number = inputView.readBridgeSize();
        try {
            isValid(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            number = requestReadBridgeSize();
        }
        return number;
    }

    public void isValid(int number) {
        if (!(3 <= number && number <= 20)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_RANGE.toString());
        }
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        String[] convertToString = {"D", "U"};
        for (int i = 0; i < size; i++) {
            bridge.add(convertToString[bridgeNumberGenerator.generate()]);
        }
        return bridge;
    }
}
