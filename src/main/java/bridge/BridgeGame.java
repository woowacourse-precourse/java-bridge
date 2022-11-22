package bridge;

import camp.nextstep.edu.missionutils.Console;

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
			if (block.equals(generateBridge.getBridge().get(i))){
				//성공한 다리 출력 로직
				viewController.getOutputView().printMap(generateBridge,i,block,true);
				continue;
			}
			//실패한 다리여도, 일단 출력.
			viewController.getOutputView().printMap(generateBridge,i,block,false);
			//게임을 다시 시도할지 여부를 입력해주세요
			String restartOrQuit = viewController.getInputView().readGameCommand();
			//Q면, outputView.printResult()하고 끝낸다.
			if (restartOrQuit.equals("Q")){
				viewController.getOutputView().printResult(generateBridge,i,block,false,numberOfAttempts);
				exitByQuit = false;
				break;
			}
			//R이면 재시작. -> retry 호출한다.
			if (restartOrQuit.equals("R")) {
				retry();
				return;
			}
			// String successOrFail = checkBridgeBlockEqual(i);
			// if (successOrFail.equals("Q")){
			// 	exitByQuit = quit(i,block);
			// 	break;
			// }
			// if (successOrFail.equals("R")){
			// 	retry();
			// 	return;
			// }
		}
		if (exitByQuit) printCorrectBridgeGame(generateBridge);
	}

	private String checkBridgeBlockEqual(int i){
		String block = viewController.getInputView().readMoving();
		if (block.equals(generateBridge.getBridge().get(i))){
			viewController.getOutputView().printMap(generateBridge,i,block,true);
		}
		if (!block.equals(generateBridge.getBridge().get(i))){
			return checkRestartOrQuit();
		}
		return "";
	}

	private String checkRestartOrQuit(){
		return viewController.getInputView().readGameCommand();
	}

	private boolean quit(int i , String block){
		viewController.getOutputView().printResult(generateBridge, i, block, false, numberOfAttempts);
		return false;
	}

	private void printCorrectBridgeGame(Bridge generateBridge) {
		int last_index = generateBridge.getBridge().size()-1;
		String last_block = generateBridge.getBridge().get(last_index);
		viewController.getOutputView().printResult(generateBridge,last_index,last_block,false,numberOfAttempts);
	}

	private String inputRestartOrQuit(int i , String block){
		viewController.getOutputView().printMap(generateBridge, i, block, false);
		return viewController.getInputView().readGameCommand();
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
