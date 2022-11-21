package bridge.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.repository.UserBridgeRepository;

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

	@Test
	void move() {
	}

	@Test
	void retry() {
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
