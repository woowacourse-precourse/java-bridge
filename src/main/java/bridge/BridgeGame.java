package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final Bridge generateBridge;
	private final int NumberOfAttempts = 1;
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();


	public BridgeGame(Bridge generateBridge) {
		this.generateBridge = generateBridge;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move() {
		System.out.println("generateBridge.getBridge() = " + generateBridge.getBridge());

		for(int i=0; i<generateBridge.getBridge().size();i++){
			String block = inputView.readMoving();
			if (block.equals(generateBridge.getBridge().get(i))){
				//성공한 다리 출력 로직
				outputView.printMap(generateBridge,i,block,true);
				continue;
			}
			//실패한 다리여도, 일단 출력.
			outputView.printMap(generateBridge,i,block,false);
			//게임을 다시 시도할지 여부를 입력해주세요
			String restartOrQuit = inputView.readGameCommand();
			//Q면, outputView.printResult()하고 끝낸다.
			if (restartOrQuit.equals("Q")){
				outputView.printResult(generateBridge,i,block,false);
				break;
			}
			//R이면 재시작. -> retry 호출한다.
			if (restartOrQuit.equals("R")){
				retry();
			}
		}

		//다 끝났어도 , printResult.
		outputView.printResult(
			generateBridge,generateBridge.getBridge().size()-1,
			generateBridge.getBridge().get(generateBridge.getBridge().size()-1), true);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		move();
	}
}
