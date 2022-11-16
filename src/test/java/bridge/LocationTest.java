package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LocationTest {
	@DisplayName("U 혹은 D를 입력하면 숫자로 변환한다")
	@Test
	void case1() {
		assertEquals(Location.convertToInt("U"), 1);
		assertEquals(Location.convertToInt("u"), 1);
		assertEquals(Location.convertToInt("D"), 0);
		assertEquals(Location.convertToInt("d"), 0);
	}

	@DisplayName("U 혹은 D 외의 것을 입력하면 에러 메시지를 출력한다")
	@Nested
	class ConvertToIntTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.convertToInt("a");
			});
			assertEquals(Error.LOCATION.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.convertToInt("Z");
			});
			assertEquals(Error.LOCATION.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.convertToInt("0");
			});
			assertEquals(Error.LOCATION.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.convertToInt("-1");
			});
			assertEquals(Error.LOCATION.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.convertToInt("100000");
			});
			assertEquals(Error.LOCATION.getMessage(), exception.getMessage());
		}

		@Test
		void case6() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.convertToInt("");
			});
			assertEquals(Error.LOCATION.getMessage(), exception.getMessage());
		}

		@Test
		void case7() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.convertToInt(" ");
			});
			assertEquals(Error.LOCATION.getMessage(), exception.getMessage());
		}
	}

}
