package bridge.View;

import bridge.Util.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_LENGTH_SENTENCE= "다리의 길이를 입력해주세요.";

    private final Validation validation;

    public InputView() {
        this.validation = new Validation();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_LENGTH_SENTENCE);
        String inputLength = Console.readLine();
        try{
            validation.isValidateSize(inputLength);
            return Integer.parseInt(inputLength);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return readBridgeSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
