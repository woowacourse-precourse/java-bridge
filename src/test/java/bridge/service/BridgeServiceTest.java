package bridge.service;

import static bridge.domain.ResultMessageStatus.*;
import static bridge.domain.ResultStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.domain.ResultMessageStatus;
import bridge.domain.ResultStatus;

class BridgeServiceTest {

	private final BridgeService bridgeService = new BridgeService();

	@BeforeEach
	void setBridgeService() {
		bridgeService.createBridgeGame(10);
	}

	@Test
	@DisplayName("이동한 결과 상태는 성공 또는 실패")
	void moveServiceTest() {
		ResultStatus upResult = bridgeService.moveService("U");

		assertThat(upResult).isIn(SUCCESS, FAILURE);
	}

	@Test
	@DisplayName("똑같은 다리로 새롭게 재시작")
	void retryServiceTest() {
		List<ResultStatus> results = new ArrayList<>();
		for (int gameStage = 0; gameStage < 10; gameStage++) {
			results.add(bridgeService.moveService("U"));
		}
		bridgeService.retryService();
		for (int gameStage = 0; gameStage < 10; gameStage++) {
			assertThat(results.get(gameStage)).isEqualTo(bridgeService.moveService("U"));
		}
	}

	@Test
	@DisplayName("게임이 끝나는 경우는 실패 또는 다리의 끝")
	void isFinishTest() {
		boolean failFinish = bridgeService.isFinish(FAILURE, 10);
		for (int gameStage = 0; gameStage < 10; gameStage++) {
			bridgeService.moveService("U");
		}
		boolean sizeFinish = bridgeService.isFinish(SUCCESS, 10);
		assertThat(failFinish).isTrue();
		assertThat(sizeFinish).isTrue();
	}

	@Test
	@DisplayName("결과 상태 메시지는 네 종류")
	void getResultMessageStatusesTest() {
		for (int stage = 0; stage < 10; stage++) {
			bridgeService.moveService("U");
		}
		List<ResultMessageStatus> result = bridgeService.getResultMessageStatuses();
		for (int index = 0; index < 10; index++) {
			ResultMessageStatus message = result.get(index);
			assertThat(message).isIn(UP_SUCCESS_RESULT, UP_FAILURE_RESULT, DOWN_SUCCESS_RESULT, DOWN_FAILURE_RESULT);
		}
	}

	@Test
	@DisplayName("시도 횟수는 retryService 함수 호출할 때마다 증가")
	void getTryCountTest() {
		for (int tryCount = 1; tryCount <= 50; tryCount++) {
			int count = bridgeService.getTryCount();
			assertThat(count).isEqualTo(tryCount);
			bridgeService.retryService();
		}
	}
}
