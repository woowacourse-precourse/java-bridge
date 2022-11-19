package bridge.view;

import bridge.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int inputBridgeSize() {
        OutputView.printInputBridgeSizeMessage();
        String inputSize = Console.readLine();
        Validator.validateInputBridgeSizeType(inputSize);
        Validator.validateInputBridgeSizeRange(inputSize);
        return Integer.parseInt(inputSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String inputMoving() {
        OutputView.printMovingSelectMessage();
        String moveWord = Console.readLine();
        Validator.validateMovingWord(moveWord);
        return moveWord;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String inputGameCommand() {
        return Console.readLine();
    }




}
