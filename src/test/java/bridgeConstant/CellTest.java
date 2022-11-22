package bridgeConstant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CellTest {

	@DisplayName("숫자에 따라 칸의 선택이 올바른지 검증한다.")
	//given
	@ValueSource(ints = {1, 0})
	@ParameterizedTest
	void convertToPosition(int ints) {
		//when, then
		assertTrue(Cell.convertToPosition(ints).equals("U") || Cell.convertToPosition(ints).equals("D"));
	}
}