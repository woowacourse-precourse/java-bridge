package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @DisplayName("생성자 인수로 숫자 변경이 안 되는 문자열에 대한 예외처리")
    @Test
    void 다리_생성(){
        Assertions.assertThatThrownBy(()->
                new Bridge("문자열")
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings ={"2","21"})
    @DisplayName("다리의 최대 최소 길이 범위 바깥에 있는")
    @Test
    void 다리_생성(String string){
        Assertions.assertThatThrownBy(()->
                new Bridge(string)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}