package bridge.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    private String MIN_ERROR_MESSAGE = "[ERROR] 다리의 최소 길이는 3이상 입니다.";
    private String MAX_ERROR_MESSAGE = "[ERROR] 다리의 최대 길이는 20 입니다.";

    @DisplayName("U와 D로 이루어진 다리 생성 테스트")
    @RepeatedTest(10)
    void U와_D로_생성하는_다리_테스트() {
        int size = Randoms.pickNumberInRange(3, 20);
        List<String> BridgeSource = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNum = Randoms.pickNumberInRange(0, 1);
            BridgeSource.add(Direction.getDirectionStringByNumber(randomNum));
        }
        assertThat(new Bridge(BridgeSource)).isInstanceOf(Bridge.class);
    }

    @DisplayName("U와 D로 외의 값으로 다리를 만들고자 할 때 발생하는 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "B", "hello", "hi"})
    void U와_D외의_값에서_발생하는_다리_생성_예외_테스트(String exceptionString) {
        int size = Randoms.pickNumberInRange(3, 19);
        List<String> BridgeSource = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNum = Randoms.pickNumberInRange(0, 1);
            BridgeSource.add(Direction.getDirectionStringByNumber(randomNum));
        }
        BridgeSource.add(exceptionString);
        assertThatThrownBy(() -> new Bridge(BridgeSource))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 방향으로 전환 될 수 없는 문자열의 입력 입니다.");
    }

    @DisplayName("다리의 길이가 3~20 사이가 아닐 경우 발생하는 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0,MIN_ERROR_MESSAGE", "1,MIN_ERROR_MESSAGE", "100,MAX_ERROR_MESSAGE", "30000,MAX_ERROR_MESSAGE"})
    void 다리_길이_값에서_발생하는_다리_생성_예외_테스트(int bridgeLength, String expectedErrorMsg) {
        List<String> BridgeSource = new ArrayList<>();
        String errorMsg = MIN_ERROR_MESSAGE;
        if (expectedErrorMsg.equals("MAX_ERROR_MESSAGE")) {
            errorMsg = MAX_ERROR_MESSAGE;
        }
        for (int i = 0; i < bridgeLength; i++) {
            int randomNum = Randoms.pickNumberInRange(0, 1);
            BridgeSource.add(Direction.getDirectionStringByNumber(randomNum));
        }
        assertThatThrownBy(() -> new Bridge(BridgeSource))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMsg);
    }

}
