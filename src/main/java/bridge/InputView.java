package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        input = validInput(input,ErrorMessage.BRIDGELENGTHERROREXCEPTION);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        input = validInput(input,ErrorMessage.WRONGMOVEINPUTEXCEPTION);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        input = validInput(input,ErrorMessage.WRONGGAMEENDINPUTEXCEPTION);
        return input;
    }

    public String validInput(String input,ErrorMessage errorMessage){
        String checkMessage = this.checkMessage(input, errorMessage);
        while (!checkMessage.equals(ErrorMessage.PASS.getErrorMessage())) {
            System.out.println(checkMessage);
            input = Console.readLine();
            checkMessage = this.checkMessage(input, errorMessage);
        }
        return input;
    }

    public String checkMessage(String value, ErrorMessage errorValue) {
        StringBuilder stringBuilder = new StringBuilder("[ERROR] ");
        if (errorValue.equals(ErrorMessage.BRIDGELENGTHERROREXCEPTION))
            errorValue = bridgeLengthChecker(value);
        if (errorValue.equals(ErrorMessage.WRONGGAMEENDINPUTEXCEPTION))
            errorValue = endGameChecker(value);
        if (errorValue.equals(ErrorMessage.WRONGMOVEINPUTEXCEPTION))
            errorValue = moveInputChecker(value);
        if (!errorValue.equals(ErrorMessage.PASS))
            return stringBuilder.append(errorValue.getErrorMessage()).toString();
        return ErrorMessage.PASS.toString();
    }

    private ErrorMessage moveInputChecker(String value) {
        if (value.equals(BridgeJoyStick.U.toString()) || value.equals(BridgeJoyStick.D.toString()))
            return ErrorMessage.PASS;
        return ErrorMessage.WRONGMOVEINPUTEXCEPTION;
    }

    private ErrorMessage endGameChecker(String value) {
        if (value.equals(BridgeJoyStick.R.toString()) || value.equals(BridgeJoyStick.Q.toString()))
            return ErrorMessage.PASS;
        return ErrorMessage.WRONGGAMEENDINPUTEXCEPTION;
    }

    public ErrorMessage bridgeLengthChecker(String value) {
        try {
            int length = Integer.parseInt(value);
            if (length < 3 || length > 20)
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            return ErrorMessage.BRIDGELENGTHERROREXCEPTION;
        }
        return ErrorMessage.PASS;
    }
}
