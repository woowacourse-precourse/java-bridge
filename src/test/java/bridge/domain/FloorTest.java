package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    @Nested
    @DisplayName("바닥의 상태에 ")
    class floorStatus {

        @DisplayName("올바른 값이 입력된다.")
        @ParameterizedTest(name = "생성값: {0}")
        @CsvSource({"U", "D"})
        void goodStatus(String status) {
            assertDoesNotThrow(() -> {
                new Floor("U");
                new Floor("D");
            });
        }

        @DisplayName("올바르지 못한 값이 입력된다.")
        @ParameterizedTest(name = "생성값: {0}")
        @CsvSource({"A", "B", "1", "hello world"})
        void badStatus(String status) {
            assertThrows(IllegalArgumentException.class, () -> {
                new Floor(status);
            });
        }
    }

    @Nested
    @DisplayName("바닥의 값과 검증값이 ")
    class floorBrokenTest {

        @DisplayName("동일하지 않다.")
        @ParameterizedTest(name = "바닥: {0}, 검증값: {1}")
        @CsvSource(value = {"U:D", "D:U"}, delimiter = ':')
        void floorBroken(String status, String input) {
            Floor floor = new Floor(status);
            assertFalse(floor.isSafe(input));
        }

        @DisplayName("동일하다.")
        @ParameterizedTest(name = "바닥: {0}, 검증값: {1}")
        @CsvSource(value = {"D:D", "U:U"}, delimiter = ':')
        void floorNotBroken(String status, String input) {
            Floor floor = new Floor(status);
            assertTrue(floor.isSafe(input));
        }

        @DisplayName("동일하지 않으며 검증값이 잘못되었다.")
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