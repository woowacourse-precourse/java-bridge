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
        InputView inputView = new InputView();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            answer.add(number);
        }
        System.out.println(answer);

        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == 1 && inputView.readMoving().equals("U")) {
                upperBridge.add("O | ");
                lowerBridge.add("  | ");
            }
            if (answer.get(i) == 0 && inputView.readMoving().equals("D")) {
                upperBridge.add("  | ");
                lowerBridge.add("O | ");
            }
        }


        System.out.println("upperBridge = " + upperBridge.toString());
        System.out.println("lowerBridge = " + lowerBridge.toString());
        return null;
    }
}
