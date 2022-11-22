package bridge;

import static bridge.message.MessageConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.BridgeGame;

class BridgeGameTest {

	private final BridgeGame bridgeGame = new BridgeGame(10);

	@Test
	@DisplayName("이동 후 다리 상태 반환")
	void moveTest() {
		for (int gameStage = 0; gameStage < 10; gameStage++) {
			String bridgeStatus = bridgeGame.move();
			Assertions.assertThat(bridgeStatus).isIn(UP_COMMAND_MESSAGE, DOWN_COMMAND_MESSAGE);
		}
	}

	@Test
	@DisplayName("재시작 후 다리 상태 동일")
	void retryTest() {
		List<String> bridge = new ArrayList<>();
		for (int gameStage = 0; gameStage < 10; gameStage++) {
			bridge.add(bridgeGame.move());
		}
		bridgeGame.retry();
		for (String bridgeStatus : bridge) {
			Assertions.assertThat(bridgeGame.move()).isEqualTo(bridgeStatus);
		}
	}

	@Test
	@DisplayName("게임 단계와 다리 길이가 같으면 게임종료")
	void isFinishGameStageTest() {
		int bridgeSize = 0;
		while (!bridgeGame.isFinishGameStage(10)) {
			bridgeGame.move();
			bridgeSize += 1;
		}
		Assertions.assertThat(bridgeSize).isEqualTo(10);
	}
}
