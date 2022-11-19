package bridge.domain;

import bridge.view.InputView;

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
    public List<String> makeBridge(int size) {
        List<Integer> bridgeNumber = new ArrayList<>(size);
        List<String> bridgeText = putValue(bridgeNumber);

        checkText(bridgeText);

        return bridgeText;
    }

    public String splitBridge(int bridgeOrder){
        List<String> bridge = makeBridge(InputView.readBridgeSize());

        return bridge.get(bridgeOrder);
    }

    public List<String> putValue(List<Integer> bridgeNumber){
        List<String> bridgeText = new ArrayList<>();

        for(int index = 0; index < bridgeNumber.size(); index++){
            bridgeNumber.add(bridgeNumberGenerator.generate());
            bridgeText.add(putText(bridgeNumber.get(index)));
        }
        checkNumber(bridgeNumber);
        return bridgeText;
    }

    public static String putText(int bridgeNumber){
        String bridgeText;

        if(bridgeNumber == 0) return bridgeText = "U";

        return bridgeText = "D";
    }

    private void checkNumber(List<Integer> bridgeNumber){
        for(int putNumber : bridgeNumber){
            if(!(putNumber == 0 || putNumber == 1)){
                throw new IllegalArgumentException("[ERROR] 시스템 오류입니다. 재시작 하세요.");
            }
        }
    }

    private void checkText(List<String> bridgeText){
        for(String putText : bridgeText){
            if(!(putText == "U" || putText == "D")){
                throw new IllegalArgumentException("[ERROR] 시스템 오류입니다. 재시작 하세요.");
            }
        }
    }
}
