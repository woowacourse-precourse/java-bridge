package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * 필드(인스턴스 변수)를 변경할 수 없다.
 * 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 "없다".
 */
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
        if(!(3<=number && number <= 20)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_RANGE.toString());
        }
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        String[] convertToString = {"D", "U"};
        for(int i = 0; i<size; i++) {
            bridge.add(convertToString[bridgeNumberGenerator.generate()]);
        }
        return bridge;
    }
}
