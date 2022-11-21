package bridge.vo;

import bridge.vo.enums.Step;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Bridge {
    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;

    private final List<Step> steps;

    public Bridge(List<Step> steps) {
        this.steps = Collections.unmodifiableList(steps);
    }

    public Iterator<Step> toIterator() {
        return steps.iterator();
    }

    public List<Step> getSteps() {
        return steps;
    }

    public int size() {
        return steps.size();
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) return true;
        if (!(target instanceof Bridge)) return false;
        Bridge anotherBridge = (Bridge) target;
        return steps.equals(anotherBridge.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }
}
