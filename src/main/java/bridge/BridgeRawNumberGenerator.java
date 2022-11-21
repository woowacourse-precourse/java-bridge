package bridge;

import java.util.List;

public class BridgeRawNumberGenerator implements BridgeNumberGenerator{

    private static final int FIRST_IDX = 0;
    private final List<Integer> rawNumbers;
    private int pop_idx;

    public BridgeRawNumberGenerator(List<Integer> rawNumbers){
        this.rawNumbers = rawNumbers;
        this.pop_idx = FIRST_IDX;
    }
    @Override
    public int generate() {
        if( pop_idx == rawNumbers.size()){
            pop_idx = FIRST_IDX;
        }

        return rawNumbers.get(pop_idx++);
    }
}
