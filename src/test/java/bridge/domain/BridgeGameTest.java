package bridge.domain;

import static bridge.domain.ResultMessageStatus.*;
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

	@Test
	@DisplayName("게임이 끝나는 경우는 실패 또는 다리의 끝")
	void isFinishTest() {
		boolean failFinish = bridgeGame.isFinish(ResultStatus.FAILURE, 10);
		for (int stage = 0; stage < 10; stage++) {
			bridgeGame.move("U");
		}
		boolean sizeFinish = bridgeGame.isFinish(ResultStatus.SUCCESS, 10);
		assertThat(failFinish).isTrue();
		assertThat(sizeFinish).isTrue();
	}

	@Test
	@DisplayName("결과 상태 메시지는 네 종류")
	void getResultMessageStatusesTest() {
		for (int stage = 0; stage < 10; stage++) {
			bridgeGame.move("U");
		}
		List<ResultMessageStatus> result = bridgeGame.getResultMessageStatuses();
		for (int index = 0; index < 10; index++) {
			ResultMessageStatus message = result.get(index);
			assertThat(message).isIn(UP_SUCCESS_RESULT, UP_FAILURE_RESULT, DOWN_SUCCESS_RESULT, DOWN_FAILURE_RESULT);
		}
	}
}
