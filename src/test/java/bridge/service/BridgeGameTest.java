package bridge.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.repository.UserBridgeRepository;
import bridge.util.GameConst;

class BridgeGameTest {

	private BridgeNumberGenerator bridgeNumberGenerator;
	private BridgeGame bridgeGame;
	private BridgeMaker bridgeMaker;
	private Bridge bridge;
	private UserBridgeRepository userBridgeRepository;

	@BeforeEach
	void setUp() {
		bridgeNumberGenerator = new BridgeRandomNumberGenerator();
		bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		bridge = new Bridge();
		userBridgeRepository = new UserBridgeRepository();
		bridgeGame = new BridgeGame(bridgeMaker, bridge, userBridgeRepository);
	}

	@AfterEach
	void tearDown() {
		userBridgeRepository.clear();
	}

	@ParameterizedTest(name = "bridgeGame 의 move 메서드 - 사용자 입력을 정답값과 비교해서 확인하는 테스트")
	@CsvSource(value = {"U, 0, true", "U, 1, false"})
	void move(String userMove, Integer index, boolean valid) {
		List<String> bridgeTest = List.of(GameConst.MOVING_UP, GameConst.MOVING_DOWN);
		bridge.initBridge(bridgeTest);

		boolean move = bridgeGame.move(userMove, index);

		Assertions.assertThat(move).isEqualTo(valid);
	}

	@ParameterizedTest(name = "bridgeGame 의 retry 메서드 - 재시도 요청에서 사용자 입력값에 따라 boolean 이 잘 나오는지 확인하는 테스트")
	@CsvSource(value = {"Q, false", "R, true"})
	void retry(String userCommand, boolean retry) {
		boolean retryTest = bridgeGame.retry(userCommand);

		Assertions.assertThat(retryTest).isEqualTo(retry);
	}

	@DisplayName("bridge 생성 테스트 - 생성된 다리 순회하면서 U 또는 D 값만 가지고 있는지 테스트")
	@Test
	void makeBridge() {
		//given
		Integer bridgeSize = 4;

		//when
		List<String> result = bridgeGame.makeBridge(bridgeSize);

		//then
		result.stream().forEach(i -> Assertions.assertThat(i).containsAnyOf("U", "D"));
	}

}
