package bridge;

import java.util.List;
import java.util.ArrayList;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeShape = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            bridgeShape.add(convertToShape(randomNumber));
        }
        return bridgeShape;
    }
    private String convertToShape(int randomNumber) {
        if (randomNumber == BridgeShaper.UP.getNumber()) {
            return BridgeShaper.UP.getShape();
        }
        return BridgeShaper.DOWN.getShape();
    }
}

enum BridgeShaper {
    UP(1, "U"),
    DOWN(0, "D");

    private final int randomNumber;
    private final String bridgeShape;

    BridgeShaper(int randomNumber, String bridgeShape) {
        this.randomNumber = randomNumber;
        this.bridgeShape = bridgeShape;
    }

    public String getShape() {
        return bridgeShape;
    }

    public int getNumber() {
        return randomNumber;
    }
}
