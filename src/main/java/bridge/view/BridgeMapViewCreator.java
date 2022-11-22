package bridge.view;

public class BridgeMapViewCreator {
    public static class BridgeMap{
        private final StringBuilder upBridge;
        private final StringBuilder downBridge;

        public BridgeMap(StringBuilder upBridge, StringBuilder downBridge) {
            this.upBridge = upBridge;
            this.downBridge = downBridge;
        }

        public StringBuilder getUpBridge() {
            return upBridge;
        }

        public StringBuilder getDownBridge() {
            return downBridge;
        }
    }

    private BridgeMapViewCreator() {
    }

    private
}
