package bridge.view;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.GameCommandValidator;
import bridge.validator.MovingValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputView(){
    }

    private static String readInput(String message){
        System.out.println(message);
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try{
            String input = readInput("다리의 길이를 입력해주세요.");
            BridgeSizeValidator.validate(input);

            return Integer.parseInt(input);
        }
        catch (IllegalArgumentException e){
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        try {
            String input = readInput("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            BridgeSizeValidator.validate(input);

            MovingValidator.validate(input);
            return input;
        } catch (IllegalArgumentException e) {
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try{
            String input = readInput("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            GameCommandValidator.validate(input);

            return input;
        }
        catch (IllegalArgumentException e){
            return readGameCommand();
        }
    }
}
