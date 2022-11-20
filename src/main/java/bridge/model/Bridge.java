package bridge.model;

import java.util.List;

public class Bridge {

    private final List<String> bridgeShape;

    public Bridge(List<String> bridgeShape) {
        this.bridgeShape = bridgeShape;
    }

    public String getShape(int position) {
        return bridgeShape.get(position);
    }
}
