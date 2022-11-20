package bridge;

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
        return new CompareResult(readDirection, bridgeLocation,
                this.storedBridgeBlueprint.get(bridgeLocation).equals(readDirection));
    }

}
