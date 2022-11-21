package bridge.service.dto;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class MoveDto {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;

    public MoveDto(InputView inputView, OutputView outputView, Bridge bridge) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridge = bridge;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public Bridge getBridge() {
        return bridge;
    }
}
