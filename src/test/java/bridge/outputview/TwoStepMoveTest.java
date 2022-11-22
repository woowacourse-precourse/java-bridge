package bridge.outputview;

import static bridge.util.Constants.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.service.BridgeStatus;
import bridge.view.OutputView;

public class TwoStepMoveTest {
	BridgeStatus bridgeStatus = BridgeStatus.getInstance();

	@DisplayName("연속된 U가 입력되었을 때, 두 번째 U는 X 표시 출력")
	@Test
	void printFailSecondUpperCell() {
		// given
		String userSelectedCell = UP;
		String bridgeLetter = UP;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = UP;
		bridgeLetter = DOWN;

		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put(UPPER_CELL, "[ O | X ]");
		expectedStatus.put(LOWER_CELL, "[   |   ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}


	@DisplayName("연속된 D가 입력되었을 때, 두 번째 D는 X 표시 출력")
	@Test
	void printFailSecondLowerCell() {
		// given
		String userSelectedCell = DOWN;
		String bridgeLetter = DOWN;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = DOWN;
		bridgeLetter = UP;

		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put(UPPER_CELL, "[   |   ]");
		expectedStatus.put(LOWER_CELL, "[ O | X ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}

	private void move(String userSelectedCell, String bridgeLetter) {
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
	}
}
