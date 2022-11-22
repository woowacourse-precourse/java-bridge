package bridge.outputview;

import static bridge.util.Constants.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.view.OutputView;

public class OneStepMoveTest {
	@DisplayName("위 칸이 이동 가능한 칸인 경우 O 표시 출력")
	@Test
	void printSuccessUpperCell() {
		// given
		String userSelectedCell = UP;
		String bridgeLetter = UP;

		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put(UPPER_CELL, "[ O ]");
		expectedStatus.put(LOWER_CELL, "[   ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}

	@DisplayName("위 칸이 이동 불가능한 칸인 경우 X 표시 출력")
	@Test
	void printFailUpperCell() {
		// given
		String userSelectedCell = UP;
		String bridgeLetter = DOWN;

		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put(UPPER_CELL, "[ X ]");
		expectedStatus.put(LOWER_CELL, "[   ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}

	@DisplayName("아래 칸이 이동 가능한 칸인 경우 O 표시 출력")
	@Test
	void printSuccessLowerCell() {
		// given
		String userSelectedCell = DOWN;
		String bridgeLetter = DOWN;

		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put(UPPER_CELL, "[   ]");
		expectedStatus.put(LOWER_CELL, "[ O ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}

	@DisplayName("아래 칸이 이동 불가능한 칸인 경우 X 표시 출력")
	@Test
	void printFailLowerCell() {
		// given
		String userSelectedCell = DOWN;
		String bridgeLetter = UP;

		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put(UPPER_CELL, "[   ]");
		expectedStatus.put(LOWER_CELL, "[ X ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}
}
