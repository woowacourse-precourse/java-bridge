package bridge.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PassingSpace {
    private static final String FORM = "[ %s ]\n";

    private final Map<Space, List<String>> passingSpace;

    public PassingSpace() {
        passingSpace = new EnumMap<>(Space.class);
        passingSpace.put(Space.U, new ArrayList<>());
        passingSpace.put(Space.D, new ArrayList<>());
    }

    public void reset() {
        for (Space space : Space.values()) {
            List<String> row = passingSpace.get(space);
            row.clear();
        }
    }

    public void add(Space space, Movable movable) {
        List<String> spaceRow = passingSpace.get(space);
        spaceRow.add(movable.getMark());

        Space crossSpace = space.cross();

        List<String> crossSpaceRow = passingSpace.get(crossSpace);
        crossSpaceRow.add(Movable.BLANK.getMark());
    }

    @Override
    public String toString() {
        StringBuilder drawingBuilder = new StringBuilder();
        for (Space space : Space.values()) {
            List<String> row = passingSpace.get(space);
            drawingBuilder.append(conformToForms(row));
        }
        return drawingBuilder.toString();
    }

    private String conformToForms(List<String> contents) {
        String form = String.join(" | ", contents);
        return String.format(FORM, form);
    }
}