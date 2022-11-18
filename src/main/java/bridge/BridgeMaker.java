package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final String UPPER = "U";
    private final String LOWER = "D";
    private final Integer UPPER_INCLUSIVE = 1;
    private final BridgeNumberGenerator bridgeNumberGenerator;
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> newList = new ArrayList<>();
        for(int i=0;i<size;i++){
            newList.add(upDown(bridgeNumberGenerator.generate()));
        }
        return newList;
    }

    private String upDown(Integer position){
        if(position.equals(UPPER_INCLUSIVE)) return UPPER;
        return LOWER;
    }
}
