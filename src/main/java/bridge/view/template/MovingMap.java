package bridge.view.template;

import bridge.view.constants.MovingKeyword;
import bridge.view.constants.MovingMapDisplay;
import bridge.view.constants.MovingMapFormat;

import java.util.StringJoiner;

/**
 * 이동 현황 정보를 출력을 위해 정해진 지도 형식으로 저장하는 템플릿 클래스
 */
public class MovingMap {

    private final StringJoiner up = new StringJoiner(MovingMapFormat.DELIMITER.getValue());
    private final StringJoiner down = new StringJoiner(MovingMapFormat.DELIMITER.getValue());

    public void addOneRound(boolean hasFailed, String moving) {
        String upDisplay = MovingMapDisplay.convert(hasFailed, MovingKeyword.UP.isSameStepMoving(moving));
        String downDisplay = MovingMapDisplay.convert(hasFailed, MovingKeyword.DOWN.isSameStepMoving(moving));
        up.add(upDisplay);
        down.add(downDisplay);
    }

    @Override
    public String toString() {
        return MovingMapFormat.PREFIX.getValue() + up + MovingMapFormat.SUFFIX.getValue() + "\n"
            + MovingMapFormat.PREFIX.getValue() + down + MovingMapFormat.SUFFIX.getValue();
    }
}
