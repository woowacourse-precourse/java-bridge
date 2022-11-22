package bridge;

import static bridge.Moving.getMarkByMoving;
import static bridge.constant.mark.OutputMark.BEGIN_OF_BRIDGE;
import static bridge.constant.mark.OutputMark.DIVISION;
import static bridge.constant.mark.OutputMark.END_OF_BRIDGE;

import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private final List<String> upSide = new ArrayList<>();
    private final List<String> downSide = new ArrayList<>();
    private final OutputView outputView = new OutputView();

    public void update(Moving moving, Cross cross) {
        String up = getMarkByMoving(Moving.UP, moving, cross.getMark());
        upSide.add(up);

        String down = getMarkByMoving(Moving.DOWN, moving, cross.getMark());
        downSide.add(down);
    }

    public void print() {

    }

    public String format(List<String> row) {
        return BEGIN_OF_BRIDGE.getMark()
                + String.join(DIVISION.getMark(), row)
                + END_OF_BRIDGE.getMark();
    }
}
