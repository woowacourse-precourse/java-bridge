package bridge.view.io;

import static bridge.domain.bridge.BridgeSize.makeBridgeSize;
import static bridge.value.BridgeCharacter.makeBridgeCharacter;
import static bridge.value.GameCommand.makeGameCommand;
import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.bridge.BridgeSize;
import bridge.value.BridgeCharacter;
import bridge.value.GameCommand;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        return makeBridgeSize(readInt());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeCharacter readMoving() {
        return makeBridgeCharacter(readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        return makeGameCommand(readLine());
    }

    private int readInt() {
        try {
            return Integer.parseInt(readLine());

        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("다리의 길이 형식인 정수 형식이 아닙니다.");
        }
    }

}
