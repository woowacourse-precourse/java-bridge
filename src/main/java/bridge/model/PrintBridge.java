package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class PrintBridge {

    private static final int UP_SHAPE_INDEX = 0;
    private static final int DOWN_SHAPE_INDEX = 1;

    private final List<String> shape = new ArrayList<>();

    public void generateShape(List<String> playerUpShape, List<String> playerDownShape) {
        String replacedPlayerUpShape = playerUpShape.toString().replace(",", "|");
        String replacedPlayerDownShape = playerDownShape.toString().replace(",", "|");
        shape.add(replacedPlayerUpShape);
        shape.add(replacedPlayerDownShape);
    }

    public String getUpShape() {
        return shape.get(UP_SHAPE_INDEX);
    }

    public String getDownShape() {
        return shape.get(DOWN_SHAPE_INDEX);
    }
}
