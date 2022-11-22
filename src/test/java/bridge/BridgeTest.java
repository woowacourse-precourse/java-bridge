package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {

    @DisplayName("사용자 이동 알파벳이 U 또는 D 가 아니면 에러 발생")
    @Test
    void 사용자_이동_테스트(){
        assertThatThrownBy(()-> new InputView().MoveCheck("F"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("게임이 끝났을 때 입력 알파벳이 R 또는 Q 가 아니면 에러 발생")
    @Test
    void 게임_종료_재실행_테스트(){
        assertThatThrownBy(()-> new InputView().checkRegameException("F"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 크기 입력이 3이상 20이하가 아니면 에러 발생")
    @Test
    void 게임_크기_테스트(){
        assertThatThrownBy(()-> new InputView().checkSize(21))
                .isInstanceOf(IllegalArgumentException.class);
    }




}
