package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private List<FootrestLocation> structure;

    public Bridge(List<String> structure) {
        this.structure = structure.stream().map(each ->
                        FootrestLocation.valueOfUsingUserInput(each))
                .collect(Collectors.toList());
        System.out.println(this.structure);
    }

    public boolean canMove(Integer order, FootrestLocation footrestLocation) {
        return structure.get(order) == footrestLocation;
    }

    public boolean isLast(Integer order) {
        return structure.size() == order;
    }
}
