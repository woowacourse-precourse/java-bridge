package bridge.model.domains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

class RemainingStepsTest {

    @DisplayName("잘못된 인자값으로 다리 생성 시 예외 발생(null)")
    @Test
    void createBridgeWithIllegalArgument() {
        assertThatThrownBy(() -> new RemainingSteps(null))
                .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("잘못된 인자값으로 다리 생성 시 예외 발생(범위 밖 길이, 잘못된 칸 정보)")
    @ParameterizedTest
    @MethodSource("generateIllegalArgumentSteam")
    void createBridgeWithIllegalArgument(List<String> bridge) {
        assertThatThrownBy(() -> new RemainingSteps(bridge))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<String>> generateIllegalArgumentSteam() {
        List<List<String>> arguments = new LinkedList<>();
        arguments.add(newArrayList());
        arguments.add(newArrayList("U", "U"));
        arguments.add(newArrayList(
                "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U"
        ));
        arguments.add(newArrayList(null, "U", "D"));
        arguments.add(newArrayList("A", "U", "D"));
        arguments.add(newArrayList("A", "B", "C"));
        arguments.add(newArrayList("U", "A", "D"));
        return arguments.stream();
    }

    @DisplayName("현재 선택한 칸의 성공 여부를 확인한 뒤 해당 칸 정보를 삭제")
    @Test
    void checkAllStepsForBridge() {
        RemainingSteps remainingSteps = new RemainingSteps(newArrayList("U", "D", "U"));
        assertThat(remainingSteps.isMovableStep("U")).isTrue();
        assertThat(remainingSteps.isMovableStep("D")).isTrue();
        assertThat(remainingSteps.isMovableStep("D")).isFalse();
    }

    @DisplayName("더 이상 확인할 다리의 칸이 없는 경우 예외 발생")
    @Test
    void checkIsMovableStepWithEmptyStack() {
        RemainingSteps remainingSteps = new RemainingSteps(newArrayList("U", "D", "U"));
        // TODO 추후 다른 기능에 필요한 초기화 메소드 구현 후 리팩토링
        remainingSteps.isMovableStep("U");
        remainingSteps.isMovableStep("D");
        remainingSteps.isMovableStep("U");
        assertThatThrownBy(() -> remainingSteps.isMovableStep("U"))
                .isInstanceOf(IllegalStateException.class);
    }

}