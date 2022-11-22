package bridge.dto;

import java.util.List;

public class PrintResultDto {
    private final List<String> sequence;
    private final boolean isSuccess;
    private final int attemptCount;
    private final int index;

    public PrintResultDto(List<String> sequence, boolean isSuccess, int attemptCount, int index) {
        this.sequence = sequence;
        this.isSuccess = isSuccess;
        this.attemptCount = attemptCount;
        this.index = index;
    }

    public List<String> getSequence() {
        return sequence;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public int getIndex() {
        return index;
    }
}
