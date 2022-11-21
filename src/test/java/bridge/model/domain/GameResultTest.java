package bridge.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameResultTest {

	@DisplayName("addNumberOfAttempts 메서드 호출 수 만큼 numberOfAttempts 변수가 변화한다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 4, 7, 100, 1100})
	void getNumberOfAttemptsTest(int count) {
		GameResult gameResult = new GameResult();
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
			GameResult gameResult = new GameResult();
			gameResult.changeResultToSuccess();
			assertEquals(gameResult.getResult(), "성공");
		}

		@Test
		void case2() {
			GameResult gameResult = new GameResult();
			gameResult.changeResultToFail();
			assertEquals(gameResult.getResult(), "실패");
		}

		@Test
		void case3() {
			GameResult gameResult = new GameResult();
			gameResult.changeResultToSuccess();
			gameResult.changeResultToSuccess();
			assertEquals(gameResult.getResult(), "성공");
		}

		@Test
		void case4() {
			GameResult gameResult = new GameResult();
			gameResult.changeResultToFail();
			gameResult.changeResultToFail();
			assertEquals(gameResult.getResult(), "실패");
		}

		@Test
		void case5() {
			GameResult gameResult = new GameResult();
			gameResult.changeResultToSuccess();
			gameResult.changeResultToSuccess();
			gameResult.changeResultToFail();
			assertEquals(gameResult.getResult(), "실패");
		}

		@Test
		void case6() {
			GameResult gameResult = new GameResult();
			gameResult.changeResultToFail();
			gameResult.changeResultToFail();
			gameResult.changeResultToSuccess();
			assertEquals(gameResult.getResult(), "성공");
		}
	}

}
