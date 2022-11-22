package bridge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import bridge.constant.GameConstant;
import bridge.domain.Bridge;
import bridge.domain.Move;
import bridge.domain.User;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private static final String BLANK_SPACE = " ";
	private static final String POSSIBLE_SPACE = "O";
	private static final String IMPOSSIBLE_SPACE = "X";

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
	public void move(Move move) {
		user.move(move);
	}

	public List<List<String>> currentMap() {
		List<Move> userMap = user.getSelections();
		return IntStream.range(0, userMap.size())
			.mapToObj(i -> addMap(userMap.get(i), i))
			.collect(Collectors.toList());
	}

	private List<String> addMap(Move move, int index) {
		List<String> space = new ArrayList<>();
		space.add(BLANK_SPACE);
		if (bridge.match(index, move)) {
			space.add(move.getMoveNumber(), POSSIBLE_SPACE);
			return space;
		}
		space.add(move.getMoveNumber(), IMPOSSIBLE_SPACE);
		return space;
	}

	public boolean end() {
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
		if (match() && matchLength()) {
			return GameConstant.CLEAR;
		}
		return GameConstant.FAIL;
	}
}
