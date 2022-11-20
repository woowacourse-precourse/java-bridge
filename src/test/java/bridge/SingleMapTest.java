package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;


public class SingleMapTest extends NsTest {

    @Override
    protected void runMain() {
    }

    @DisplayName("결과의 정상적 치환 확인.")
    @Nested
    class successConvert {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "U"));

        @DisplayName("1칸 건너는것을 성공한 경우 테스트")
        @ParameterizedTest
        @CsvSource(value = {"U:O", "D:' '"}, delimiter = ':')
        public void printOneSuccess(String value, String expected) {
            bridgeGame.move("U");
            SingleMap singleMap = new SingleMap(bridgeGame, "U");
            assertThat(singleMap.convertToSingleMap(value))
                    .isEqualTo(expected);
        }

        @DisplayName("2칸 건너는것을 성공한 경우 테스트")
        @ParameterizedTest
        @CsvSource(value = {"U : 'O '", "D: ' O'"}, delimiter = ':')
        public void printTwoSuccess(String value, String expected) {
            bridgeGame.move("U");
            bridgeGame.move("D");
            SingleMap singleMap = new SingleMap(bridgeGame, "D");
            assertThat(singleMap.convertToSingleMap(value))
                    .isEqualTo(expected);
        }

        @DisplayName("1칸 건너는것을 실패한 경우 테스트")
        @ParameterizedTest
        @CsvSource(value = {"U:' '", "D:X"}, delimiter = ':')
        public void printOneMoveFail(String value,String expected) {
            bridgeGame.move("D");
            SingleMap singleMap = new SingleMap(bridgeGame, "D");
            assertThat(singleMap.convertToSingleMap(value))
                    .isEqualTo(expected);
        }

        @DisplayName("2칸 건너는것을 실패한 경우 테스트")
        @ParameterizedTest
        @CsvSource(value = {"U : 'OX'", "D: '  '"}, delimiter = ':')
        public void printTwoMoveFail(String value, String expected) {
            bridgeGame.move("U");
            bridgeGame.move("U");
            SingleMap singleMap = new SingleMap(bridgeGame, "U");
            assertThat(singleMap.convertToSingleMap(value))
                    .isEqualTo(expected);
        }

        @DisplayName("전부 건너는것을 성공한 경우 테스트")
        @ParameterizedTest
        @CsvSource(value = {"U:'O O'", "D:' O '"}, delimiter = ':')
        public void printAllSuccess(String value, String expected) {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("U");
            SingleMap singleMap = new SingleMap(bridgeGame, "U");
            assertThat(singleMap.convertToSingleMap(value))
                    .isEqualTo(expected);
        }

    }

}

