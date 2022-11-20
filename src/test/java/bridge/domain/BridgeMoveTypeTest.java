package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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

    static Stream<Arguments> whenIntTypeSearchThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(0, "D"),
                Arguments.arguments(1, "U")
        );
    }
}