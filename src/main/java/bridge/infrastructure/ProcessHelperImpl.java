package bridge.infrastructure;

import bridge.domain.ProcessHelper;

public class ProcessHelperImpl implements ProcessHelper {


    @Override
    public boolean checkBridgeSize(String bridgeLength) {
        boolean flag = true;
        char[] chars = bridgeLength.toCharArray();
        flag = isChars(flag, chars);
        if (flag == true) {
            return true;
        }
        return false;
    }

    private boolean isChars(boolean flag, char[] chars) {
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean checkCharIsUOrD(String moving) {
        if (moving.equals("U") || moving.equals("D")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkCharIsROrQ(String gameCommand) {
        if (gameCommand.equals("R") || gameCommand.equals("Q")) {
            return true;
        }
        return false;
    }
}
