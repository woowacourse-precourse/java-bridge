package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Floor 객체를 테스트한다.")
class FloorTest {

    @Nested
    @DisplayName("Floor의 생성자에는 U 혹은 D가 들어온다.")
    class createFloor {

        @DisplayName("U 혹은 D가 들어온다.")
        @ParameterizedTest(name = "생성값: {0}")
        @CsvSource({"U", "D"})
        void goodStatus(String status) {
            assertDoesNotThrow(() -> {
                new Floor(status);
            });
        }

        @DisplayName("U, D가 아닌 잘못된 입력값의 경우 예외")
        @ParameterizedTest(name = "생성값: {0}")
        @CsvSource({"A", "B", "1", "hello world"})
        void badStatus(String status) {
            assertThrows(IllegalArgumentException.class, () -> {
                new Floor(status);
            });
        }
    }

    @Nested
    @DisplayName("isSafe 함수는 문자열을 입력하면 바닥의 상태(U/D)와 동일여부를 반환한다.")
    class isSafeTest {

        @DisplayName("입력값과 상태가 동일하다.")
        @ParameterizedTest(name = "바닥: {0}, 검증값: {1}")
        @CsvSource(value = {"D:D", "U:U"}, delimiter = ':')
        void floorNotBroken(String status, String input) {
            Floor floor = new Floor(status);
            assertTrue(floor.isSafe(input));
        }

        @DisplayName("입력값과 상태가 동일하지않다.")
        @ParameterizedTest(name = "바닥: {0}, 검증값: {1}")
        @CsvSource(value = {"U:D", "D:U"}, delimiter = ':')
        void floorBroken(String status, String input) {
            Floor floor = new Floor(status);
            assertFalse(floor.isSafe(input));
        }

        @DisplayName("U, D가 아닌 잘못된 입력값의 경우 예외")
        @ParameterizedTest(name = "바닥: {0}, 검증값: {1}")
        @CsvSource(value = {"D:ㅁㅇㄹㅁㄹ", "U:u", "D: 2", "U:Down"}, delimiter = ':')
        void badInput(String status, String input) {
            Floor floor = new Floor(status);
            assertThrows(IllegalArgumentException.class, () -> {
                floor.isSafe(input);
            });
        }
    }
}