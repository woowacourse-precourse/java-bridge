package bridge.domain;

import static bridge.domain.constants.MoveCommands.MOVE_DOWN_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * TODO 필드(인스턴스 변수) 변경 불가!!!!!!
 * TODO 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 불가!!!!!
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
    public List<String> makeBridge(final int size) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();

            final int NUMBER_FOR_MOVE_UP = 1;
            if (randomNumber == NUMBER_FOR_MOVE_UP) {
                results.add(MOVE_UP_COMMAND);
                continue;
            }

            results.add(MOVE_DOWN_COMMAND);
        }

        return results;
    }
}
