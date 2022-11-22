package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserBridgeGroupTest {

	private UserBridgeGroup userBridgeGroup = new UserBridgeGroup();

	@AfterEach
	void tearDown() {
		userBridgeGroup.clearStatus();
	}

	@ParameterizedTest(name = "다리에 상태 입력시 다른쪽 다리는 빈칸으로 업데이트 되는지 확인 테스트")
	@CsvSource(value = {"U, X, [ X ][   ]", "D, O, [   ][ O ]"})
	void updateUpperStatus(String location, String userTrace, String status) {
		userBridgeGroup.updateStatus(location, userTrace);

		String upperStatusToString = userBridgeGroup.statusToString("U", 1);
		String lowerStatusToString = userBridgeGroup.statusToString("D", 1);
		upperStatusToString += lowerStatusToString;

		Assertions.assertThat(upperStatusToString).isEqualTo(status);
	}

	@ParameterizedTest(name = "다리에 상태 String 확인 테스트")
	@CsvSource(value = {"U, X, [ X ]", "D, O, [ O ]"})
	void statusToString(String location, String userTrace, String status) {
		userBridgeGroup.updateStatus(location, userTrace);

		String upperStatusToString = userBridgeGroup.statusToString(location, 1);

		Assertions.assertThat(upperStatusToString).isEqualTo(status);
	}

	@ParameterizedTest(name = "다리에 상태 초기화 확인 테스트")
	@CsvSource(value = {"U, X, [  ]", "D, O, [  ]"})
	void clearStatus(String location, String userTrace, String status) {
		userBridgeGroup.updateStatus(location, userTrace);

		userBridgeGroup.clearStatus();
		String upperStatusToString = userBridgeGroup.statusToString(location, 0);

		Assertions.assertThat(upperStatusToString).isEqualTo(status);
	}
}
