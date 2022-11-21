package bridge.model;

import java.util.List;

public class UpSideMap extends SideMap {

    public UpSideMap(List<MovingResult> history) {
        for (MovingResult movingResult : history) {
            sideMap.add(convert(movingResult));
        }
    }

    private String convert(MovingResult movingResult) {
        if (movingResult.isUpSide()) {
            if (movingResult.isSuccess()) {
                return SUCCESS;
            }
            return FAIL;
        }
        return BLANK;
    }
}
