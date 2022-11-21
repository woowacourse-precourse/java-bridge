package bridge.domain;

import java.util.List;

public final class ArchitecturalDesignOffice {

    private static final ArchitecturalDesignOffice INSTANCE = new ArchitecturalDesignOffice();
    private List<String> storedBridgeBlueprint;

    private ArchitecturalDesignOffice() {
    }

    public static ArchitecturalDesignOffice getInstance() {
        return INSTANCE;
    }

    public void save(List<String> storedBridgeBlueprint) {
        this.storedBridgeBlueprint = storedBridgeBlueprint;
    }

    public CompareResult compare(String readDirection, int bridgeLocation) {
        boolean bridgeEndPoint = isBridgeEndPoint(bridgeLocation);

        return new CompareResult(readDirection, isAppropriate(readDirection, bridgeLocation), bridgeEndPoint);
    }

    private boolean isAppropriate(String readDirection, int bridgeLocation) {
        return this.storedBridgeBlueprint.get(bridgeLocation).equals(readDirection);
    }

    private boolean isBridgeEndPoint(int bridgeLocation) {
        return this.storedBridgeBlueprint.size() - 1 == bridgeLocation;
    }

}
