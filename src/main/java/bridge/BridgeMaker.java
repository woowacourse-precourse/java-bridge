package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    //제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
    //BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
    //BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> crossableBridge = new ArrayList<>();
        for(int i=0; i<size; i++){
            crossableBridge.add(letThereBeCrossable(bridgeNumberGenerator.generate()));
        }
        return crossableBridge;
    }

    private String letThereBeCrossable(int oneOrZero){
        if(oneOrZero==0){
            return "D";
        }
        return "U";
    }
}
