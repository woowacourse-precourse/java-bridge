package bridge.outputview;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.BridgeStatus;
import bridge.OutputView;

public class TwoStepMoveTest {
	BridgeStatus bridgeStatus = BridgeStatus.getInstance();

	@DisplayName("연속된 U가 입력되었을 때, 두 번째 U는 X 표시 출력")
	@Test
	void printFailSecondUpperCell() {
		// given
		String userSelectedCell = "U";
		String bridgeLetter = "U";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "U";
		bridgeLetter = "D";
		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put("UpperCell", "[ O | X ]");
		expectedStatus.put("LowerCell", "[   |   ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}

	@DisplayName("연속된 D가 입력되었을 때, 두 번째 D는 X 표시 출력")
	@Test
	void printFailSecondLowerCell() {
		// given
		String userSelectedCell = "D";
		String bridgeLetter = "D";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "D";
		bridgeLetter = "U";
		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put("UpperCell", "[   |   ]");
		expectedStatus.put("LowerCell", "[ O | X ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}
}
