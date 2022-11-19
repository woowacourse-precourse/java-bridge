package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String>bridgeList= new ArrayList<>();
        for(int i=0;i<size;i++){
            int number = bridgeNumberGenerator.generate();
            convertBridge(bridgeList,number);
        }
        return bridgeList;
    }

    public void convertBridge(List<String>bridgeList,int number){
        if(number==1){
            bridgeList.add("U");
        }
        if(number==0){
            bridgeList.add("D");
        }
    }

}
