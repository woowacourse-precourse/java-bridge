package bridge.gameComponent;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class BridgeTest {
    @Test
    void 정상인경우() {
        //given
        Bridge bridge = Bridge.of(List.of("U", "D"));
        String upDown = "U";
        int index = 0;
        //when
        boolean isPossibleMove = bridge.isPossibleMove(index, upDown);
        //then
        assertThat(isPossibleMove)
                .isTrue();
    }

    @Test
    void U또는D로_이뤄지지_않는_다리_생성_테스트() {
        //given
        String space1 = "T";
        String space2 = "D";
        String space3 = "D";
        //when
        Throwable throwable = catchThrowable(() -> {
            Bridge bridge = Bridge.of(List.of(space1, space2, space3));
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_0인_다리_생성_테스트() {
        //given
        //when
        Throwable throwable = catchThrowable(() -> {
            Bridge bridge = Bridge.of(List.of());
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_다리_생성_테스트() {
        //given
        String space1 = "U";
        String space2 = "D";
        String space3 = "D";
        //when
        Bridge bridge = Bridge.of(List.of(space1, space2, space3));

        //then
        assertThat(bridge.getBridge())
                .containsExactly("U", "D", "D");
    }
}
