package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    InputView inputView = new InputView();
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }



    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<String>();
        int[] randomNumbers = new int[size];
        String input = inputView.getReadMoving();
        for(int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = bridgeNumberGenerator.generate();
        }
        if(randomNumbers[0] == 1) {
            System.out.println("U");
        }
        if(randomNumbers[0] == 0) {
            System.out.println("D");
        }
        List<String> finalBridge = connectBridge(bridge, randomNumbers, input);

        return finalBridge;
    }

    public List<String> connectBridge(List<String> bridge, int[] randomNumbers, String input) {
        for(int i = 0; i < randomNumbers.length; i++) {
            if(randomNumbers[i] == 1 && input.equals("U")) {
                bridge.add("O");
            }
            if(randomNumbers[i] == 1 && input.equals("D")) {
                bridge.add("X");
            }
            if(randomNumbers[i] == 0 && input.equals("D")) {
                bridge.add("O");
            }
            if(randomNumbers[i] == 0 && input.equals("U")) {
                bridge.add("X");
            }
        }
        return bridge;
    }
}
