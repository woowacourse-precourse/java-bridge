package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private List<FootrestLocation> structure;

    public Bridge(List<String> structure) {
        if (structure.size() < 3 || 20 < structure.size()) {
            throw new IllegalArgumentException("3 이상, 20 이하의 크기로만 입력이 가능합니다");
        }
        this.structure = structure.stream().map(each ->
                        FootrestLocation.valueOfUsingUserInput(each))
                .collect(Collectors.toList());
    }

    public boolean canMove(Integer order, FootrestLocation footrestLocation) {
        return structure.get(order) == footrestLocation;
    }

    public boolean isLast(Integer order) {
        return structure.size() == order;
    }

    public Integer size() {
        return structure.size();
    }
}
