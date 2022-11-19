package bridge;

import java.util.List;

public class BridgeNumberGeneratorMock implements BridgeNumberGenerator{

    private final List<Integer> a;
    private int i = 0;

    public BridgeNumberGeneratorMock(List<Integer> a) {
        this.a = a;
    }

    @Override
    public int generate() {
        return a.get(i++);
    }
}
