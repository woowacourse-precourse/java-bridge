package bridge.view;

import bridge.view.phrases.InputPhrases;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String readBridgeSize() {
        System.out.println(InputPhrases.readBridgeSize.getPhrase());
        return readLine();
    }

    public static String readMoving() {
        System.out.println(InputPhrases.readMoving.getPhrase());
        return readLine();
    }

    public static String readGameCommand() {
        System.out.println(InputPhrases.readGameCommand.getPhrase());
        return readLine();
    }
}
