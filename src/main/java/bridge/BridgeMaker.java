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
     * 0 일때 아래 칸, 1 일때 윗 칸
     * 
     * @return
     */
    public String bridgeUD() {
        return Integer.toString(bridgeNumberGenerator.generate());
    }

    /**
     * "0" 일때 아래 칸 D 리턴, "1" 일때 윗 칸 U 리턴
     * 
     * @param bridgeUD
     * @return
     */
    public String changeBridgeUD(String bridgeUD) {
        if (bridgeUD.equals("0")) {
            return "D";
        }
        if (bridgeUD.equals("1")) {
            return "U";
        }
        return null;

    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */

    /**
     * readBridgeSize 갯수만큼 0,1이 변환된 무작위의 U,D가 add된 List<String>값 return
     * 
     * @param size
     * @return
     */
    public List<String> makeBridge(int size) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            list.add(changeBridgeUD(bridgeUD()));
        }
        return list;
    }
}
