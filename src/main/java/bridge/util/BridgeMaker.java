package bridge.util;

import bridge.model.entity.UpAndDown;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.entity.UpAndDown.getDirection;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
/**
 - 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
 - `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
 - `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
 */

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < size; i++){
            answer.add(createDirection());
        }
        return answer;
    }
    private String createDirection(){
        try {
            return getDirection(bridgeNumberGenerator.generate());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return createDirection();
        }
    }
}
