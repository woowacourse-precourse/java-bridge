package bridge.domain;

public class Bridge {
    private final Blocks blocks;
    private final CrossStatuses crossStatuses;

    public Bridge(final Blocks blocks, CrossStatuses crossStatuses) {
        this.blocks = blocks;
        this.crossStatuses = crossStatuses;
    }
}
