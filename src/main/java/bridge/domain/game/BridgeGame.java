package bridge.domain.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.command.BridgeMoveCommand;
import bridge.domain.command.BridgeRestartCommand;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private static final String SUCCESS = " O ";
	private static final String FAIL = " X ";
	private static final String BLANK = "   ";
	private int countOfAttemps = 1;
	private boolean isSuccessStage = true;
	private int stageLevel = 0;
	private List<String> bridges;
	private List<List<String>> resultMap;

	public BridgeGame() {
		resultMapInit();
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(String moveCommand) {
		recordTheMovement(moveCommand);
		if (isFailStage(moveCommand)) {
			isSuccessStage = false;
		}
		stageLevel++;
	}

	public boolean isFailStage(String moveCommand) {
		String bridgeColumn = bridges.get(stageLevel);
		return !bridgeColumn.equals(moveCommand);
	}


	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry(String command) {
		if (BridgeRestartCommand.isRetry(command)) {
			resultMapInit();
			addCountOfAttemps();
			isSuccessStage = true;
			stageLevel = 0;
		}
	}

	public void recordTheMovement(String moveCommand) {
		int storeIndex = BridgeMoveCommand.findStoreIndex(moveCommand);
		addToTheAppropriateRepository(resultMap.get(storeIndex), getKeyword(moveCommand));
		addAnotherRepository(resultMap.get(Math.abs(storeIndex - 1)), BLANK);
	}

	public void addToTheAppropriateRepository(List<String> store, String keyword) {
		store.add(keyword);
	}

	public void addAnotherRepository(List<String> store, String keyword) {
		store.add(keyword);
	}

	public String getKeyword(String command) {
		String bridge = bridges.get(stageLevel);
		if (bridge.equals(command)) {
			return SUCCESS;
		}
		return FAIL;
	}


	public boolean canPlay() {
		return stageLevel < bridges.size() && isSuccessStage;
	}

	public boolean isEndGame() {
		return !isSuccessStage;
	}

	public String isSuccessGame() {
		if (isSuccessStage && bridges.size() == stageLevel) {
			return "성공";
		}
		return "실패";
	}

	public void resultMapInit() {
		int size = BridgeMoveCommand.getSize();
		resultMap = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			resultMap.add(new ArrayList<>());
		}
	}

	private void addCountOfAttemps() {
		countOfAttemps++;
	}

	public void setBridges(List<String> bridges) {
		this.bridges = bridges;
	}

	public int getCountOfAttemps() {
		return countOfAttemps;
	}

	public List<List<String>> getResultMap() {
		return resultMap;
	}

	public boolean isSuccessStage() {
		return isSuccessStage;
	}
}
