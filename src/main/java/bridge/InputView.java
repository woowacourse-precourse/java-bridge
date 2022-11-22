package bridge;

import bridge.EnumClass.EnumConstant;
import bridge.EnumClass.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        return Validator.validateBridgeInput(Console.readLine());
    }

    public static String readMoving() {
        return Validator.validateCommand(Console.readLine(), EnumConstant.State_Move);
    }

    public static String readGameCommand() {
        return Validator.validateCommand(Console.readLine(), EnumConstant.State_Retry);
    }
}
