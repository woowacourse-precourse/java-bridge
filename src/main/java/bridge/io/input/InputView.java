package bridge.io.input;

import bridge.util.validator.BridgeLengthValidator;
import bridge.util.validator.RestartValidator;
import bridge.util.validator.UpDownValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final BridgeLengthValidator blValidator;
    private final UpDownValidator udValidator;
    private final RestartValidator rValidator;

    public InputView() {
        this.blValidator = new BridgeLengthValidator();
        this.udValidator = new UpDownValidator();
        this.rValidator = new RestartValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");

        return Integer.parseInt(blValidator.validate(readLine()));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        return udValidator.validate(readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        return rValidator.validate(readLine());
    }
}
