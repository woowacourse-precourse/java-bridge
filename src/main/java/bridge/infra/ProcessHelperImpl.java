package bridge.infra;

import bridge.domain.ProcessHelper;

public class ProcessHelperImpl implements ProcessHelper {


    @Override
    public boolean canItChangeBridgeSize(String bridgeLength) {
        char[] chars = bridgeLength.toCharArray();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkCharIsUOrD(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkCharIsROrQ(String gameCommand) {
        if (!(gameCommand.equals("R") || gameCommand.equals("Q"))) {
            return false;
        }
        return true;
    }
}
