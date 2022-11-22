package bridge;

import static bridge.Moving.getMarkByMoving;

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
}
