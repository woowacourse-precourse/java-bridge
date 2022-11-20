package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("바닥 테스트")
class FloorTest {

    @Nested
    @DisplayName("바닥 생성 테스트")
    class floorStatus {
        @DisplayName("바닥의 상태가 옳다.")
        @ParameterizedTest(name = "바닥의 상태는 U, D이다.")
        @CsvSource({"U", "D"})
        void goodStatus(String status) {
            assertDoesNotThrow(() -> {
                new Floor("U");
                new Floor("D");
            });
        }

        @DisplayName("바닥의 상태가 옳지 못하다")
        @ParameterizedTest(name = "바닥의 상태가 U, D가 아니라면 예외")
        @CsvSource({"A", "B", "1", "hello world"})
        void badStatus(String status) {
            assertThrows(IllegalArgumentException.class, () -> {
                new Floor(status);
            });
        }
    }

    @Nested
    @DisplayName("부숴지는 바닥인지 테스트")
    class floorBrokenTest {

        @DisplayName("바닥이 부숴진다")
        @ParameterizedTest(name = "바닥이 {0}이면 {1}일때 부숴진다.")
        @CsvSource(value = {"U:D", "D:U"}, delimiter = ':')
        void floorBroken(String status, String input) {
            Floor floor = new Floor(status);
            assertFalse(floor.isSafe(input));
        }

        @DisplayName("바닥이 안부숴진다.")
        @ParameterizedTest(name = "바닥이 {0}이면 {1}일때 안부숴진다.")
        @CsvSource(value = {"D:D", "U:U"}, delimiter = ':')
        void floorNotBroken(String status, String input) {
            Floor floor = new Floor(status);
            assertTrue(floor.isSafe(input));
        }

        @DisplayName("잘못된 입력")
        @ParameterizedTest(name = "입력한 상태가 U, D가 아니라면 예외")
        @CsvSource(value = {"D:ㅁㅇㄹㅁㄹ", "U:u", "D: 2", "U:Down"}, delimiter = ':')
        void badInput(String status, String input) {
            Floor floor = new Floor(status);
            assertThrows(IllegalArgumentException.class, () -> {
                floor.isSafe(input);
            });
        }
    }


}