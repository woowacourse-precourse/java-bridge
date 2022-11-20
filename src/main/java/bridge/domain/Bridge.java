package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeShape> bridgeShapes;

    public Bridge() {
        this.bridgeShapes = new ArrayList<>();
    }

    public Bridge(List<BridgeShape> bridgeShapeValues) {
        this.bridgeShapes = new ArrayList<>(bridgeShapeValues);
    }

    public static Bridge createByBridgeShapeValue(List<String> bridgeShapeValues) {
        return new Bridge(bridgeShapeValues.stream()
                .map(BridgeShape::of)
                .collect(Collectors.toList()));
    }

    public void connect(String bridgeShapeValue) {
        bridgeShapes.add(BridgeShape.of(bridgeShapeValue));
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
        return Objects.equals(bridgeShapes, bridge.bridgeShapes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridgeShapes);
    }
}
