package model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<MoveMark> bridge = new ArrayList<>();

    public Bridge(List<String> bridge) {
        for (String mark : bridge) {
            this.bridge.add(new MoveMark(mark));
        }
    }

    public boolean canMove(int stage, MoveMark mark) {
        return mark.canMove(bridge.get(stage));
    }

    public boolean isLast(int stage) {
        return bridge.size() == stage;
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}
