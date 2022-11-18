package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FootPrintTest {
	@DisplayName("층수와 정답 여부를 입력하면 footPrints를 리턴한다.")
	@Nested
	class MakeFootPrintsTest {
		@Test
		void case1() {
			int stairs = 0;
			Boolean isRight = true;
			assertEquals(FootPrint.makeFootPrints(stairs, isRight),
				List.of(FootPrint.RIGHT.getFootPrint(), FootPrint.Blank.getFootPrint()));
		}

		@Test
		void case2() {
			int stairs = 1;
			Boolean isRight = true;
			assertEquals(FootPrint.makeFootPrints(stairs, isRight),
				List.of(FootPrint.Blank.getFootPrint(), FootPrint.RIGHT.getFootPrint()));
		}

		@Test
		void case3() {
			int stairs = 0;
			Boolean isRight = false;
			assertEquals(FootPrint.makeFootPrints(stairs, isRight),
				List.of(FootPrint.WRONG.getFootPrint(), FootPrint.Blank.getFootPrint()));
		}

		@Test
		void case4() {
			int stairs = 1;
			Boolean isRight = false;
			assertEquals(FootPrint.makeFootPrints(stairs, isRight),
				List.of(FootPrint.Blank.getFootPrint(), FootPrint.WRONG.getFootPrint()));
		}
	}
}
