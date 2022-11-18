package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bridges {
    private List<String> bridges;

    public void generate(List<String> bridges) {
        this.bridges = bridges;
    }

    public String getBridgeByPositionToMove(int position) {
        return bridges.get(position);
    }

    public List<String> getBridgesByPlayerPosition(int position) {
        return IntStream.range(0, position)
                .mapToObj(bridge -> bridges.get(bridge))
                .collect(Collectors.toList());
    }
}
