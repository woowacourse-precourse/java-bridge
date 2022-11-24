package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<Stage> stages;

    public Bridge(final List<String> stages) {
        this.stages = stages.stream()
            .map(Stage::new)
            .collect(Collectors.toList());
    }

    public PlayResult cross(final int round, final Direction direction) {
        return stages.get(round).choose(direction);
    }

    public int getNumberOfStage() {
        return stages.size();
    }
}
