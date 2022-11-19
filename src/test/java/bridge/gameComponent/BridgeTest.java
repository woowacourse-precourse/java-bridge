package bridge.gameComponent;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class BridgeTest {
    @Test
    void U_또는_D_이외의_입력인_경우() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D"));
        String upDown = "P";
        int index = 1;
        //when
        Throwable throwable = catchThrowable(() -> {
            bridge.isPossibleMove(index, upDown);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 비정상_index_입력인_경우() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D"));
        String upDown = "U";
        int index = 2;
        //when
        Throwable throwable = catchThrowable(() -> {
            bridge.isPossibleMove(index, upDown);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상인경우() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D"));
        String upDown = "U";
        int index = 0;
        //when
        boolean isPossibleMove = bridge.isPossibleMove(index, upDown);
        //then
        assertThat(isPossibleMove)
                .isTrue();
    }
}
