package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveResultTest {
	@ParameterizedTest(name = "inputCode : {0} , bridge : {1} ")
	@DisplayName("입력 값과 다리의 값이 같을 경우 O를 반환한다.")
	@CsvSource({"U, U", "D, D"})
	void createMoveResultWhenInputSameWithBridgeValue(String inputCode, String bridge) {
		assertThat(MoveResult.getMoveResultByInputCode(inputCode, bridge) == MoveResult.CAN_MOVE) ;
	}
}