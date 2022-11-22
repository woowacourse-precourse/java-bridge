package bridge.domain;

import static bridge.Constant.BRIDGE_MAX_RANGE;
import static bridge.Constant.BRIDGE_MIN_RANGE;
import static bridge.Constant.MIN_INDEX;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private List<FootrestLocation> structure;

    public Bridge(List<String> structure) {
        if (structure.size() < BRIDGE_MIN_RANGE || BRIDGE_MAX_RANGE < structure.size()) {
            throw new IllegalArgumentException("3 이상, 20 이하의 크기로만 입력이 가능합니다");
        }
        this.structure = structure.stream().map(each ->
                        FootrestLocation.findByUserInput(each))
                .collect(Collectors.toList());
    }

    public boolean canMove(int order, FootrestLocation footrestLocation) {
        if (structure.size() <= order || order < MIN_INDEX) {
            throw new IllegalStateException("다리 인덱스를 벗어남");
        }
        return structure.get(order) == footrestLocation;
    }

    public boolean isLast(int order) {
        return structure.size() - 1 == order;
    }

    public Integer size() {
        return structure.size();
    }
}
