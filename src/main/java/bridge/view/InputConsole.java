package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import static bridge.exeption.Exception.*;
public class InputConsole implements Input{
    private String input;

    @Override
    public Integer getInputInteger() {
        input = Console.readLine();
        catchNotNumberException(input);
        catchZeroInputException(input);
        return Integer.parseInt(input);
    }
    @Override
    public String getInputMove() {
        input = Console.readLine();
        catchMoveInputException(input);
        return input;
    }
    @Override
    public String getInputRetry(){
        input = Console.readLine();
        catchRetryInputException(input);
        return input;
    }
}
