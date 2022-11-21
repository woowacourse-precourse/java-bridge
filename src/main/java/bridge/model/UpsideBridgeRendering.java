package bridge.model;

import bridge.util.Constant;

import java.util.Arrays;
import java.util.List;

public enum UpsideBridgeRendering {
    U_SUCCESS(Constant.SUCCESS, "U", true),
    U_FAIL(Constant.FAIL, "U", false),
    D_SUCCESS(Constant.BLANK, "D", true),
    D_FAIL(Constant.BLANK, "D", false);

    private final String bridgeRendering;
    private final String bridgeShape;
    private final boolean success;

    UpsideBridgeRendering(String bridgeRendering, String bridgeShape, boolean success) {
        this.bridgeRendering = bridgeRendering;
        this.bridgeShape = bridgeShape;
        this.success = success;
    }

    public static String renderUpsideBridge(String bridgeShape, boolean success) {
        return Arrays.stream(UpsideBridgeRendering.values())
                .filter(upsideBridge -> upsideBridge.bridgeShape.equals(bridgeShape) && upsideBridge.success == success)
                .findAny()
                .orElseThrow().bridgeRendering;
    }
}