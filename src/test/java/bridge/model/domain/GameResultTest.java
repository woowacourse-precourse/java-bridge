package bridge.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameResultTest {
	private static final String SUCCESS = "성공";
	private static final String FAIL = "실패";

	private GameResult gameResult;

	@BeforeEach
	void setGameResult() {
		gameResult = new GameResult();
	}

	@DisplayName("addNumberOfAttempts 메서드 호출 수 만큼 numberOfAttempts 변수가 변화한다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 4, 7, 100, 1100})
	void getNumberOfAttemptsTest(int count) {
		for (int i = 0; i < count; i++) {
			gameResult.addNumberOfAttempts();
		}
		assertEquals(gameResult.getNumberOfAttempts(), count);
	}

	@DisplayName("최종적으로 바뀐 결과를 리턴한다.")
	@Nested
	class ChangeResultTest {
		@Test
		void case1() {
			gameResult.changeResultToSuccess();
			assertEquals(gameResult.getResult(), SUCCESS);
		}

		@Test
		void case2() {
			gameResult.changeResultToFail();
			assertEquals(gameResult.getResult(), FAIL);
		}

		@Test
		void case3() {
			gameResult.changeResultToSuccess();
			gameResult.changeResultToSuccess();
			assertEquals(gameResult.getResult(), SUCCESS);
		}

		@Test
		void case4() {
			gameResult.changeResultToFail();
			gameResult.changeResultToFail();
			assertEquals(gameResult.getResult(), FAIL);
		}

		@Test
		void case5() {
			gameResult.changeResultToSuccess();
			gameResult.changeResultToSuccess();
			gameResult.changeResultToFail();
			assertEquals(gameResult.getResult(), FAIL);
		}

		@Test
		void case6() {
			gameResult.changeResultToFail();
			gameResult.changeResultToFail();
			gameResult.changeResultToSuccess();
			assertEquals(gameResult.getResult(), SUCCESS);
		}
	}

}
