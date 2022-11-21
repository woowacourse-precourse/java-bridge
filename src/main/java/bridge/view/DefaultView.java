package bridge.view;


public class DefaultView implements View {

    private final OutputView outputView;

    public DefaultView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void render() {
        outputWelcome();
        inputBridgeSize();
    }

    private void outputWelcome() {
        outputView.printWelcome();
        System.out.println();
    }

    private void inputBridgeSize() {
        outputView.printReadBridgeSize();
    }

}
