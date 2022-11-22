package bridge;

import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static bridge.validate.Validator.validateSizeRange;

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
        List<Integer> bridgeNumberList = new ArrayList<>();
        for (int i=0; i<size; i++) {
            bridgeNumberList.add(bridgeNumberGenerator.generate());
        }
        return changeToStringBridge(bridgeNumberList);
    }

    public List<String> inputBridgeSize() {
        int size = InputView.readBridgeSize();
        try {
            validateSizeRange(size);
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
        return makeBridge(size);
    }



    private List<String> changeToStringBridge(List<Integer> bridgeNumberList) {
        return bridgeNumberList.stream()
                .map(num -> toAlphabet(num))
                .collect(Collectors.toList());
    }

    private String toAlphabet(int num) {
        if (num == 1) {
            return "U";
        }
        return "D";
    }
}
