package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ErrorMessage;

class BridgeTest {

    @DisplayName("[Bridge] 다리 길이의 입력값이 범위내 없는경우 예외발생")
    @ParameterizedTest
    @ValueSource(ints = {2, -1, 132, 21})
    void notCorrectBridgeSize(int size) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Bridge(size))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_RANGE_BRIDGE_SIZE);
    }

    @DisplayName("[Bridge] 다리 길이의 입력값이 정상 범위인경우")
    @ParameterizedTest
    @ValueSource(ints = {3, 14, 20})
    void correctBridgeSize(int size) {
        //given
        //when
        //then
        assertDoesNotThrow(() -> new Bridge(size));
    }
}