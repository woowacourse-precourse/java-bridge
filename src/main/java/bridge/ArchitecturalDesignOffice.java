package bridge;

import java.util.List;

public final class ArchitecturalDesignOffice {

    private final List<String> storedBridgeBlueprint;

    public ArchitecturalDesignOffice(List<String> bridgeBlueprint) {
        this.storedBridgeBlueprint = bridgeBlueprint;
    }

    public List<String> sendStoredBridgeBlueprint() {
        return this.storedBridgeBlueprint;
    }

}
