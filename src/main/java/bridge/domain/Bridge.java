package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<UpDownFlag> bridge;

    private Bridge(List<UpDownFlag> bridge) {
        this.bridge = bridge;
    }

    public static Bridge of(List<String> bridge) {
        List<UpDownFlag> collect = bridge.stream()
                .map(UpDownFlag::ofString)
                .collect(Collectors.toList());
        return new Bridge(collect);
    }

    public UpDownFlag getIndexOf(int index) {
        if (index < 0 || index >= bridge.size()) {
            throw new IllegalArgumentException("[ERROR] 인덱스가 다리의 길이를 벗어났습니다.");
        }
        return bridge.get(index);
    }

    public boolean isCrossOver(User user) {
        return bridge.size() <= user.getMovedLength();
    }

    public List<UpDownFlag> getBridge() {
        return List.copyOf(bridge);
    }
}
