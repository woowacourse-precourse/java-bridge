package bridge.infra;

import bridge.domain.ProcessHelper;

public class ProcessHelperImpl implements ProcessHelper {


    @Override
    public int inputArrayToBridgeSize(String bridgeLength) {
        return 0;
    }

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
}
