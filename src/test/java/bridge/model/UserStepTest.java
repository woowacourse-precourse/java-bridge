package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserStepTest {

    UserStep userStep;

    @BeforeEach
    void setUp(){
        this.userStep = new UserStep();
    }

    @DisplayName("UserStep 객체생성테스트")
    @Test
    void makeUserStep(){
        assertThat(new UserStep()).isEqualTo(new UserStep());
    }

    @DisplayName("유저가 선택한 다리로 지나갈 수 있다.")
    @Test
    void CanGo() {
        assertTrue(userStep.goOneStep(new Bridge(List.of("U", "D", "D")), "U"));
    }

    @DisplayName("유저가 선택한 다리로 지나갈 수 없다.")
    @Test
    void CanNotGo() {
        assertFalse(userStep.goOneStep(new Bridge(List.of("U", "D", "D")), "D"));
    }

    @DisplayName("유저가 다리를 건넜으면 true를 리턴한다.")
    @Test
    void isCrossing() {
        assertTrue(new UserStep(List.of("U", "D", "D")).isCrossing(new Bridge(List.of("U", "D", "D"))));
    }

    @DisplayName("유저가 다리를 건넜으면 false를 리턴한다.")
    @Test
    void isNotCrossing() {
        assertFalse(new UserStep(List.of("U", "D")).isCrossing(new Bridge(List.of("U", "D", "D"))));
    }

    @DisplayName("게임을 재시작하면 지나간 정보가 초기화된다.")
    @Test
    void initUserStep(){
        assertThat(new UserStep(List.of("U", "D")).setInit()).isEqualTo(new UserStep());
    }


}