package bridge.domain.provider;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(String size) {
        int InputSize = parsing(size);
        checkRangeOfSize(InputSize);
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(InputSize);
    }

    private int parsing(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void checkRangeOfSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public String getBridge(int index) {
        return bridge.get(index);
    }

    public int getSize() {
        return bridge.size();
    }
}
