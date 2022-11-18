package bridge.dto;

import java.util.List;

public class MovingResultDto {
    private final List<String> result;
    private final boolean completeness;

    public MovingResultDto(List<String> result, boolean completeness) {
        this.result = result;
        this.completeness = completeness;
    }

    public List<String> getResult() {
        return result;
    }

    public boolean getCompleteness() {
        return completeness;
    }
}
