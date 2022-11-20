package bridge.model;

import bridge.type.SlabType;

public class SlabDTO {
    private final int step;
    private final SlabType type;
    private final boolean safe;
    private boolean tread;

    public SlabDTO(int step, SlabType type, boolean safe) {
        this.step = step;
        this.type = type;
        this.safe = safe;
        this.tread = false;
    }

    public int getStep() {
        return this.step;
    }

    public SlabType getSlabType() {
        return this.type;
    }

    public boolean isSafe() {
        return this.safe;
    }

    public boolean isTread() {
        return this.tread;
    }

    public void setTread(boolean value) {
        this.tread = value;
    }
}
