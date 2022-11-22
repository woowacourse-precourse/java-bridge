package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeShape = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            bridgeShape.add(convertToShape(randomNumber));
        }
        return bridgeShape;
    }

    private String convertToShape(int randomNumber) {
        if (randomNumber == NumberToShape.UP.getNumber()) {
            return NumberToShape.UP.getShape();
        }
        return NumberToShape.DOWN.getShape();
    }
}

enum NumberToShape {
    UP(1, "U"),
    DOWN(0, "D");

    private final int randomNumber;
    private final String bridgeShape;

    NumberToShape(int randomNumber, String bridgeShape) {
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