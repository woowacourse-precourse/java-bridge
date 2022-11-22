package bridge.controller.request;

import bridge.domain.bridge.Bridge;
import bridge.handler.InputHandler;
import bridge.service.dto.MoveDto;
import bridge.view.OutputView;

public class MoveByBlockRequest {

    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final Bridge bridge;

    public MoveByBlockRequest(InputHandler inputHandler, OutputView outputView, Bridge bridge) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
        this.bridge = bridge;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public MoveDto toServiceDto() {
        return new MoveDto(inputHandler, outputView, bridge);
    }
}
