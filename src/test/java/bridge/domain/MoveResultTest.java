package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoveResultTest {

	@Test
	@DisplayName("정상적으로 결과 반영을 해주는지 테스트")
	void moveResultTest() {
		List<String> expect = new ArrayList<>(List.of("O", " "));
		List<String> expect2 = new ArrayList<>(List.of("X", " "));
		List<String> expect3 = new ArrayList<>(List.of(" ", "O"));

		List<String> result = MoveResult.createMoveResult("U",true);
		List<String> result2 = MoveResult.createMoveResult("U",false);
		List<String> result3 = MoveResult.createMoveResult("D",true);

		assertEquals(expect, result);
		assertEquals(expect2, result2);
		assertEquals(expect3, result3);
	}
}
