package bridge;

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
    public List<String> upperMap;
    public List<String> lowerMap;

    public List<String> makeBridge(int size) {
        BridgeRandomNumberGenerator ranVal = new BridgeRandomNumberGenerator();
        InputView input = new InputView();
        if (input.readMoving() == "U" && ranVal.generate() == 0) {
            upperMap.add("X");
            lowerMap.add(" ");
        } else if (input.readMoving() == "U" && ranVal.generate() == 1) {
            upperMap.add("O");
            lowerMap.add(" ");
        } else if (input.readMoving() == "D" && ranVal.generate() == 0) {
            upperMap.add("");
            lowerMap.add("O");
        } else if (input.readMoving() == "D" && ranVal.generate() == 1) {
            upperMap.add(" ");
            lowerMap.add("X");
        }
        upperMap.add(" | ");
        lowerMap.add(" | ");

        return null;
    }

}
