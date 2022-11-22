package bridge;

public class ViewController {
	private final InputView inputView;
	private final OutputView outputView;

	public ViewController(){
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public InputView getInputView(){
		return inputView;
	}

	public OutputView getOutputView(){
		return outputView;
	}
}
