package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.Signature;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
public class OutputViewTest extends NsTest {

    OutputView outputView=new OutputView();
    @Override
    protected void runMain(){}

    @DisplayName("입력받은 singleMap이 출력양식에 따라 출력되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"O O:'[ O |   | O ]'","'OX':[ O | X ]","O:'[ O ]'","OOO:[ O | O | O ]"},delimiter = ':')
    public void success(String value,String expected){
        outputView.printMap(value);
        assertThat(output()).contains(expected);
    }

    @DisplayName("최종 결과가 출력양식에 따라 출력되는지 확인")
    @Nested
    class printResult {
        BridgeGame bridgeGame=new BridgeGame(Arrays.asList("U", "D", "U"));
        @DisplayName("최종 결과가 성공인 경우")
        @Test
        public void resultSuccess() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("U");
            SingleMap singleMap=new SingleMap(bridgeGame,"U");
            outputView.printResult(singleMap);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }

        @DisplayName("최종 결과가 성공인 경우")
        @Test
        public void resultFail() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            SingleMap singleMap=new SingleMap(bridgeGame,"U");
            outputView.printResult(singleMap);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }
    }
}
