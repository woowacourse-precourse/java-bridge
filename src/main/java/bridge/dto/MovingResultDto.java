package bridge.dto;

import java.util.List;

public class MovingResultDto {
    private final List<String> result;
    private final boolean completeness;
    private final boolean success;

    public MovingResultDto(List<String> result, boolean completeness, boolean success) {
        this.result = result;
        this.completeness = completeness;
        this.success = success;
    }

    public List<String> getResult() {
        return result;
    }


    public boolean getCompleteness() {
        return completeness;
    }
    
    public boolean getSuccess() {
        return success;
    }
}
