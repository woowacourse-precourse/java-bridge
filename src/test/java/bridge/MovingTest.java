package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingTest {
	@DisplayName("이동할 칸이 유효하지 않은 예외를 처리한다.")
	//given
	@ValueSource(strings = {"2", "R", "Q", "0", "", " "})
	@ParameterizedTest
	void MovingTestAbnormal(String strings) {
		//when, then
		assertThatThrownBy(() -> {
			Moving moving = new Moving(strings);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("이동할 칸이 유효한지 검증한다.")
	//given
	@ValueSource(strings = {"U", "D"})
	@ParameterizedTest
	void MovingTestNormal(String strings) {
		//when, then
		assertDoesNotThrow(() -> {
			Moving moving = new Moving(strings);
		});
	}
}