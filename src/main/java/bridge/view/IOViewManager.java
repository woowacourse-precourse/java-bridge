package bridge.view;

import bridge.dto.input.ReadBridgeSizeDto;
import bridge.dto.input.ReadGameCommandDto;
import bridge.dto.input.ReadMovingDto;
import bridge.dto.output.PrintExceptionDto;
import bridge.dto.output.PrintMapDto;
import bridge.dto.output.PrintResultDto;

public class IOViewManager {

    private final InputView inputView;
    private final OutputView outputView;

    public IOViewManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public ReadBridgeSizeDto readBridgeSize() {
        return inputView.readBridgeSize();
    }

    public ReadMovingDto readMoving() {
        return inputView.readMoving();
    }

    public ReadGameCommandDto readGameCommand() {
        return inputView.readGameCommand();
    }

    public void printMap(PrintMapDto printMapDto) {
        outputView.printMap(printMapDto);
    }

    public void printResult(PrintResultDto printResultDto) {
        outputView.printResult(printResultDto);
    }

    public void printException(PrintExceptionDto printExceptionDto) {
        outputView.printException(printExceptionDto);
    }
}
