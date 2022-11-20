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

	@DisplayName("saveUserSpace 에서 upper 위치에 userCurrentTrace 저장 확인 테스트")
	@Test
	void saveUserSpaceInUpper() {
		//given
		String location = "U";
		String userCurrentTrace = "X";

		//when
		userBridgeRepository.saveUserSpace(location, userCurrentTrace);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[ X ]" + "\n" + "[   ]");
	}

	@DisplayName("saveUserSpace 에서 lower 위치에 userCurrentTrace 저장 확인 테스트")
	@Test
	void saveUserSpaceInLower() {
		//given
		String location = "D";
		String userCurrentTrace = "X";

		//when
		userBridgeRepository.saveUserSpace(location, userCurrentTrace);
		String userBridgeStatus = userBridgeRepository.findUserBridgeStatus();

		//then
		Assertions.assertThat(userBridgeStatus).isEqualTo("[   ]" + "\n" + "[ X ]");
	}

	@DisplayName("findUserBridgeStatus 테스트")
	@Test
	void findUserBridgeStatus() {
		//given
		String location1 = "U";
		String userCurrentTrace1 = "O";
		String location2 = "D";
		String userCurrentTrace2 = "X";
		String location3 = "D";
		String userCurrentTrace3 = "O";

		//when
		userBridgeRepository.saveUserSpace(location1, userCurrentTrace1);
		userBridgeRepository.saveUserSpace(location2, userCurrentTrace2);
		userBridgeRepository.saveUserSpace(location3, userCurrentTrace3);
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
