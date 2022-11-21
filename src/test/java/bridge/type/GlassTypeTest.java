package bridge.type;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GlassTypeTest {

    @ParameterizedTest(name = "타입 이름 로드")
    @MethodSource("타입_이름_로드_데이터")
    void 타입_이름_로드(GlassType glassType, String result) {
        assertThat(glassType.getTypeName()).isEqualTo(result);
    }

    static Stream<Arguments> 타입_이름_로드_데이터() {
        return Stream.of(
                Arguments.of(GlassType.TEMPERED, "O"),
                Arguments.of(GlassType.NORMAL, "X")
        );
    }

    @ParameterizedTest(name = "안전 여부 확인")
    @MethodSource("안전_여부_확인_데이터")
    void 안전_여부_확인(GlassType glassType, boolean result) {
        assertThat(glassType.isSafe()).isEqualTo(result);
    }

    static Stream<Arguments> 안전_여부_확인_데이터() {
        return Stream.of(
                Arguments.of(GlassType.TEMPERED, true),
                Arguments.of(GlassType.NORMAL, false)
        );
    }
}