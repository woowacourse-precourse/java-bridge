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

class GameServiceTest {

	private BridgeNumberGenerator bridgeNumberGenerator;
	private GameService gameService;
	private BridgeMaker bridgeMaker;
	private Bridge bridge;
	private UserBridgeRepository userBridgeRepository;

	@BeforeEach
	void setUp() {
		bridgeNumberGenerator = new BridgeRandomNumberGenerator();
		bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		bridge = new Bridge();
		userBridgeRepository = new UserBridgeRepository();
		gameService = new GameService(bridgeMaker, bridge, userBridgeRepository);
	}

	@AfterEach
	void tearDown() {
		userBridgeRepository.clear();
	}

	@DisplayName("bridge 생성 테스트 - 생성된 다리 순회하면서 U 또는 D 값만 가지고 있는지 테스트")
	@Test
	void makeBridge() {
		//given
		Integer bridgeSize = 4;

		//when
		List<String> result = gameService.makeBridge(bridgeSize);

		//then
		result.stream().forEach(i -> Assertions.assertThat(i).containsAnyOf("U", "D"));
	}

	@DisplayName("saveUserCorrectSpace 에서 upperBridge 에 O 저장 확인 테스트")
	@Test
	void saveUserCorrectSpaceInUpperBridge() {
		//given
		String userLocation = "U";

		//when
		String userBridgeStatus = gameService.saveUserCorrectSpace(userLocation);

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[ O ]" + "\n" + "[   ]");
	}

	@DisplayName("saveUserCorrectSpace 에서 lowerBridge 에 O 저장 확인 테스트")
	@Test
	void saveUserCorrectSpaceInLowerBridge() {
		//given
		String userLocation = "D";

		//when
		String userBridgeStatus = gameService.saveUserCorrectSpace(userLocation);

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[   ]" + "\n" + "[ O ]");
	}

	@DisplayName("saveUserWrongSpace 에서 upperBridge 에 X 저장 확인 테스트")
	@Test
	void saveUserWrongSpaceInUpperBridge() {
		//given
		String userLocation = "U";

		//when
		String userBridgeStatus = gameService.saveUserWrongSpace(userLocation);

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[ X ]" + "\n" + "[   ]");
	}

	@DisplayName("saveUserWrongSpace 에서 lowerBridge 에 X 저장 확인 테스트")
	@Test
	void saveUserWrongSpaceInLowerBridge() {
		//given
		String userLocation = "D";

		//when
		String userBridgeStatus = gameService.saveUserWrongSpace(userLocation);

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[   ]" + "\n" + "[ X ]");
	}

	@Test
	void getUserBridgeStatus() {
	}
}
