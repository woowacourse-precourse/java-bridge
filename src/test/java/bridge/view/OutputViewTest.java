package bridge.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

	private OutputView outputView = new OutputView();
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	void printGameStart() {
		//when
		String result = OutputView.START_GAME_PHRASE;

		//when
		outputView.printGameStart();

		//then
		Assertions.assertThat(outContent.toString()).contains(result);
	}

	@Test
	void printFinalResultPhrase() {
		//when
		String result = OutputView.USER_FINAL_RESULT_PHRASE;

		//given
		outputView.printFinalResultPhrase();

		//then
		Assertions.assertThat(outContent.toString()).contains(result);
	}

	@Test
	void printMap() {
		//when
		String result1 = "[ O |   | O ]";
		String result2 = "[   | O |   ]";

		//given
		outputView.printMap(result1 + "\n" + result2);

		//then
		Assertions.assertThat(outContent.toString()).contains(result1, result2);
	}

	@Test
	void printResult() {
		//when
		String userFinalResult = OutputView.USER_FINAL_RESULT;
		String userTryCountPhrase = OutputView.USER_TRY_COUNT_PHRASE;
		String result = "성공";
		Integer count = 1000;

		//given
		outputView.printResult(result, count);

		//then
		Assertions.assertThat(outContent.toString()).contains(userFinalResult, userTryCountPhrase);
	}

	@Test
	void printError() {
		//when
		String errorMessage = "[ERROR] ";

		//given
		outputView.printError(errorMessage);

		//then
		Assertions.assertThat(outContent.toString()).contains(errorMessage);
	}
}
