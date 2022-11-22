package service;

import domain.BridgeGame;

public class Application {
	private OutputView out = new OutputView();

	public static void main(String[] args) {
		Application app = new Application();
		app.startGame();
	}

	public void startGame() {
		try {
			BridgeGame bridgeGame = new BridgeGame();
		} catch(IllegalArgumentException e) {
			out.printError(e.getMessage());
		}
	}
}
