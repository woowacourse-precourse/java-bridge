package bridge.model;

import java.util.List;

public class DownSideMap extends SideMap{

    public DownSideMap(List<MovingResult> history) {
        for (MovingResult movingResult : history) {
            sideMap.add(convert(movingResult));
        }
    }

    private String convert(MovingResult movingResult) {
        if (movingResult.isDownSide()) {
            if (movingResult.isSuccess()) {
                return SUCCESS;
            }
            return FAIL;
        }
        return BLANK;
    }
}
