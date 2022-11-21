package bridge.view;

public class InputViewImpl implements InputView {

    @Override
    public int readBridgeSize() {
        return 0;
    }

    @Override
    public InGameCommandType readMoving() {
        return null;
    }

    @Override
    public FailMenuCommandType readGameCommand() {
        return null;
    }
}
