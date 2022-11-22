package bridge;
import java.util.ArrayList;
import java.util.List;
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public List<String> makeBridge(int size) {
        List<String> realBridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            realBridge.add(getBridge());
        }
        return realBridge;
    }
    private String getBridge(){
        int generate = bridgeNumberGenerator.generate();
        String bridge = null;
        if(generate ==0 ){bridge="D";}
        if(generate == 1){bridge="U";}
        return bridge;
    }
}