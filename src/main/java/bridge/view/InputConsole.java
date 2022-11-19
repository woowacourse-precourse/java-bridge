package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import static bridge.exeption.Exception.*;
public class InputConsole implements Input{
    private String input;

    @Override
    public Integer inputInteger() {
        input = Console.readLine();
        catchNotNumberException(input);
        return Integer.parseInt(input);
    }
    @Override
    public String inputString() {
        return Console.readLine();
    }
}
