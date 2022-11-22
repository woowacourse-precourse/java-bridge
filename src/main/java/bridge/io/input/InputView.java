package bridge.io.input;

import bridge.io.output.OutputView;
import bridge.util.Validator;
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
        return Integer.parseInt(readAndValidate("다리의 길이를 입력해주세요.", blValidator));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return readAndValidate("이동할 칸을 선택해주세요. (위: U, 아래: D)", udValidator);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return readAndValidate("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)", rValidator);
    }

    public String readAndValidate(String question, Validator validator) {
        while (true) {
            try {
                System.out.println(question);
                return validator.validate(readLine());
            } catch (IllegalArgumentException e) {
                OutputView.printIllegalArgumentException(e.getMessage());
            }
        }
    }
}
