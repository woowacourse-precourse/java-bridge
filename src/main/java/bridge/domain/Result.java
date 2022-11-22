package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private final List<State> crossResult = new ArrayList<>();

    public Result() {
    }

    public void addResult(State status) {
        crossResult.add(status);
    }

    @Override
    public String toString() {
        return crossResult.stream()
                .map(State::getStatus)
                .collect(Collectors.joining(" | "));
    }
}
