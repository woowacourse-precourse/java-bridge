package bridge.domain;

import bridge.exception.domain.CompareBridgeSizeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void connect(BridgeShape bridgeShape) {
        this.bridgeShapes.add(bridgeShape);
    }

    public BridgeGameResult compare(Bridge compareBridge) {
        validateCompareBridgeSize(compareBridge);

        List<Boolean> booleans = IntStream.range(0, compareBridge.bridgeShapes.size())
                .mapToObj(index -> compareBridge.bridgeShapes.get(index) == this.bridgeShapes.get(index))
                .collect(Collectors.toList());
        return new BridgeGameResult(this, booleans);
    }

    private void validateCompareBridgeSize(Bridge compareBridge) {
        if (compareBridge.bridgeShapes.size() > this.bridgeShapes.size()) {
            throw new CompareBridgeSizeException();
        }
    }

    public boolean isCanMove(Bridge compareBridge) {
        return this.bridgeShapes.size() > compareBridge.bridgeShapes.size();
    }

    public boolean sizeEqual(Bridge compareBridge) {
        return this.bridgeShapes.size() == compareBridge.bridgeShapes.size();
    }

    public boolean sizeEqual(int size) {
        return this.bridgeShapes.size() == size;
    }

    public List<BridgeShape> bridgeShapes() {
        return Collections.unmodifiableList(this.bridgeShapes);
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
        return Objects.equals(this.bridgeShapes, bridge.bridgeShapes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bridgeShapes);
    }
}
