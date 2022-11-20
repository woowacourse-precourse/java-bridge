package bridge.outputview;

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

	@DisplayName("게임 성공 여부 출력 확인 - 성공")
	@Test
	void printSuccess() {
		// given
		String userSelectedCell = "U";
		String bridgeLetter = "U";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "D";
		bridgeLetter = "D";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "D";
		bridgeLetter = "D";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		String expectedPrint = "게임 성공 여부: 성공";

		// when
		String success = new OutputView().printSuccessOrNot();
		String actualPrint = "게임 성공 여부: " + success;

		// then
		assertThat(actualPrint).isEqualTo(expectedPrint);
	}

	@DisplayName("게임 성공 여부 출력 확인 - 실패")
	@Test
	void printFail() {
		// given
		String userSelectedCell = "U";
		String bridgeLetter = "U";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "D";
		bridgeLetter = "D";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "U";
		bridgeLetter = "D";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		String expectedPrint = "게임 성공 여부: 실패";

		// when
		String fail = new OutputView().printSuccessOrNot();
		String actualPrint = "게임 성공 여부: " + fail;

		// then
		assertThat(actualPrint).isEqualTo(expectedPrint);
	}

	@DisplayName("총 시도한 게임 횟수 출력 확인")
	@Test
	void printTotalGameCount() {
		// given
		String userSelectedCell = "U";
		String bridgeLetter = "U";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "D";
		bridgeLetter = "D";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		userSelectedCell = "U";
		bridgeLetter = "D";
		bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		String expectedPrint = "총 시도한 게임 횟수: 3";

		// when
		int totalGameCount = new OutputView().printTotalGameCount();
		String actualPrint = "총 시도한 게임 횟수: " + totalGameCount;

		// then
		assertThat(actualPrint).isEqualTo(expectedPrint);
	}
}
