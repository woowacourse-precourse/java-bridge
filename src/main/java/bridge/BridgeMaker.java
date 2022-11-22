package bridge;

import java.util.ArrayList;
import java.util.List;


/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private enum UpDown{
        UP(1,"U"),
        DOWN(0,"D");

        String upDown;

        UpDown(int generateNumber, String upDown) {
            this.upDown = upDown;
        }
        public String getUpDown(){
            return upDown;
        }

    }

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }


    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>(size);
        for (int i = Constant.ZERO ; i < size ; i++){
            int randomNumber = bridgeNumberGenerator.generate();
            UpDown origin = selectUpDownFromOrigin(randomNumber);
            bridge.add(origin.getUpDown());
        }
        return bridge;
    }

    private UpDown selectUpDownFromOrigin(int randomNumber) {
        if (randomNumber == Constant.ONE) {
            return UpDown.UP;
        }
        return UpDown.DOWN;
    }
}
