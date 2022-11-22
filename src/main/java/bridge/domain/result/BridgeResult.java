package bridge.domain.result;

import bridge.domain.command.BridgeMoveCommand;
import java.util.ArrayList;
import java.util.List;

public class BridgeResult {

	private static final String SUCCESS = " O ";
	private static final String FAIL = " X ";
	private static final String BLANK = "   ";
	private int countOfAttemps; //시도한 횟수
	private boolean isSuccess;

	private List<String> bridges;
	private List<List<String>> lists;


	public BridgeResult(List<String> bridges) {
		this.bridges = bridges;
		this.countOfAttemps = 1;
		this.isSuccess = false;
		init();
	}
	public void init() {
		int size = BridgeMoveCommand.getSize();
		lists = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			lists.add(new ArrayList<>());
		}
	}
	public List<List<String>> getLists() {
		return lists;
	}

	public void addCountOfAttemps(int moveIndex) {
		if(moveIndex == 0) {
			countOfAttemps++;
		}
	}

	public void gameSuccess() {
		isSuccess = true;
	}

	public int getCountOfAttemps() {
		return countOfAttemps;
	}

	public String isSuccess() {
		if(isSuccess){
			return "성공";
		}
		return "실패";
	}

	public void addMaps(String command, int mapIndex) {
		int index = BridgeMoveCommand.getNumber(command);
		List<String> strings = lists.get(index);
		strings.add(isEquals(mapIndex, command));
		List<String> strings1 = lists.get(Math.abs(index - 1));
		strings1.add(BLANK);
	}

	public String isEquals(int index, String command) {
		String bridge = bridges.get(index);
		if (bridge.equals(command)) {
			return SUCCESS;
		}
		return FAIL;
	}

}
