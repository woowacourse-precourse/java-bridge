package bridge.domain;

import bridge.controller.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest{
    Bridge bridge;

    @BeforeEach
    void setup(){
        bridge=new Bridge(List.of("U", "D", "U"));
    }
    @Test
    @DisplayName("이동가능한 칸일 때 true를 반환하는지 확인")
    void getMoveResultTrue(){
        assertThat(bridge.getMoveResult("U")).isTrue();
    }
    @Test
    @DisplayName("이동 불가능한 칸일 때 false를 반환하는지 확인")
    void getMoveResultFalse(){
        assertThat(bridge.getMoveResult("D")).isFalse();
    }
}