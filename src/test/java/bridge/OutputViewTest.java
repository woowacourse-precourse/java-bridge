package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
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

	@DisplayName("연속된 U가 입력되었을 때, 두 번째 U는 X 표시 출력")
	@Test
	void printFailSecondUpperCell() {
		// given
		printSuccessUpperCell();
		String userSelectedCell = "U";
		String bridgeLetter = "D";
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
		printSuccessLowerCell();
		String userSelectedCell = "D";
		String bridgeLetter = "U";
		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put("UpperCell", "[   |   ]");
		expectedStatus.put("LowerCell", "[ O | X ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printMap(userSelectedCell, bridgeLetter);

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}

	@DisplayName("게임 종료 시 최종 결과 출력")
	@Test
	void printResult() {
		// given
		BridgeStatus bridgeStatus = BridgeStatus.getInstance();
		String userSelectedCell = "U";
		String bridgeLetter = "U";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "D";
		bridgeLetter = "D";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "D";
		bridgeLetter = "D";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put("UpperCell", "[ O |   |   ]");
		expectedStatus.put("LowerCell", "[   | O | O ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printResult();

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}
}
