package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        bridgeSizeCheck(size);
        List<String> bridge=new ArrayList<>();
        for(int count=0; count<size; count++)
            bridge.add(upDownFilter(bridgeNumberGenerator.generate()));
        return bridge;
    }
    private void bridgeSizeCheck(int size){
        if(size <3 || size>20)  throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
    private String upDownFilter(int RandomNumber){
        if(RandomNumber==1) return "U";
        return "D";
    }
}
