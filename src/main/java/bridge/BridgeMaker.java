package bridge;

import bridge.exception.IllegalBridgeSizeException;
import bridge.utils.BridgePositionParser;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.BridgeRule.MAXIMUM_SIZE;
import static bridge.constant.BridgeRule.MINIMUM_SIZE;


/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * <p>
 * 유의사항(차후 지울 내용 )
 * 메서드 시그니처와 반환타입 변경 불가.
 * 필드를 변경할 수 없음.
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
        List<String> bridgeFrame = new ArrayList<>();

        validate(size);
        for (int countAdd = 0; countAdd < size; countAdd++) {
            makePartOfBridge(bridgeFrame);
        }

        return bridgeFrame;
    }

    public void validate(int size) {
        if (size > MAXIMUM_SIZE.getSize() ||
                size < MINIMUM_SIZE.getSize()) {
            throw new IllegalBridgeSizeException();
        }
    }

    private void makePartOfBridge(List<String> bridgeFrame) {
        String position = BridgePositionParser.parsePositionToStringForm(bridgeNumberGenerator.generate());
        bridgeFrame.add(position);
    }
}
