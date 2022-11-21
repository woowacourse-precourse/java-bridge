package bridge.type;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTypeTest {
    @ParameterizedTest(name = "타입 생성 테스트")
    @MethodSource("타입_생성_데이터")
    void 타입_생성(int id, PositionType result) {
        assertThat(PositionType.build(id)).isEqualTo(result);
    }

    static Stream<Arguments> 타입_생성_데이터() {
        return Stream.of(
                Arguments.of(-2, PositionType.UNKNOWN),
                Arguments.of(-1, PositionType.UNKNOWN),
                Arguments.of(0, PositionType.DOWN),
                Arguments.of(1, PositionType.UP),
                Arguments.of(2, PositionType.UNKNOWN)
        );
    }

    @ParameterizedTest(name = "타입 이름 로드")
    @MethodSource("타입_이름_로드_데이터")
    void 타입_이름_로드(PositionType positionType, String result) {
        assertThat(positionType.getTypeName()).isEqualTo(result);
    }

    static Stream<Arguments> 타입_이름_로드_데이터() {
        return Stream.of(
                Arguments.of(PositionType.UNKNOWN, "N"),
                Arguments.of(PositionType.DOWN, "D"),
                Arguments.of(PositionType.UP, "U")
        );
    }

    @ParameterizedTest(name = "타입 아이디 로드")
    @MethodSource("타입_아이디_로드_데이터")
    void 타입_아이디_로드(PositionType positionType, int result) {
        assertThat(positionType.getId()).isEqualTo(result);
    }

    static Stream<Arguments> 타입_아이디_로드_데이터() {
        return Stream.of(
                Arguments.of(PositionType.UNKNOWN, -1),
                Arguments.of(PositionType.DOWN, 0),
                Arguments.of(PositionType.UP, 1)
        );
    }
}