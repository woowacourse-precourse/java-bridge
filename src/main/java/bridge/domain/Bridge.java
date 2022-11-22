package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<Stage> stages;

    public Bridge(final List<Stage> stages) {
        this.stages = stages;
    }

    public PlayResult choose(final int round, final String direction) {
        return stages.get(round).choose(direction);
    }

    public int getStages() {
        return stages.size();
    }
}
