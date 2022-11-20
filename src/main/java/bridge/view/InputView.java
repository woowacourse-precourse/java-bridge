package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBridgeSize() {
        System.out.println(AnnounceMessage.SIZE_INPUT.getMessage());
        return scan();
    }

    public String readMoving() {
        System.out.println(AnnounceMessage.MOVE_INPUT.getMessage());
        return scan();
    }

    public String readGameCommand() {
        System.out.println(AnnounceMessage.RE_OR_QUIT_INPUT.getMessage());
        return scan();
    }

    private String scan() {
        return Console.readLine();
    }
}
