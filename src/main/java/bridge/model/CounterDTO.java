package bridge.model;

import bridge.type.GlassType;
import bridge.type.PositionType;

public class CounterDTO {
    private final String name;
    private int value;

    public CounterDTO(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void addValue(int value) {
        this.setValue(this.getValue() + value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        CounterDTO that = (CounterDTO) object;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
