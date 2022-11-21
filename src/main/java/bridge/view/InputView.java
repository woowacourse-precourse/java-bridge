package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBridgeSize() {
        AnnounceInputMessage(AnnounceMessage.SIZE_INPUT.getMessage());
        return scan();
    }

    public String readMoving() {
        AnnounceInputMessage(AnnounceMessage.MOVE_INPUT.getMessage());
        return scan();
    }

    public String readGameCommand() {
        AnnounceInputMessage(AnnounceMessage.RE_OR_QUIT_INPUT.getMessage());
        return scan();
    }

    private String scan() {
        return Console.readLine();
    }

    private void AnnounceInputMessage(String announcement) {
        System.out.println(announcement);
    }
}
