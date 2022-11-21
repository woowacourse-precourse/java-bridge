package bridge;

public class Controller {
	private Service service = new Service();
	private MessageQuestionPrint messageQuestionPrint = new MessageQuestionPrint();

	public void run() {
		startMessage();
		setBridgeGame();
		play();
		printResult();
	}

	public void startMessage() {
		messageQuestionPrint.startPrint();
	}

	public void setBridgeGame() {
		service.settingGame();
	}

	public void play() {
		service.playGame();
	}

	public void printResult() {
		service.printResult();
	}

}