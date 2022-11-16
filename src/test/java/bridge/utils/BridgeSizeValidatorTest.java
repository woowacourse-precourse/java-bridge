package bridge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeSizeValidatorTest {

    @DisplayName("다리 크기가 3미만일 때 예외 처리 발생 테스트")
    @ValueSource(strings={"2","0"})
    @ParameterizedTest
    void checkBridgeSize1(String input) {
        assertThatThrownBy(()->BridgeSizeValidator.checkBridgeSize(input));
    }

    @DisplayName("다리 크기가 20초과일 때 예외 처리 발생 테스트")
    @ValueSource(strings={"21","10000"})
    @ParameterizedTest
    void checkBridgeSize2(String input) {
        assertThatThrownBy(()->BridgeSizeValidator.checkBridgeSize(input));
    }

    @DisplayName("다리 크기 입력받을 때 숫자 아닌 값을 받으면 예외처리 발생 테스트")
    @ValueSource(strings={"1a","11b","b"})
    @ParameterizedTest
    void checkBridgeSize3(String input) {
        assertThatThrownBy(()->BridgeSizeValidator.checkBridgeSize(input));
    }
}