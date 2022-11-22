package bridge.util;

import static bridge.enums.BridgeType.DOWN;
import static bridge.enums.BridgeType.UP;
import static bridge.enums.GameMapStatus.BOUNDARY_LINE;
import static bridge.enums.GameMapStatus.END_MAP;
import static bridge.enums.GameMapStatus.FAIL;
import static bridge.enums.GameMapStatus.NEXT_LINE;
import static bridge.enums.GameMapStatus.PASS;
import static bridge.enums.GameMapStatus.SPACE;
import static bridge.enums.GameMapStatus.START_MAP;

public class BridgeMapUpdater {
    private StringBuilder upState = new StringBuilder();
    private StringBuilder downState = new StringBuilder();

    public void setMap(int location, boolean pass, String moveUpOrDown) {
        setBoundaryLine(location);
        checkUpOrDown(moveUpOrDown, pass);
    }

    public String getUpdatedBridgeMap() {
        String up = START_MAP.getSymbol() + upState.toString() + END_MAP.getSymbol();
        String down = START_MAP.getSymbol() + downState.toString() + END_MAP.getSymbol();
        return up + NEXT_LINE.getSymbol() + down;
    }

    private void setBoundaryLine(int location) {
        if (location >= 1) {
            upState.append(BOUNDARY_LINE.getSymbol());
            downState.append(BOUNDARY_LINE.getSymbol());
        }
    }

    private void checkUpOrDown(String UpAndDown, boolean pass) {
        if (UpAndDown.equals(UP.getCommand())) {
            setUpState(pass);
        }
        if (UpAndDown.equals(DOWN.getCommand())) {
            setDownState(pass);
        }
    }

    private void setUpState(boolean pass) {
        if (pass) {
            upState.append(PASS.getSymbol());
        }
        if (!pass) {
            upState.append(FAIL.getSymbol());
        }
        downState.append(SPACE.getSymbol());
    }

    private void setDownState(boolean pass) {
        if (pass) {
            downState.append(PASS.getSymbol());
        }
        if (!pass) {
            downState.append(FAIL.getSymbol());
        }
        upState.append(SPACE.getSymbol());
    }

    public void clearMap() {
        upState.setLength(0);
        downState.setLength(0);
    }
}
