package bridge.domain;

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

	public int retry(Map map, PlayerBridge playerBridge, int count) {
		map.init();
		playerBridge.init();
		return count + 1;
	}
}
