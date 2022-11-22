package service;

import domain.MapMaker;

public class ViewController {
	private InputView in = new InputView();
	private OutputView out = new OutputView();

	public int startView() {
		out.printGameMessage("START");
		out.printGameMessage("BRIDGE_SIZE");
		int size = in.readBridgeSize();
		return size;
	}

	public String retryView() {
		out.printGameMessage("COMMAND");
		String command = in.readGameCommand();
		return command;
	}

	public void resultView(MapMaker mapMaker, String result, int gameCount) {
		out.printResult(mapMaker.toString(), result, gameCount);
		return;
	}

	public String movingView() {
		out.printGameMessage("MOVING");
		String move = in.readMoving();
		return move;
	}
}