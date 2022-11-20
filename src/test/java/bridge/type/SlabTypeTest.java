package bridge.type;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SlabTypeTest {
    @ParameterizedTest(name = "타입 생성 테스트")
    @MethodSource("타입_생성_데이터")
    void 타입_생성(int id, SlabType result) {
        assertThat(SlabType.build(id)).isEqualTo(result);
    }

    static Stream<Arguments> 타입_생성_데이터() {
        return Stream.of(
                Arguments.of(-2, SlabType.UNKNOWN),
                Arguments.of(-1, SlabType.UNKNOWN),
                Arguments.of(0, SlabType.DOWN),
                Arguments.of(1, SlabType.UP),
                Arguments.of(2, SlabType.UNKNOWN)
        );
    }

    @ParameterizedTest(name = "타입 이름 가져오기")
    @MethodSource("타입_이름_가져오기_데이터")
    void 타입_이름_가져오기(SlabType slabType, String result) {
        assertThat(slabType.getTypeName()).isEqualTo(result);
    }

    static Stream<Arguments> 타입_이름_가져오기_데이터() {
        return Stream.of(
                Arguments.of(SlabType.UNKNOWN, "N"),
                Arguments.of(SlabType.DOWN, "D"),
                Arguments.of(SlabType.UP, "U")
        );
    }

    @ParameterizedTest(name = "타입 아이디 가져오기")
    @MethodSource("타입_아이디_가져오기_데이터")
    void 타입_아이디_가져오기(SlabType slabType, int result) {
        assertThat(slabType.getId()).isEqualTo(result);
    }

    static Stream<Arguments> 타입_아이디_가져오기_데이터() {
        return Stream.of(
                Arguments.of(SlabType.UNKNOWN, -1),
                Arguments.of(SlabType.DOWN, 0),
                Arguments.of(SlabType.UP, 1)
        );
    }
}