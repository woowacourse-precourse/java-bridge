package bridge;

import org.mockito.internal.matchers.Null;

import java.util.List;

import static bridge.Constants.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * <p>
 * 인스턴스 변수 추가 ㅇ	  <p>
 * 패키지 변경 ㅇ	 <p>
 * 메서드 이름 변경 X	 <p>
 * 인자, 리턴타입 추가 변경 ㅇ	 <p>
 * 메서드 추가, 변경 ㅇ	 <p>
 * 여기서 InputView, OutputView 사용 X
 */
public class BridgeGame {

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(Map map, Bridge bridge, PlayerBridge playerBridge) {
		String answer = getAnswer(bridge, playerBridge);

		if (playerBridge.getLastValue().equals(UP)) {
			map.addUp(answer);
			map.addDown(SPACE);
		}
		if (playerBridge.getLastValue().equals(DOWN)) {
			map.addUp(SPACE);
			map.addDown(answer);
		}
	}

	private String getAnswer(Bridge bridge, PlayerBridge playerBridge) {
		int index = playerBridge.getLastIndex();

		if (playerBridge.getLastValue().equals(bridge.getValueOfIndex(index))) {
			return O;
		}
		return X;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {

	}


}
