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
    Referee recordFinal;
    Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U"));
        recordFirst = new Referee(bridge);
        recordFirst.addCurrentRoundNumber();

        recordSecond = new Referee(bridge);
        recordFirst.addCurrentRoundNumber();
        recordFirst.addCurrentRoundNumber();
    }

    @AfterEach
    void afterEach() {
        bridge = null;
        recordFirst = null;
        recordSecond = null;
        recordFinal = null;
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

    @DisplayName("다리의 마지막 라운드가 통과했는지 확인한다.")
    @Test
    void isFinalRoundPassTest() {
        Boolean finalPass = recordFinal.isFinalRoundPass("U");
        Boolean finalFail = recordFinal.isFinalRoundPass("D");

        assertThat(finalPass).isEqualTo(true);
        assertThat(finalFail).isEqualTo(false);
    }
}