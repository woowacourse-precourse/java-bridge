package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

public class ReadLineGenerator {

    private String readLine;

    public String generate() {

        readLine = Console.readLine();
        InputView inputView = new InputView();

        return readLine;
    }
}
