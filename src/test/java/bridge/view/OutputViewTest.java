package bridge.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

	private OutputView outputView = new OutputView();
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@DisplayName("printGameStart 메서드 출력 테스트")
	@Test
	void printGameStart() {
		//when
		String result = OutputView.START_GAME_PHRASE;

		//when
		outputView.printGameStart();

		//then
		Assertions.assertThat(outContent.toString()).contains(result);
	}

	@DisplayName("printFinalResultPhrase 메서드 출력 테스트")
	@Test
	void printFinalResultPhrase() {
		//when
		String result = OutputView.USER_FINAL_RESULT_PHRASE;

		//given
		outputView.printFinalResultPhrase();

		//then
		Assertions.assertThat(outContent.toString()).contains(result);
	}

	@DisplayName("printMap 메서드 출력 테스트")
	@Test
	void printMap() {
		String result1 = "[ O |   | O ]";
		String result2 = "[   | O |   ]";

		outputView.printMap(result1 + "\n" + result2);

		Assertions.assertThat(outContent.toString()).contains(result1, result2);
	}

	@DisplayName("printResult 메서드 출력 테스트")
	@Test
	void printResult() {
		String userFinalResult = OutputView.USER_FINAL_RESULT;
		String userTryCountPhrase = OutputView.USER_TRY_COUNT_PHRASE;
		String result = "성공";
		Integer count = 1000;
		String finalResult = userFinalResult + result + "\n" + userTryCountPhrase + count;
		outputView.printResult(finalResult);

		Assertions.assertThat(outContent.toString()).contains(userFinalResult, userTryCountPhrase);
	}

	@DisplayName("printError 메서드 출력 테스트")
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
