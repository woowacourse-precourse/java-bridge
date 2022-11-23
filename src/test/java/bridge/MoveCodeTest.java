package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.*;

class MoveCodeTest {
	@ParameterizedTest
	@DisplayName("입력값이 U,D 이외의 값일 경우 예외가 발생한다.")
	@ValueSource(strings = {" ", "u", "d", "1", "U1"})
	void createMoveCodeByUnvalidateInput(String input) {
		assertThatThrownBy(() -> MoveCode.getMoveCodeByInputCode(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}