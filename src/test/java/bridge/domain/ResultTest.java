package bridge.domain;

import bridge.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultTest {
    Result result;

    @BeforeEach
    void setup(){
        result=new Result();
    }
    @Test
    @DisplayName("moving이 U이고 결과가 X인 경우 저장된 값 확인")
    void addResult1(){
        result.addResult(Constants.MOVE_UP, Constants.WRONG);
        assertThat(result.getPlayResult().get(0)).isEqualTo(List.of("X"));
        assertThat(result.getPlayResult().get(1)).isEqualTo(List.of(" "));
    }
    @Test
    @DisplayName("moving이 D이고 결과가 O인 경우 저장된 값 확인")
    void addResult2(){
        result.addResult(Constants.MOVE_DOWN, Constants.CORRECT);
        assertThat(result.getPlayResult().get(0)).isEqualTo(List.of(" "));
        assertThat(result.getPlayResult().get(1)).isEqualTo(List.of("O"));
    }
}