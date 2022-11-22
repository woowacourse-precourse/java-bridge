package bridge.domain;

import bridge.constant.Constant;

public enum BridgeConverter {
    CONVERT_UP(1, Constant.UP),
    CONVERT_DOWN(0,Constant.DOWN);

    private final int generatedValue;
    private final String convertedValue;

    BridgeConverter(int generatedValue, String convertedValue) {
        this.generatedValue = generatedValue;
        this.convertedValue = convertedValue;
    }

    public static String convert(int generatedValue) {
        for (BridgeConverter bridgeConverter : BridgeConverter.values()) {
            if (bridgeConverter.generatedValue == generatedValue) {
                return bridgeConverter.convertedValue;
            }
        }
        return convert(generatedValue);
    }
}
