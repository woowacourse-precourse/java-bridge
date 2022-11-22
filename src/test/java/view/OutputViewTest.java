package view;

import static org.assertj.core.api.Assertions.*;

import static model.BridgeGameConstants.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

	private ByteArrayOutputStream outputStream;
	private OutputView outputView = new OutputView();

	@BeforeEach
	void setOutputStreamBeforeEach() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@AfterEach
	void printMapClearAndRestoreOutputStream() {
		outputView.clearGameStateMap();
		System.setOut(System.out);
	}

	@Test
	@DisplayName("다리 한 번 건너고 성공한 경우 테스트")
	void printMapTestOneMoving() {
		// given
		List<String> bridge = List.of("U", "U", "D");

		// when
		String movingCommand = "U";
		int movingResult = MOVING_SUCCESS;
		String expectedPrint = "[ O ]\r\n[   ]\r\n\r\n";
		outputView.printMap(movingCommand, movingResult);

		// then
		assertThat(outputStream.toString()).isEqualTo(expectedPrint);

		outputView.clearGameStateMap();
		setOutputStream();
		// when
		movingCommand = "D";
		expectedPrint = "[   ]\r\n[ O ]\r\n\r\n";
		outputView.printMap(movingCommand, movingResult);
		assertThat(outputStream.toString()).isEqualTo(expectedPrint);
	}

	@Test
	@DisplayName("다리를 두번 건넌 경우 테스트")
	void printMapTestTwoMoving() {
		// given
		List<String> bridge = List.of("D", "D", "D");
		List<String> movingCommands = List.of("U", "D");
		List<Integer> movingResults = List.of(MOVING_FAIL_WRONG_MOVING, MOVING_SUCCESS);
		List<String> expectedPrintMaps = List.of("[ X ]\r\n[   ]\r\n\r\n", "[ X |   ]\r\n[   | O ]\r\n\r\n");

		for (int moveCount = 0; moveCount < movingCommands.size(); moveCount++) {

			String movingCommand = movingCommands.get(moveCount);
			int movingResult = movingResults.get(moveCount);
			String expectedPrintMap = expectedPrintMaps.get(moveCount);

			outputView.printMap(movingCommand, movingResult);

			// then
			assertThat(outputStream.toString()).isEqualTo(expectedPrintMap);
			setOutputStream();
		}
	}

	private void setOutputStream() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}
}
