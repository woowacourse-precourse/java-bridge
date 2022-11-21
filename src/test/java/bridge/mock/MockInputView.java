package bridge.mock;

import bridge.mock.exception.MockInputNotFoundException;
import bridge.view.inputview.InputView;

import java.util.Iterator;
import java.util.List;

public class MockInputView extends InputView {
    private final Iterator<String> mockInputs;

    public MockInputView(List<String> mockInputs) {
        this.mockInputs = mockInputs.iterator();
    }

    @Override
    protected String readInput() {
        if (this.mockInputs.hasNext()) {
            return mockInputs.next();
        }
        throw new MockInputNotFoundException();
    }
}
