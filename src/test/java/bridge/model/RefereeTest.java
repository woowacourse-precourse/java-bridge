package bridge.model;

import bridge.constant.Score;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.Score.FAIL;
import static bridge.constant.Score.PASS;
import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    Referee recordFirst;
    Referee recordSecond;
    Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U"));
        recordFirst = new Referee(bridge, 1);
        recordSecond = new Referee(bridge, 2);
    }

    @AfterEach
    void afterEach() {
        bridge = null;
        recordFirst = null;
        recordSecond = null;
    }

    @DisplayName("이동의 성공/실패 여부를 반환한다.")
    @Test
    void judgeMoveTest() {
        Score scoreFirst = recordFirst.judgeMove("D");
        Score scoreSecond = recordSecond.judgeMove("D");

        assertThat(scoreFirst).isEqualTo(FAIL);
        assertThat(scoreSecond).isEqualTo(PASS);
    }

    @DisplayName("이동이 실패하는 지 반환한다.")
    @Test
    void isFailTest() {
        Boolean isRecordFirstFail = recordFirst.isFail("D");
        Boolean isRecordSecondFail = recordSecond.isFail("D");

        assertThat(isRecordFirstFail).isTrue();
        assertThat(isRecordSecondFail).isFalse();
    }
}