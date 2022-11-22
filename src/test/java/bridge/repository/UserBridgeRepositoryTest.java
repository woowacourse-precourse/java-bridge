package bridge.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserBridgeRepositoryTest {

	private UserBridgeRepository userBridgeRepository = new UserBridgeRepository();

	@AfterEach
	void tearDown() {
		userBridgeRepository.clear();
	}

	@DisplayName("saveUserCorrectSpace 에서 upperBridge 에 O 저장 확인 테스트")
	@Test
	void saveUserCorrectSpaceInUpperBridge() {
		String userLocation = "U";

		userBridgeRepository.saveUserCorrectSpace(userLocation);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		Assertions.assertThat(userBridgeStatus).isEqualTo("[ O ]" + "\n" + "[   ]");
	}

	@DisplayName("saveUserCorrectSpace 에서 lowerBridge 에 O 저장 확인 테스트")
	@Test
	void saveUserCorrectSpaceInLowerBridge() {
		String userLocation = "D";

		userBridgeRepository.saveUserCorrectSpace(userLocation);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		Assertions.assertThat(userBridgeStatus).isEqualTo("[   ]" + "\n" + "[ O ]");
	}

	@DisplayName("saveUserWrongSpace 에서 upperBridge 에 X 저장 확인 테스트")
	@Test
	void saveUserWrongSpaceInUpperBridge() {
		String userLocation = "U";

		userBridgeRepository.saveUserWrongSpace(userLocation);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		Assertions.assertThat(userBridgeStatus).isEqualTo("[ X ]" + "\n" + "[   ]");
	}

	@DisplayName("saveUserWrongSpace 에서 lowerBridge 에 X 저장 확인 테스트")
	@Test
	void saveUserWrongSpaceInLowerBridge() {
		String userLocation = "D";

		userBridgeRepository.saveUserWrongSpace(userLocation);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		Assertions.assertThat(userBridgeStatus).isEqualTo("[   ]" + "\n" + "[ X ]");
	}

	@DisplayName("findUserBridgeStatus 테스트")
	@Test
	void findUserBridgeStatus() {
		List<String> location = List.of("U", "D", "D");
		userBridgeRepository.saveUserCorrectSpace(location.get(0));
		userBridgeRepository.saveUserWrongSpace(location.get(1));
		userBridgeRepository.saveUserCorrectSpace(location.get(2));
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();
		Assertions.assertThat(userBridgeStatus)
			.isEqualTo("[ O |   |   ]" + "\n" + "[   | X | O ]");
	}

	@DisplayName("userBridgeRepository 의 clear 테스트")
	@Test
	void clear() {
		userBridgeRepository.saveUserWrongSpace("U");
		userBridgeRepository.saveUserWrongSpace("D");

		userBridgeRepository.clear();
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		Assertions.assertThat(userBridgeStatus).isEqualTo("[  ]\n[  ]");
	}
}
