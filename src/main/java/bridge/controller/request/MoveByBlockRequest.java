package bridge.controller.request;

import bridge.domain.Bridge;
import bridge.service.dto.MoveDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class MoveByBlockRequest {

    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;

    public MoveByBlockRequest(InputView inputView, OutputView outputView, Bridge bridge) {
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

    public MoveDto toServiceDto() {
        return new MoveDto(inputView, outputView, bridge);
    }
}
