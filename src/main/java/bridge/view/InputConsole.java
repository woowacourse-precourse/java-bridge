package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputConsole implements Input{
    @Override
    public Integer inputInteger() {
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public String inputString() {
        return Console.readLine();
    }
}
