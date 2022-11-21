package bridge.domain.oxbridgebuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UDBridge {

    List<String> udBridge;

    private UDBridge(List<String> UDBridge) {
        this.udBridge = UDBridge;
    }

    public static UDBridge of() {
        return new UDBridge(new ArrayList<>());
    }

    public void add(String OX) {
        udBridge.add(OX);
    }

    public int size() {
        return udBridge.size();
    }

    @Override
    public String toString() {
        return udBridge.stream()
                .collect(Collectors.joining(BridgeDesign.BRIDGE_BLOCK.getDesign()
                        , BridgeDesign.BRIDGE_START.getDesign()
                        , BridgeDesign.BRIDGE_END.getDesign()));
    }
}
