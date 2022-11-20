package bridge.model.domain;

import bridge.enums.Bridge;
import java.util.List;
import java.util.stream.Collectors;

public class Bridges {

    private final List<Bridge> bridges;

    public Bridges(List<String> bridgesSign) {
        this.bridges = bridgesSign.stream()
                .map(Bridge::findBySign)
                .collect(Collectors.toList());
    }
}
