package bridge.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.repository.BridgeRepository;
import bridge.repository.UserBridgeRepository;

class GameServiceTest {

	private BridgeNumberGenerator bridgeNumberGenerator;
	private BridgeMaker bridgeMaker;
	private BridgeRepository bridgeRepository;
	private UserBridgeRepository userBridgeRepository;
	private GameService gameService;

	@BeforeEach
	void setUp() {
		bridgeNumberGenerator = new BridgeRandomNumberGenerator();
		bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		bridgeRepository = new BridgeRepository();
		userBridgeRepository = new UserBridgeRepository();
		gameService = new GameService(bridgeMaker, bridgeRepository, userBridgeRepository);
	}

	@DisplayName("bridge 생성 테스트")
	@Test
	void makeBridge() {
		//given
		Integer bridgeSize = 4;

		//when
		List<String> result = gameService.makeBridge(bridgeSize);

		//then
		Assertions.assertThat(result).containsOnly("U", "D");
	}

	@DisplayName("checkValidSpace 테스트 - 유저가 건널수 있는 다리인지 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"U, 0, true", "D, 1, true", "U, 2, true", "D, 3, false"})
	void checkValidSpace(String userSpace, Integer currentSpace, boolean isValid) {
		//given
		List<String> bridge = List.of("U", "D", "U", "U");

		//when
		bridgeRepository.initBridge(bridge);
		boolean checkValidSpace = gameService.checkValidSpace(userSpace, currentSpace);

		//then
		Assertions.assertThat(checkValidSpace).isEqualTo(isValid);
	}

	@Test
	void saveUserCorrectSpace() {
		//given

		//when

		//then
	}

	@Test
	void saveUserWrongSpace() {
		//given

		//when

		//then
	}

	@Test
	void getUserBridgeStatusDto() {
		//given

		//when

		//then
	}

	@Test
	void clearUserBridge() {
		//given

		//when

		//then
	}
}
