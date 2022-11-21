package bridge.service;

import static bridge.util.Message.SELECT_DOWN;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
 BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
 BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<size; i++)
            result.add(transNumberToOrder(bridgeNumberGenerator.generate()));

        return result;
    }

    private String transNumberToOrder(int data){
        if(data == SELECT_DOWN) return "D";
        return "U";
    }
}
