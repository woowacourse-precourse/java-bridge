package bridge.repository;

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
		//given
		String userLocation = "U";

		//when
		userBridgeRepository.saveUserCorrectSpace(userLocation);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[ O ]" + "\n" + "[   ]");
	}

	@DisplayName("saveUserCorrectSpace 에서 lowerBridge 에 O 저장 확인 테스트")
	@Test
	void saveUserCorrectSpaceInLowerBridge() {
		//given
		String userLocation = "D";

		//when
		userBridgeRepository.saveUserCorrectSpace(userLocation);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[   ]" + "\n" + "[ O ]");
	}

	@DisplayName("saveUserWrongSpace 에서 upperBridge 에 X 저장 확인 테스트")
	@Test
	void saveUserWrongSpaceInUpperBridge() {
		//given
		String userLocation = "U";

		//when
		userBridgeRepository.saveUserWrongSpace(userLocation);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[ X ]" + "\n" + "[   ]");
	}

	@DisplayName("saveUserWrongSpace 에서 lowerBridge 에 X 저장 확인 테스트")
	@Test
	void saveUserWrongSpaceInLowerBridge() {
		//given
		String userLocation = "D";

		//when
		userBridgeRepository.saveUserWrongSpace(userLocation);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[   ]" + "\n" + "[ X ]");
	}

	@DisplayName("findUserBridgeStatus 테스트")
	@Test
	void findUserBridgeStatus() {
		//given
		String location1 = "U";
		String location2 = "D";
		String location3 = "D";

		//when
		userBridgeRepository.saveUserCorrectSpace(location1);
		userBridgeRepository.saveUserWrongSpace(location2);
		userBridgeRepository.saveUserCorrectSpace(location3);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		//then
		Assertions.assertThat(userBridgeStatus)
			.isEqualTo("[ O |   |   ]" + "\n" + "[   | X | O ]");
	}

	// @DisplayName("userBridgeRepository 의 clear 테스트")
	// @Test
	// void clear() {
	// 	//given
	// 	userBridgeRepository.saveUserSpace("U", "X");
	// 	userBridgeRepository.saveUserSpace("D", "X");
	//
	// 	//when
	// 	userBridgeRepository.clear();
	// 	UserBridgeStatusDto userBridgeStatusDto = userBridgeRepository.findUserBridgeStatusDto();
	// 	List<String> userUpperBridge = userBridgeStatusDto.getUserUpperBridge();
	// 	List<String> userLowerBridge = userBridgeStatusDto.getUserLowerBridge();
	// 	Integer userCurrentLocation = userBridgeStatusDto.getUserCurrentLocation();
	//
	// 	//then
	// 	Assertions.assertThat(userUpperBridge).isEmpty();
	// 	Assertions.assertThat(userLowerBridge).isEmpty();
	// 	Assertions.assertThat(userCurrentLocation).isEqualTo(0);
	// }
}
