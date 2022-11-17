package bridge;

import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<String> shapes;

    public Bridge(List<String> shapes) {
        this.shapes = shapes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bridge bridge = (Bridge) o;
        return Objects.equals(shapes, bridge.shapes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapes);
    }
}
