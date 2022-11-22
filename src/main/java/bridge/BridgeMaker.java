package bridge;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final String upMove="U";
    private final String downMove="D";
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    private List<Integer> makeRandomNumber(int size){
        List<Integer> randomList=new ArrayList<>();
        for(int i=0;i<size;i++){
            randomList.add(bridgeNumberGenerator.generate());
        }
        return randomList;
    }

    public List<String> makeBridgeList(int size,List<Integer> randomList){
        List<String> bridgeList=new ArrayList<>();
        for(int i=0;i<size;i++){
            if(randomList.get(i)==1){
                bridgeList.add(upMove);
                continue;
            }
            bridgeList.add(downMove);
        }
        return bridgeList;
    }

    public List<String> makeBridge(int size){
        return makeBridgeList(size,makeRandomNumber(size));
    }
}
