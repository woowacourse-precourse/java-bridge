package bridge.outputview;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.OutputView;

public class OneStepMoveTest {
	@DisplayName("위 칸이 이동 가능한 칸인 경우 O 표시 출력")
	@Test
	void printSuccessUpperCell() {
		// given
		String userSelectedCell = "U";
		String bridgeLetter = "U";
		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put("UpperCell", "[ O ]");
		expectedStatus.put("LowerCell", "[   ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}

	@DisplayName("위 칸이 이동 불가능한 칸인 경우 X 표시 출력")
	@Test
	void printFailUpperCell() {
		// given
		String userSelectedCell = "U";
		String bridgeLetter = "D";
		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put("UpperCell", "[ X ]");
		expectedStatus.put("LowerCell", "[   ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}

	@DisplayName("아래 칸이 이동 가능한 칸인 경우 O 표시 출력")
	@Test
	void printSuccessLowerCell() {
		// given
		String userSelectedCell = "D";
		String bridgeLetter = "D";
		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put("UpperCell", "[   ]");
		expectedStatus.put("LowerCell", "[ O ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}

	@DisplayName("아래 칸이 이동 불가능한 칸인 경우 X 표시 출력")
	@Test
	void printFailLowerCell() {
		// given
		String userSelectedCell = "D";
		String bridgeLetter = "U";
		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put("UpperCell", "[   ]");
		expectedStatus.put("LowerCell", "[ X ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}
}
