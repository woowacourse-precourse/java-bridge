package bridge;

public class OutputController {
	OutputView output = new OutputView();

	public void printMap(int round, Bridge bridge, String movement) {
		output.printMap(round, bridge, movement);
	}

	public void printResult(boolean status, int gameTry) {
		output.printResult(status, gameTry);
	}

	public void printStart() {
		output.printStart();
	}
}
