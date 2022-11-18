package bridge.domain;

import static org.assertj.core.api.Assertions.*;

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
}
