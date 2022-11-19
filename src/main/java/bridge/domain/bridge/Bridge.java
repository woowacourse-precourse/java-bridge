package bridge.domain.bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<String> upside;
    List<String> downside;

    public Bridge(List<String> bridge) {
        upside = new ArrayList<>();
        downside = new ArrayList<>();

        createBridge(bridge);
    }

    private void createBridge(List<String> bridge) {
        for (String block : bridge) {
            if (block.equals(BridgeBlock.UP.direction)) {
                upside.add(BridgeBlock.UP.direction);
                downside.add(" ");
                continue;
            }
            upside.add(" ");
            downside.add(BridgeBlock.DOWN.direction);
        }
    }

    public int getSize() {
        return upside.size();
    }

    public boolean isSameBlock(int index, String direction) {
        return upside.get(index).equals(direction);
    }

    @Override
    public String toString() {
        return String.join("", upside);
    }
}
