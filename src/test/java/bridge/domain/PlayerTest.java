package bridge.domain;

import bridge.constant.ErrorCode;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {
    private final List<BridgeShapeMatcher> bridgeShapeMatchers = new ArrayList<>();

    @BeforeEach
    void player_생성(){
        bridgeShapeMatchers.add(BridgeShapeMatcher.DOWN_TRUE);
        bridgeShapeMatchers.add(BridgeShapeMatcher.UP_TRUE);
        bridgeShapeMatchers.add(BridgeShapeMatcher.DOWN_FALSE);
        bridgeShapeMatchers.add(BridgeShapeMatcher.DOWN_TRUE);
    }

    @Test
    void 플레이어_입력_예외테스트1(){
        bridgeShapeMatchers.add(BridgeShapeMatcher.NONE);
        assertThatThrownBy(()-> new Player(bridgeShapeMatchers)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"X,true", "u,true","UU,false"})
    void 플레이어_입력_예외테스트2(String input, boolean isTrue){
        BridgeShapeMatcher bridgeShapeMatcher = BridgeShapeMatcher.findBridgeShape(input,isTrue);
        bridgeShapeMatchers.add(bridgeShapeMatcher);
        assertThatThrownBy(()-> new Player(bridgeShapeMatchers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어_이동거리_예외테스트(){
        for (int i = 0; i < 20; i++) {
            bridgeShapeMatchers.add(BridgeShapeMatcher.UP_TRUE);
        }
        assertThatThrownBy(()-> new Player(bridgeShapeMatchers)).isInstanceOf(IllegalArgumentException.class);
    }

}