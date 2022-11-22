package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.validate.Validator.validateAlphabet;
import static bridge.validate.Validator.validateDigit;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        OutputView.printInputSize();
        String input = Console.readLine();
        try{
            validateDigit(input);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        OutputView.printMove();
        String input = Console.readLine();
        try{
            validateAlphabet(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.printRetry();
        String input = Console.readLine();
        try{
            validateAlphabet(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return input;
    }


}
