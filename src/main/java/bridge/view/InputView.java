package bridge.view;

import static bridge.util.Message.*;

import bridge.util.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 제공된 InputView 클래스를 활용해 구현해야 한다.
 InputView의 패키지는 변경할 수 있다.
 InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    private final static Validator validator = new Validator();

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);

        String input;
        input = Console.readLine();
        try{
            validator.isRightBridgeGenerateInput(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input;

        System.out.println(SELECT_MOVE);
        input = Console.readLine();
        try{
            validator.isRightOrder(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMoving();
        }

        return input;
    }

    public String readGameCommand() {
        String input;

        System.out.println(SELECT_RESTART);
        input = Console.readLine();
        try{
            validator.isRightEndOrder(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return input;
    }
}
