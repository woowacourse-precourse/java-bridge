package bridge.mock;

import bridge.BridgeNumberGenerator;

import java.util.List;

public class MockBridgeNumberGenerator implements BridgeNumberGenerator {

    private List<Integer> mockNumbers;

    public MockBridgeNumberGenerator(List<Integer> mockNumbers) {
        this.mockNumbers = mockNumbers;
    }

    @Override
    public int generate() {
        return mockNumbers.remove(0);
    }
}
