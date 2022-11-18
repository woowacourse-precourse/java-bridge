package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = "";
        while(!this.checkMessage(input,ErrorMessage.BRIDGELENGTHERROREXCEPTION).equals("PASS"))
        {
            input = Console.readLine();
        }
        return Integer.parseInt(input);
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

    public String checkMessage(String value, ErrorMessage errorValue){
        StringBuilder stringBuilder = new StringBuilder("[ERROR] ");
        if(errorValue.equals(ErrorMessage.BRIDGELENGTHERROREXCEPTION))
            errorValue = bridgeLengthChecker(value);
        if(errorValue.equals(ErrorMessage.WRONGGAMEENDINPUTEXCEPTION))
            errorValue = endGameChecker(value);
        if(errorValue.equals(ErrorMessage.WRONGMOVEINPUTEXCEPTION))
            errorValue = moveInputChecker(value);
        if(!errorValue.equals(ErrorMessage.PASS))
            return stringBuilder.append(errorValue.getErrorMessage()).toString();
        return ErrorMessage.PASS.toString();
    }

    private ErrorMessage moveInputChecker(String value) {
        if(value.equals("U")||value.equals("D"))
            return ErrorMessage.PASS;
        return ErrorMessage.WRONGMOVEINPUTEXCEPTION;
    }

    private ErrorMessage endGameChecker(String value) {
        if(value.equals("R")||value.equals("Q"))
            return ErrorMessage.PASS;
        return ErrorMessage.WRONGGAMEENDINPUTEXCEPTION;
    }

    public ErrorMessage bridgeLengthChecker(String value)
    {
        try{
            int length = Integer.parseInt(value);
            if(length<3||length>20)
                throw new NumberFormatException();
        }
        catch(NumberFormatException e)
        {
            return ErrorMessage.BRIDGELENGTHERROREXCEPTION;
        }
        return ErrorMessage.PASS;
    }
}
