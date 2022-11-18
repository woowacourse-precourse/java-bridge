package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {


    private final BridgeNumberGenerator bridgeNumberGenerator;
    //  private List<String> bridgeFormat=new ArrayList<>();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        int bridgeFormat=  bridgeNumberGenerator.generate();

        if(size==0) return new ArrayList<>();

        if (1 == bridgeFormat) makeBridge(size - 1).add("U");
        if (0 == bridgeFormat) makeBridge(size-1).add("D");

        return new ArrayList<>();
    }
}
