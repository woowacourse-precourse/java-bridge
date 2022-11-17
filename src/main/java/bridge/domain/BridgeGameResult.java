package bridge.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BridgeGameResult {

    private final Map<Round, MoveResult> result = new HashMap<>();

    public BridgeGameResult() {
    }

    public void addResult(Round round, MoveResult moveResult) {
        this.result.put(round, moveResult);
    }

    public void reset() {
        result.clear();
    }

    public List<MoveResult> getResult() {
        return Round.naturalOrder().stream()
                .map(result::get)
                .filter(Objects::nonNull)
                .collect(toList());
    }
}
