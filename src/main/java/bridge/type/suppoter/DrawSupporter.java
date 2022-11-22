package bridge.type.suppoter;

import bridge.domain.Draw;
import bridge.type.PositionType;

public interface DrawSupporter {

    void draw(PositionType position, boolean isPass, Draw draw);
}
