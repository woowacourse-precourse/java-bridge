package bridge.view;

import bridge.domain.bridge.BridgeSize;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.RestartCommand;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView extends IOPrinter {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        this.printlnBeforeNextLine("다리의 길이를 입력해주세요.");
        var input = readLine();
        this.println();
        return new BridgeSize(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgePosition readMoving() {
        this.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return BridgePosition.convertCodeToPosition(readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public RestartCommand readGameCommand() {
        this.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return RestartCommand.generateCommand(readLine());
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalStateException("[ERROR] 입력할 수 없는 값입니다.");
        }
    }
}
