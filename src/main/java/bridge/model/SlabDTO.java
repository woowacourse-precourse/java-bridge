package bridge.model;

import bridge.type.GlassType;
import bridge.type.PositionType;

public class SlabDTO {
    private final int step;
    private final PositionType position;
    private final GlassType glass;
    private boolean tread;

    public SlabDTO(int step, PositionType position, GlassType glass) {
        this.step = step;
        this.position = position;
        this.glass = glass;
        this.tread = false;
    }

    public int getStep() {
        return this.step;
    }

    public PositionType getPosition() {
        return this.position;
    }

    public GlassType getGlass() {
        return this.glass;
    }

    public boolean isTread() {
        return this.tread;
    }

    public void setTread(boolean value) {
        this.tread = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        SlabDTO dto = (SlabDTO) object;

        return step == dto.step
                && position == dto.position
                && glass == dto.glass;
    }

    @Override
    public int hashCode() {
        int result = step;
        result = 31 * result + position.hashCode();
        result = 31 * result + glass.hashCode();
        return result;
    }
}
