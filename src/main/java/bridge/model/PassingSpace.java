package bridge.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PassingSpace {
    private final Map<Space, List<String>> passedSpace;

    public PassingSpace() {
        passedSpace = new EnumMap<>(Space.class);
        init();
    }

    public void init() {
        passedSpace.clear();
        passedSpace.put(Space.U, new ArrayList<>());
        passedSpace.put(Space.D, new ArrayList<>());
    }

    public void add(Space space, Movable movable) {
        List<String> spaceRow = passedSpace.get(space);
        spaceRow.add(movable.getMark());

        Space crossSpace = space.cross();
        List<String> crossSpaceRow = passedSpace.get(crossSpace);
        crossSpaceRow.add(Movable.BLANK.getMark());
    }
}
