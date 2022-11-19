package bridge.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
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
import bridge.repository.UserBridgeStatusDto;

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

	@AfterEach
	void tearDown() {
		userBridgeRepository.clear();
	}

	@DisplayName("bridge 생성 테스트")
	@Test
	void makeBridge() {
		//given
		Integer bridgeSize = 4;
		List<String> bridgeOption = List.of("U", "D");

		//when
		List<String> result = gameService.makeBridge(bridgeSize);

		//then
		Assertions.assertThat(result).containsAnyOf("U", "D");
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

	@DisplayName("saveUserCorrectSpace 에서 upperBridge 에 O 저장 확인 테스트")
	@Test
	void saveUserCorrectSpaceInUpperBridge() {
		//given
		String userLocation = "U";

		//when
		UserBridgeStatusDto userBridgeStatusDto = gameService.saveUserCorrectSpace(userLocation);
		List<String> userUpperBridge = userBridgeStatusDto.getUserUpperBridge();
		String result = userUpperBridge.get(userUpperBridge.size() - 1);

		//then
		Assertions.assertThat(result).isEqualTo("O");
	}

	@DisplayName("saveUserCorrectSpace 에서 upperBridge 에 O 저장 확인 테스트")
	@Test
	void saveUserCorrectSpaceInLowerBridge() {
		//given
		String userLocation = "D";

		//when
		UserBridgeStatusDto userBridgeStatusDto = gameService.saveUserCorrectSpace(userLocation);
		List<String> userLowerBridge = userBridgeStatusDto.getUserLowerBridge();
		String result = userLowerBridge.get(userLowerBridge.size() - 1);

		//then
		Assertions.assertThat(result).isEqualTo("O");
	}

	@DisplayName("saveUserWrongSpace 에서 upperBridge 에 X 저장 확인 테스트")
	@Test
	void saveUserWrongSpaceInUpperBridge() {
		//given
		String userLocation = "U";

		//when
		UserBridgeStatusDto userBridgeStatusDto = gameService.saveUserWrongSpace(userLocation);
		List<String> userUpperBridge = userBridgeStatusDto.getUserUpperBridge();
		String result = userUpperBridge.get(userUpperBridge.size() - 1);

		//then
		Assertions.assertThat(result).isEqualTo("X");
	}

	@DisplayName("saveUserWrongSpace 에서 upperBridge 에 X 저장 확인 테스트")
	@Test
	void getUserBridgeStatusDtoInLowerBridge() {
		//given
		String userLocation = "D";

		//when
		UserBridgeStatusDto userBridgeStatusDto = gameService.saveUserWrongSpace(userLocation);
		List<String> userLowerBridge = userBridgeStatusDto.getUserLowerBridge();
		String result = userLowerBridge.get(userLowerBridge.size() - 1);

		//then
		Assertions.assertThat(result).isEqualTo("X");
	}

	@DisplayName("userBridgeRepository 안에 데이터가 있는 상태에서 gameService.clearUserBridge() 할시 데이터가 남아 있는 확인 테스트")
	@Test
	void clearUserBridge() {
		//given
		userBridgeRepository.saveUserSpace("U", "X");
		userBridgeRepository.saveUserSpace("D", "X");
		UserBridgeStatusDto userBridgeStatusDto = userBridgeRepository.findUserBridgeStatusDto();
		List<String> userUpperBridge = userBridgeStatusDto.getUserUpperBridge();
		List<String> userLowerBridge = userBridgeStatusDto.getUserLowerBridge();

		//when
		gameService.clearUserBridge();

		//then
		Assertions.assertThat(userUpperBridge).isEmpty();
		Assertions.assertThat(userLowerBridge).isEmpty();
	}
}
