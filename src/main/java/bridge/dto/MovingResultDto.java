package bridge.dto;

import java.util.List;

public class MovingResultDto {
    private final List<String> result;
    private final int position;
    private final boolean completeness;

    public MovingResultDto(List<String> result, int position, boolean completeness) {
        this.result = result;
        this.position = position;
        this.completeness = completeness;
    }

    public List<String> getResult() {
        return result;
    }


    public boolean getCompleteness() {
        return completeness;
    }

    public int getPosition() {
        return position;
    }
}
