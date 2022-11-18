package bridge.domain;

import static bridge.BridgeExpression.DOWN;
import static bridge.BridgeExpression.UP;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker{

    private final BridgeNumberGenerator bridgeNumberGenerator;


    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {

        List<String> bridge = new ArrayList<>();

        for (int index = 0; index < size; index++) {
            bridge.add(expressionByNumber());
        }

        return bridge;
    }

    // 건널 수 있는 칸을 표현한다.
    public String expressionByNumber() {
        String expression = "";
        int generate = bridgeNumberGenerator.generate();
        if (generate == 0) {
            expression = DOWN.expression();
        }
        if (generate == 1) {
            expression = UP.expression();
        }
        return expression;
    }


}

