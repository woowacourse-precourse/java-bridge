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

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try{
            System.out.println("다리의 길이를 입력해주세요.");
            String input = Console.readLine();
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
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = Console.readLine();

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
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String input = Console.readLine();
            GameCommandValidator.validate(input);

            return input;
        }
        catch (IllegalArgumentException e){
            return readGameCommand();
        }
    }
}
