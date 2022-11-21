package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String inputValue = readLine();
        try {
            validator.validateBridgeSize(inputValue);
            return Integer.parseInt(inputValue);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputValue = readLine();
        try {
            validator.validateMoving(inputValue);
            return inputValue;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String inputValue = readLine();
        try {
            validator.validateGameCommand(inputValue);
            return inputValue;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readGameCommand();
        }
    }

    public String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalStateException("[ERROR] 입력 값이 없습니다.");
        }
    }
}
