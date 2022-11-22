package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final Bridge generateBridge;
	private int numberOfAttempts = 1;
	private final ViewController viewController;
	private boolean exitByQuit = true;

	public BridgeGame(Bridge generateBridge) {
		this.generateBridge = generateBridge;
		this.viewController = new ViewController();
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move() {
		for (int i = 0; i < generateBridge.getBridge().size(); i++) {
			String block = viewController.getInputView().readMoving();
			checkCorrectBridgeAndBlock(block,i);
			String restartOrQuit = checkIncorrectBridgeAndBlock(block,i);
			if (restartOrQuit.equals("Q")) {
				exitByQuit = quit(i,block);
				break;
			}
			if (restartOrQuit.equals("R")) {
				retry();
				return;
			}
		}
		if (exitByQuit) printCorrectBridgeGame(generateBridge);
	}

	private void checkCorrectBridgeAndBlock(String block , int i){
		if (block.equals(generateBridge.getBridge().get(i))){
			viewController.getOutputView().printMap(generateBridge,i,block,true);
		}
	}
	private String checkIncorrectBridgeAndBlock(String block, int i){
		if (!block.equals(generateBridge.getBridge().get(i))){
			viewController.getOutputView().printMap(generateBridge,i,block,false);
		}
		return viewController.getInputView().readGameCommand();
	}

	private boolean quit(int i , String block){
		viewController.getOutputView().printResult(generateBridge, i, block, false, numberOfAttempts);
		return false;
	}

	private void printCorrectBridgeGame(Bridge generateBridge) {
		int last_index = generateBridge.getBridge().size()-1;
		String last_block = generateBridge.getBridge().get(last_index);
		viewController.getOutputView().printResult(generateBridge,last_index,last_block,true,numberOfAttempts);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		numberOfAttempts += 1;
		move();
	}
}
