package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	InputView inputView = new InputView();
	OutputView outputView= new OutputView();
	List<List<String>> upDownBridgeList = new ArrayList<>();
	ArrayList<String> upBridge = new ArrayList<>();
	ArrayList<String> downBridge = new ArrayList<>();

	public BridgeGame() {
		upDownBridgeList.add(upBridge);
		upDownBridgeList.add(downBridge);
	}
	
	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	
	public boolean move(String inputMoving, List<String> madeBridge, int order) {
		boolean compareResult = compareMoving(inputMoving, madeBridge, order);
		if(compareResult) {
			addSuccessStateToBridge(inputMoving);
			outputView.printMap(upDownBridgeList);
			return true;
		}
		addFailureStateToBridge(inputMoving);
		outputView.printMap(upDownBridgeList);
		return false;
	}
	
	public boolean compareMoving(String inputMoving, List<String> madeBridge, int order) {
		if(inputMoving.equals(madeBridge.get(order))) {
			return true;
		}
		return false;
	}

	public void addSuccessStateToBridge(String inputMoving) {
		if(inputMoving.equals("U")) {
			upBridge.add("O");
			downBridge.add(" ");
			return;
		}
		downBridge.add("O");
		upBridge.add(" ");
	}
	
	public void addFailureStateToBridge(String inputMoving) {
		if(inputMoving.equals("U")) {
			upBridge.add("X");
			downBridge.add(" ");
		}
		downBridge.add("X");
		upBridge.add(" ");
	}
	
	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 * @return 
	 */
	public String retry() {
		String restartOrQuit = "";
		restartOrQuit = inputView.readGameCommand();
		return restartOrQuit;	
	}
}
