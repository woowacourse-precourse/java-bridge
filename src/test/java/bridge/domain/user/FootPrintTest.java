package bridge.domain.user;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("현재까지 이동한 기록을 저장하는 기능 테스트")
class FootPrintTest {

    private FootPrint footPrint;

    private static Stream<Arguments> methodSourceForAddStepWithStatus() {
        return Stream.of(
                Arguments.of(User.ALIVE, "O"),
                Arguments.of(User.DEAD, "X")
        );
    }

    @BeforeEach()
    void 객체_생성() {
        footPrint = new FootPrint();
        assertThat(footPrint).isNotNull();
    }

    @DisplayName("유저 상태에 따른 FootPrint 저장")
    @ParameterizedTest
    @MethodSource("methodSourceForAddStepWithStatus")
    void addStepWithStatus(int status, String result) {
        footPrint.addStep(status);
        assertThat(footPrint.toString()).contains(result);
    }

    @DisplayName("FootPrint 초기화")
    @Test
    void clearFootPrint() {
        footPrint.addStep(User.ALIVE);
        footPrint.addStep(User.DEAD);
        footPrint.clear();
        assertThat(footPrint)
                .extracting("footPrint", as(InstanceOfAssertFactories.LIST))
                .hasSize(0);
    }

    @DisplayName("Foot Print toString 테스트")
    @Test
    void footPrintToStringTest() {
        footPrint.addStep(User.ALIVE);
        footPrint.addBlank();
        footPrint.addStep(User.DEAD);
        assertThat(footPrint.toString()).isEqualTo("[ O |   | X ]\n");
    }
}
