package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private  int brigeSize=0;
     Bridge bridge= new Bridge();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public void startMakeBridge(int size){
        setBrigeSize(size);
        bridge=generateBridge();
        makeBridge(size);
    }
    public void setBrigeSize(int size){
        brigeSize=size;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<Integer> bridgeNumbers=bridge.getBridgeAnswer();
        List<String> bridgeShape=new ArrayList<>();
        for(int i=0;i<bridgeNumbers.size();i++){
            bridgeShape.add(numberToString(bridgeNumbers.get(i)));
        }
        System.out.println("다리 모양:"+bridgeShape);
        return bridgeShape;
    }

    public String numberToString(int number){
        if(number==0)
            return "U";
        return "D";
    }

    public Bridge generateBridge(){
        List<Integer> brigeRandomNumbers=new ArrayList<>();
        for(int i=0;i<brigeSize;i++){
            int bridgeValue=bridgeNumberGenerator.generate();
            brigeRandomNumbers.add(bridgeValue);
        }
        Bridge bridge=new Bridge(brigeRandomNumbers);
        System.out.println("bridge.number:"+bridge.getBridgeAnswer()+", bridgeandomNumber:"+brigeRandomNumbers);
        return bridge;
    }

}
