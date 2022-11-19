package bridge.mock;

import bridge.mock.exception.MockInputNotFoundException;
import bridge.view.inputview.InputView;

import java.util.Arrays;
import java.util.Iterator;

public class MockInputView extends InputView {
    private final Iterator<String> mockInputs;

    public MockInputView(String... mockInputs) {
        this.mockInputs = Arrays.stream(mockInputs).iterator();
    }

    @Override
    protected String readInput() {
        if (this.mockInputs.hasNext()) {
            return mockInputs.next();
        }
        throw new MockInputNotFoundException();
    }
}
