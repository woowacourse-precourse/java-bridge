package bridge.model;

import bridge.util.Constants.Constant;

import java.util.Arrays;

public enum UpsideBridgeRendering {
    U_SUCCESS(Constant.SUCCESS, Constant.UPSIDE, true),
    U_FAIL(Constant.FAIL, Constant.UPSIDE, false),
    D_SUCCESS(Constant.BLANK, Constant.DOWN, true),
    D_FAIL(Constant.BLANK, Constant.DOWN, false);

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