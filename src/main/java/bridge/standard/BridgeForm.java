package bridge.standard;

import java.util.Arrays;

public enum BridgeForm {

    UP_STAIR(Rule.UP_CODE, Rule.UP_LAYER),
    DOWN_STAIR(Rule.DOWN_CODE, Rule.DOWN_LAYER),
    NONE("", -1);

    private final String code;
    private final int layer;

    BridgeForm(String code, int layer) {
        this.code = code;
        this.layer = layer;
    }

    public static String transferByLayer(int layer) {
        BridgeForm bridgeform = Arrays.stream(BridgeForm.values())
                .filter(bridgeForm -> bridgeForm.layer == layer)
                .findAny()
                .orElse(NONE);

        return bridgeform.getCode();
    }

    public static int transferByCode(String code) {
        BridgeForm bridgeform = Arrays.stream(BridgeForm.values())
                .filter(bridgeForm -> bridgeForm.code.equals(code))
                .findAny()
                .orElse(NONE);

        return bridgeform.getLayer();
    }

    private String getCode() {
        return this.code;
    }

    private int getLayer() {
        return this.layer;
    }
}
