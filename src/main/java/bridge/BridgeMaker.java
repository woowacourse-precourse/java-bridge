package bridge;

import bridge.Util.COMMAND_CONSTANTS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(bridgeNumberGenerator.generate());
        }
        return result.stream().map(this::mapToCommand).collect(Collectors.toList());
    }

    private String mapToCommand(int command){
        if(command == COMMAND_CONSTANTS.MOVE_UP.getValue()){
            return COMMAND_CONSTANTS.MOVE_UP.getCommand();
        }
        if(command == COMMAND_CONSTANTS.MOVE_DOWN.getValue()){
            return COMMAND_CONSTANTS.MOVE_DOWN.getCommand();
        }
        return null;
    }
}
