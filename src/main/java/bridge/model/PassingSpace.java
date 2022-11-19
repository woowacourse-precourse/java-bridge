package bridge.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PassingSpace {
    private static final String FORM = "[ %s ]";
    private final Map<Space, List<String>> passingSpace;

    public PassingSpace() {
        passingSpace = new EnumMap<>(Space.class);
        init();
    }

    public void init() {
        passingSpace.clear();
        passingSpace.put(Space.U, new ArrayList<>());
        passingSpace.put(Space.D, new ArrayList<>());
    }

    public void add(Space space, Movable movable) {
        List<String> spaceRow = passingSpace.get(space);
        spaceRow.add(movable.getMark());

        Space crossSpace = space.cross();
        List<String> crossSpaceRow = passingSpace.get(crossSpace);
        crossSpaceRow.add(Movable.BLANK.getMark());
    }

    public String draw() {
        List<String> upRow = passingSpace.get(Space.U);
        String upRowDrawing = conformToForms(upRow);

        List<String> downRow = passingSpace.get(Space.D);
        String downRowDrawing = conformToForms(upRow);
        return upRowDrawing + "\n" + downRowDrawing;
    }

    private String conformToForms(List<String> contents) {
        String form = String.join(" | ", contents);
        return String.format(FORM,form);
    }
}
