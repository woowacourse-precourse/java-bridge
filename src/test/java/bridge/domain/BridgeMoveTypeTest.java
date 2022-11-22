package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static bridge.domain.BridgeMoveType.DOWN;
import static bridge.domain.BridgeMoveType.UP;
import static bridge.exception.BridgeTypeExceptionMessage.READ_WRONG_TYPE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BridgeMoveTypeTest {

    @ParameterizedTest(name = "[{index}] moveTypeCode = {0}, moveType = {1}")
    @MethodSource("whenIntTypeSearchThenSuccessDummy")
    @DisplayName("입력된 int 타입의 다리 이동 코드를 이용하여 다리 이동 타입 검색을 성공한다.")
    void whenIntTypeSearchThenSuccessTest(int moveTypeCode, String moveType) {
        // given & when
        String findMoveType = BridgeMoveType.of(moveTypeCode);

        // then
        assertThat(findMoveType).isEqualTo(moveType);
    }

    @ParameterizedTest(name = "[{index}] moveType = {0}, bridgeMoveType = {1}")
    @MethodSource("whenStringTypeSearchThenSuccessDummy")
    @DisplayName("입력된 String 타입의 다리 이동 코드를 이용하여 다리 이동 타입 검색을 성공한다.")
    void whenStringTypeSearchThenSuccessTest(String moveType, BridgeMoveType bridgeMoveType) {
        // given & when
        BridgeMoveType findMoveType = BridgeMoveType.of(moveType);

        // then
        assertThat(findMoveType).isEqualTo(bridgeMoveType);
    }

    @ParameterizedTest(name = "[{index}] moveTypeCode = {0}")
    @ValueSource(ints = {-10000000, -10, -1, 2, 3, 4, 100, 100000000})
    @DisplayName("잘못 입력된 int 타입의 다리 이동 코드를 이용하여 다리 이동 타입 검색을 실패하여 예외처리 된다.")
    void whenWrongIntTypeSearchThenExceptionTest(int moveTypeCode) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BridgeMoveType.of(moveTypeCode))
                .withMessage(READ_WRONG_TYPE_EXCEPTION.getMessage());
    }

    @ParameterizedTest(name = "[{index}] moveTypeCode = {0}")
    @ValueSource(strings = {"A", "B", "C", "!", "@", "#", "$", "%", " ", "", "asd", "UU", "UD", "DD", "UDU"})
    @DisplayName("잘못 입력된 String 타입의 다리 이동 코드를 이용하여 다리 이동 타입 검색을 실패하여 예외처리 된다.")
    void whenWrongStringTypeSearchThenExceptionTest(String moveType) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BridgeMoveType.of(moveType))
                .withMessage(READ_WRONG_TYPE_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("잘못 입력된 null를 이용하여 다리 이동 타입 검색에 실패하여 예외처리 된다.")
    void whenNullSearchThenExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BridgeMoveType.of(null))
                .withMessage(READ_WRONG_TYPE_EXCEPTION.getMessage());
    }

    @ParameterizedTest(name = "[{index}] moveTypeOne = {0}, moveTypeTwo = {1}")
    @MethodSource("whenCompareSameMoveTypeThenSuccessDummy")
    @DisplayName("동일한 두 다리 이동 타입 비교시 동일하다는 결과로 성공한다.")
    void whenCompareSameMoveTypeThenSuccessTest(BridgeMoveType moveTypeOne, BridgeMoveType moveTypeTwo) {
        // given & when
        boolean isMoveTypeSame = moveTypeOne.isSame(moveTypeTwo);

        // then
        assertThat(isMoveTypeSame).isTrue();
    }

    @ParameterizedTest(name = "[{index}] moveTypeOne = {0}, moveTypeTwo = {1}")
    @MethodSource("whenCompareDifferentMoveTypeThenSuccessTest")
    @DisplayName("서로 다른 두 다리 이동 타입 비교시 동일하지 않다는 결과로 실패한다.")
    void whenCompareDifferentMoveTypeThenSuccessTest(BridgeMoveType moveTypeOne, BridgeMoveType moveTypeTwo) {
        // given & when
        boolean isMoveTypeSame = moveTypeOne.isSame(moveTypeTwo);

        // then
        assertThat(isMoveTypeSame).isFalse();
    }

    @ParameterizedTest(name = "[{index}] moveType = {0}")
    @ValueSource(strings = {"Q", "R", "", " ", "1", "A", "ㅕ"})
    @DisplayName("잘못된 입력값을 통한 이동 타입 존재 확인에 실패한다.")
    void whenWrongMoveTypeExistsThenFailTest(String moveType) {
        // given & when
        boolean moveTypeExists = BridgeMoveType.isMoveTypeExists(moveType);
        // then
        assertThat(moveTypeExists).isFalse();
    }

    static Stream<Arguments> whenIntTypeSearchThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(0, "D"),
                Arguments.arguments(1, "U")
        );
    }

    static Stream<Arguments> whenStringTypeSearchThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("D", DOWN),
                Arguments.arguments("U", UP)
        );
    }

    static Stream<Arguments> whenCompareSameMoveTypeThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(UP, UP),
                Arguments.arguments(DOWN, DOWN)
        );
    }

    static Stream<Arguments> whenCompareDifferentMoveTypeThenSuccessTest() {
        return Stream.of(
                Arguments.arguments(UP, DOWN),
                Arguments.arguments(DOWN, UP)
        );
    }
}