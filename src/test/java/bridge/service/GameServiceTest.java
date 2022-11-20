package bridge.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.repository.UserBridgeRepository;

class GameServiceTest {

	private BridgeNumberGenerator bridgeNumberGenerator;
	private BridgeMaker bridgeMaker;
	private Bridge bridge;
	private UserBridgeRepository userBridgeRepository;
	private GameService gameService;

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
		List<String> bridgeOption = List.of("U", "D");

		//when
		List<String> result = gameService.makeBridge(bridgeSize);

		//then
		result.stream().forEach(i -> Assertions.assertThat(i).containsAnyOf("U", "D"));
	}

	@DisplayName("checkValidSpace 테스트 - 유저가 건널수 있는 다리인지 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"U, 0, true", "D, 1, true", "U, 2, true", "D, 3, false"})
	void checkValidSpace(String userSpace, Integer currentSpace, boolean isValid) {
		//given
		List<String> bridgeTest = List.of("U", "D", "U", "U");

		//when
		bridge.initBridge(bridgeTest);
		boolean checkValidSpace = gameService.checkValidSpace(userSpace, currentSpace);

		//then
		Assertions.assertThat(checkValidSpace).isEqualTo(isValid);
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
	void getUserBridgeStatusDtoInLowerBridge() {
		//given
		String userLocation = "D";

		//when
		String userBridgeStatus = gameService.saveUserWrongSpace(userLocation);

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[   ]" + "\n" + "[ X ]");
	}

	@DisplayName("userBridgeRepository 안에 데이터가 있는 상태에서 gameService.clearUserBridge() 할시 데이터가 남아 있는 확인 테스트")
	@Test
	void clearUserBridge() {
		//given
		userBridgeRepository.saveUserSpace("U", "X");
		userBridgeRepository.saveUserSpace("D", "X");

		//when
		gameService.clearUserBridge();
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[  ]" + "\n" + "[  ]");
	}
}
