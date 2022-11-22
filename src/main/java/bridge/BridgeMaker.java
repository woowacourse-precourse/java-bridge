package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constants.*;

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
        List<String> bridgeList = new ArrayList<>();
        for(int count = 0; count < size; count++) {
            int number = makeRandomNumber();
            String bridgeShape = discriminateBridgeShape(number);
            bridgeList.add(bridgeShape);
        }
        return bridgeList;
    }

    int makeRandomNumber(){
        int number;
        while(true) {
            try {
                number = bridgeNumberGenerator.generate();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                continue;
            }
            break;
        }
        return number;
    }

    String discriminateBridgeShape(int bridgeNumber){
        if(bridgeNumber == UP) {
           return "U";
        }
        if(bridgeNumber == DOWN){
            return "D";
        }
        System.out.println(ERROR_PREFIX + RANDOM_ERROR);
        throw new IllegalArgumentException(ERROR_PREFIX + RANDOM_ERROR);
    }
}
