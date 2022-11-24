package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    private final static int size = 20;

    @Test
    @DisplayName("U 을 입력했을 시 나올 수 있는 반환 값은 UP_O, UP_X로 한정되어있다")
    public void 다리_결과_데이터_반환확인_1() throws Exception {
        //given
        Bridge bridge = new Bridge(size);
        String up = "U";
        List<MoveStatus> status = List.of(MoveStatus.UP_O,MoveStatus.UP_X);
        //when then
        for(int i=0; i<size; i++){
            assertThat(status).contains(bridge.getStatus(i, up));
        }
    }

    @Test
    @DisplayName("D 을 입력했을 시 나올 수 있는 반환 값은 DOWN_O, DWON_X로 한정되어있다")
    public void 다리_결과_데이터_반환확인_2() throws Exception {
        //given
        Bridge bridge = new Bridge(size);
        String down = "D";
        List<MoveStatus> status = List.of(MoveStatus.DOWN_O,MoveStatus.DOWN_X);
        //when then
        for(int i=0; i<size; i++){
            assertThat(status).contains(bridge.getStatus(i, down));
        }
    }
}