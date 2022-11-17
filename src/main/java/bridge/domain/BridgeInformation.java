package bridge.domain;

public enum BridgeInformation {
        UP(0, "U"), DOWN(1, "D");

        BridgeInformation(int bridgeNumber, String bridgePosition) {
            this.bridgeNumber = bridgeNumber;
            this.bridgePosition = bridgePosition;
        }

        final int bridgeNumber;
        final String bridgePosition;

}
