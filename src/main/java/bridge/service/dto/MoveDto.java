package bridge.service.dto;

import bridge.domain.bridge.Bridge;
import bridge.handler.InputHandler;
import bridge.view.OutputView;

public class MoveDto {
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final Bridge bridge;

    public MoveDto(InputHandler inputHandler, OutputView outputView, Bridge bridge) {
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
}
