package bridge.model;

import bridge.util.Constant;

import java.util.Arrays;

public enum DownBridgeRendering {
    U_SUCCESS(Constant.BLANK, "U", true),
    U_FAIL(Constant.BLANK, "U", false),
    D_SUCCESS(Constant.SUCCESS, "D", true),
    D_FAIL(Constant.FAIL, "D", false);

    private final String bridgeRendering;
    private final String bridgeShape;
    private final boolean success;

    DownBridgeRendering(String bridgeRendering, String bridgeShape, boolean success) {
        this.bridgeRendering = bridgeRendering;
        this.bridgeShape = bridgeShape;
        this.success = success;
    }

    public static String renderDownBridge(String bridgeShape, boolean success) {
        return Arrays.stream(DownBridgeRendering.values())
                .filter(downBridge -> downBridge.bridgeShape.equals(bridgeShape) && downBridge.success == success)
                .findAny()
                .orElseThrow().bridgeRendering;
    }
}
