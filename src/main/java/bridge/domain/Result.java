package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private final List<Status> crossResult = new ArrayList<>();

    public Result() {
    }

    public void addResult(Status status) {
        crossResult.add(status);
    }

    @Override
    public String toString() {
        return crossResult.stream()
                .map(Status::getStatus)
                .collect(Collectors.joining(" | "));
    }
}
