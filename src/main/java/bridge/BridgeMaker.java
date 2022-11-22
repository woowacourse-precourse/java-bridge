package bridge;

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
        return null;
    }
}

// 추가된 요구 사항
// 1.제공된 BridgeMaker 클래스를 활용해 구현
// 2.BridgeMaker의 필드(인스턴스 변수)를 변경 불가능
// 3.BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입 변경 불가능
