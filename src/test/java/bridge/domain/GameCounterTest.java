package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("GameCounter 테스트")
class GameCounterTest {
	@Nested
	@DisplayName("addCount 메소드는")
	class Describe_addCount {
		private int numberOrIterations = 3;

		@Test
		@DisplayName("GameCounter의 count를 1 더해준다.")
		void it_adds_count() {
			GameCounter gameCounter = new GameCounter();
			while (numberOrIterations-- > 0) {
				gameCounter.addCount();
			}

			int expected = 3;
			assertThat(gameCounter.getCount()).isEqualTo(expected);
		}
	}
}
