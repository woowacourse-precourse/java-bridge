package bridge.view;

import bridge.dto.BridgeSizeDTO;
import bridge.dto.GameCommandDTO;
import bridge.dto.MovingDTO;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeDTO readBridgeSize() {
        final String inputBridgeSize = Console.readLine();
        return new BridgeSizeDTO(Integer.parseInt(inputBridgeSize));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MovingDTO readMoving() {
        final String inputMoving = Console.readLine();
        return new MovingDTO(inputMoving);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommandDTO readGameCommand() {
        final String inputGameCommand = Console.readLine();
        
        return new GameCommandDTO(inputGameCommand);
    }
}
