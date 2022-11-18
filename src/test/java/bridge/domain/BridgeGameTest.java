package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

	private BridgeGame bridgeGame;

	@BeforeEach
	void setBridgeGame() {
		bridgeGame = new BridgeGame(10);
	}

	@Test
	@DisplayName("이동한 결과 상태는 성공 또는 실패")
	void moveTest() {
		ResultStatus upResult = bridgeGame.move("U");

		assertThat(upResult).isIn(ResultStatus.SUCCESS, ResultStatus.FAILURE);
	}

	@Test
	@DisplayName("똑같은 다리로 새롭게 재시작")
	void retryTest() {
		List<ResultStatus> results = new ArrayList<>();
		for (int stage = 0; stage < 10; stage++) {
			results.add(bridgeGame.move("U"));
		}
		bridgeGame.retry();
		for (int stage = 0; stage < 10; stage++) {
			assertThat(results.get(stage)).isEqualTo(bridgeGame.move("U"));
		}
	}
}
