package bridge.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.repository.dto.UserBridgeStatusDto;

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
		UserBridgeStatusDto userBridgeStatusDto = userBridgeRepository.findUserBridgeStatusDto();
		List<String> userUpperBridge = userBridgeStatusDto.getUserUpperBridge();
		List<String> userLowerBridge = userBridgeStatusDto.getUserLowerBridge();

		//then
		Assertions.assertThat(userUpperBridge).isEqualTo(List.of("X"));
		Assertions.assertThat(userLowerBridge).isEqualTo(List.of(" "));
	}

	@DisplayName("saveUserSpace 에서 lower 위치에 userCurrentTrace 저장 확인 테스트")
	@Test
	void saveUserSpaceInLower() {
		//given
		String location = "D";
		String userCurrentTrace = "X";

		//when
		userBridgeRepository.saveUserSpace(location, userCurrentTrace);
		UserBridgeStatusDto userBridgeStatusDto = userBridgeRepository.findUserBridgeStatusDto();
		List<String> userUpperBridge = userBridgeStatusDto.getUserUpperBridge();
		List<String> userLowerBridge = userBridgeStatusDto.getUserLowerBridge();

		//then
		Assertions.assertThat(userUpperBridge).isEqualTo(List.of(" "));
		Assertions.assertThat(userLowerBridge).isEqualTo(List.of("X"));
	}

	@DisplayName("findUserBridgeStatusDto 테스트")
	@Test
	void findUserBridgeStatusDto() {
		//given
		String location1 = "U";
		String userCurrentTrace1 = "O";
		String location2 = "D";
		String userCurrentTrace2 = "X";
		String location3 = "D";
		String userCurrentTrace3 = "O";

		userBridgeRepository.saveUserSpace(location1, userCurrentTrace1);
		userBridgeRepository.saveUserSpace(location2, userCurrentTrace2);
		userBridgeRepository.saveUserSpace(location3, userCurrentTrace3);
		UserBridgeStatusDto userBridgeStatusDto = userBridgeRepository.findUserBridgeStatusDto();

		//when
		UserBridgeStatusDto userBridgeStatusDtoTest = new UserBridgeStatusDto(List.of("O", " ", " "),
			List.of(" ", "X", "O"), 3);

		//then
		Assertions.assertThat(userBridgeStatusDto.getUserUpperBridge())
			.isEqualTo(userBridgeStatusDtoTest.getUserUpperBridge());
		Assertions.assertThat(userBridgeStatusDto.getUserLowerBridge())
			.isEqualTo(userBridgeStatusDtoTest.getUserLowerBridge());
		Assertions.assertThat(userBridgeStatusDto.getUserCurrentLocation())
			.isEqualTo(userBridgeStatusDtoTest.getUserCurrentLocation());
	}

	@DisplayName("userBridgeRepository 의 clear 테스트")
	@Test
	void clear() {
		//given
		userBridgeRepository.saveUserSpace("U", "X");
		userBridgeRepository.saveUserSpace("D", "X");

		//when
		userBridgeRepository.clear();
		UserBridgeStatusDto userBridgeStatusDto = userBridgeRepository.findUserBridgeStatusDto();
		List<String> userUpperBridge = userBridgeStatusDto.getUserUpperBridge();
		List<String> userLowerBridge = userBridgeStatusDto.getUserLowerBridge();
		Integer userCurrentLocation = userBridgeStatusDto.getUserCurrentLocation();

		//then
		Assertions.assertThat(userUpperBridge).isEmpty();
		Assertions.assertThat(userLowerBridge).isEmpty();
		Assertions.assertThat(userCurrentLocation).isEqualTo(0);
	}
}
