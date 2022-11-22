package service;

public class ViewController {
	private InputView in = new InputView();
	private OutputView out = new OutputView();

	public int startView() {
		out.printGameMessage("START");
		out.printGameMessage("BRIDGE_SIZE");
		int size = in.readBridgeSize();
		return size;
	}
}