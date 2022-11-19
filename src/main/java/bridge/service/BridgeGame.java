package bridge.service;

import static bridge.constant.Constant.*;
import static bridge.constant.NumericConstant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import bridge.domain.Bridge;
import bridge.domain.User;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final User user;
	private final Bridge bridge;

	public BridgeGame(User user, Bridge bridge) {
		this.user = user;
		this.bridge = bridge;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(String input) {
		user.move(input);
	}

	public List<List<String>> currentMap() {
		List<String> userMap = user.getSelections();
		return IntStream.range(0, userMap.size())
			.mapToObj(i -> putOneSpace(userMap, i))
			.collect(Collectors.toList());
	}

	private List<String> putOneSpace(List<String> userMap, int index) {
		List<String> space = new ArrayList<>();
		space.add(BLANK_SPACE.getConstant());
		if (bridge.match(index, userMap.get(index))) {
			space.add(positionNumber(userMap.get(index)), POSSIBLE_SPACE.getConstant());
			return space;
		}
		space.add(positionNumber(userMap.get(index)), IMPOSSIBLE_SPACE.getConstant());
		return space;
	}

	private int positionNumber(String position) {
		if (position.equals(UP_BRIDGE_COMMAND.getConstant())) {
			return UP_BRIDGE_NUMBER.getConstValue();
		}
		return DOWN_BRIDGE_NUMBER.getConstValue();
	}

	public boolean isEnd() {
		return match() && !matchLength();
	}

	private boolean match() {
		return bridge.match(user.getCurrentSelectionIndex(), user.getCurrentSelection());
	}

	private boolean matchLength() {
		return bridge.length() == user.getSelectionCount();
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		user.retry();
	}

	public int trialCount() {
		return user.getTrialCount();
	}

	public String result() {
		if (match() || matchLength()) {
			return CLEAR.getConstant();
		}
		return FAIL.getConstant();
	}
}
