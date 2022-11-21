package bridge.outputview;

import static bridge.Constants.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.BridgeStatus;
import bridge.OutputView;

public class ResultTest {
	BridgeStatus bridgeStatus = BridgeStatus.getInstance();
	@DisplayName("게임 종료 시 최종 결과 출력")
	@Test
	void printResult() {
		// given
		String userSelectedCell = UP;
		String bridgeLetter = UP;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = DOWN;
		bridgeLetter = DOWN;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = DOWN;
		bridgeLetter = DOWN;
		move(userSelectedCell, bridgeLetter);

		HashMap<String, String> expectedStatus = new HashMap<>();
		expectedStatus.put(UPPER_CELL, "[ O |   |   ]");
		expectedStatus.put(LOWER_CELL, "[   | O | O ]");

		// when
		HashMap<String, String> actualStatus = new OutputView().printResult();

		// then
		assertThat(actualStatus).isEqualTo(expectedStatus);
	}


	@DisplayName("게임 성공 여부 출력 확인 - 성공")
	@Test
	void printSuccess() {
		// given
		String userSelectedCell = UP;
		String bridgeLetter = UP;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = DOWN;
		bridgeLetter = DOWN;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = DOWN;
		bridgeLetter = DOWN;
		move(userSelectedCell, bridgeLetter);

		String expectedPrint = OUTPUT_GAME_REPORT + SUCCESS_MESSAGE;

		// when
		String success = new OutputView().printSuccessOrNot();
		String actualPrint = OUTPUT_GAME_REPORT + success;

		// then
		assertThat(actualPrint).isEqualTo(expectedPrint);
	}

	@DisplayName("게임 성공 여부 출력 확인 - 실패")
	@Test
	void printFail() {
		// given
		String userSelectedCell = UP;
		String bridgeLetter = UP;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = DOWN;
		bridgeLetter = DOWN;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = UP;
		bridgeLetter = DOWN;
		move(userSelectedCell, bridgeLetter);

		String expectedPrint = OUTPUT_GAME_REPORT + FAIL_MESSAGE;

		// when
		String fail = new OutputView().printSuccessOrNot();
		String actualPrint = OUTPUT_GAME_REPORT + fail;

		// then
		assertThat(actualPrint).isEqualTo(expectedPrint);
	}

	@DisplayName("총 시도한 게임 횟수 출력 확인")
	@Test
	void printTotalGameCount() {
		// given
		String userSelectedCell = UP;
		String bridgeLetter = UP;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = DOWN;
		bridgeLetter = DOWN;
		move(userSelectedCell, bridgeLetter);
		userSelectedCell = UP;
		bridgeLetter = DOWN;
		move(userSelectedCell, bridgeLetter);

		String expectedPrint = OUTPUT_TOTAL_TRY_COUNT + "1";

		// when
		int totalGameCount = new OutputView().printTotalAttemptCount();
		String actualPrint = OUTPUT_TOTAL_TRY_COUNT + totalGameCount;

		// then
		assertThat(actualPrint).isEqualTo(expectedPrint);
	}

	private void move(String userSelectedCell, String bridgeLetter) {
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
	}
}
