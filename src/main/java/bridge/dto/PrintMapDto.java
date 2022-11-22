package bridge.dto;

import java.util.List;

public class PrintMapDto {

    private final List<String> sequence;
    private final boolean isPossible;
    private final int index;

    public PrintMapDto(List<String> sequence, boolean isPossible, int index) {
        this.sequence = sequence;
        this.isPossible = isPossible;
        this.index = index;
    }

    public List<String> getSequence() {
        return sequence;
    }

    public boolean isPossible() {
        return isPossible;
    }

    public int getIndex() {
        return index;
    }
}
