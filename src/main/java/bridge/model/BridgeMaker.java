package bridge.model;

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
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */

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
                bridgeList.add("U");
                continue;
            }
            bridgeList.add("D");
        }
        return bridgeList;
    }
    public List<String> makeBridge(int size){
        return makeBridgeList(size,makeRandomNumber(size));
    }
}
