package bridge;

import java.util.Arrays;
import java.util.List;

public enum BridgeType {
    U("U"), D("D");

    private String label;

    BridgeType(String bridgeType) {
        this.label = bridgeType;
    }

    static BridgeType of(String bridgeType) {
        return Arrays.stream(values())
                .filter((v) -> bridgeType.equals(v.label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당하는 bridgeType이 존재하지 않습니다."));
    }

    static List<BridgeType> toBridge(List<String> target) {
        return Arrays.asList(
                target.stream()
                        .map((str) -> of(str))
                        .toArray(BridgeType[]::new)
        );

    }

}
