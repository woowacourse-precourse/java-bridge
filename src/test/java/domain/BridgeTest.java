package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    private final static int size = 100;

    @Test
    @DisplayName("U 을 입력했을 시 나올 수 있는 반환 값은 UP_O, UP_X로 한정되어있다")
    public void 다리_결과_데이터_반환확인_1() throws Exception {
        //given
        Bridge bridge = new Bridge(size);
        String up = "U";

        //when
        for(int i=0; i<size; i++){
            bridge.commandResult(i, up);
        }
        List<MoveStatus> result = bridge.getResult();
        //then
        assertThat(result).contains(MoveStatus.UP_O, MoveStatus.UP_X);
    }

    @Test
    @DisplayName("D 을 입력했을 시 나올 수 있는 반환 값은 DOWN_O, DWON_X로 한정되어있다")
    public void 다리_결과_데이터_반환확인_2() throws Exception {
        //given
        Bridge bridge = new Bridge(size);
        String down = "D";

        //when
        for(int i=0; i<size; i++){
            bridge.commandResult(i, down);
        }
        List<MoveStatus> result = bridge.getResult();
        //then
        assertThat(result).contains(MoveStatus.DOWN_O, MoveStatus.DOWN_X);
    }

    @Test
    @DisplayName("결과 데이터 초기화시 크기는 0")
    public void 다리_결과_데이터_초기화() throws Exception {
        //given
        Bridge bridge = new Bridge(size);
        String down = "D";
        for(int i=0; i<size; i++){
            bridge.commandResult(i, down);
        }
        //when
        assertThat(bridge.getResult().size()).isEqualTo(100); // 초기화 전
        bridge.answerReset();

        //then
        assertThat(bridge.getResult().size()).isEqualTo(0); // 초기화 후
    }
}