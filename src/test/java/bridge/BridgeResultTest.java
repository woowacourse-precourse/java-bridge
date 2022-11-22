package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeResultTest {

    BridgeResult bridgeResult = new BridgeResult();

    @Test
    void O_혹은_X_결과값_넣기() {
        //given
        bridgeResult.add("O");
        bridgeResult.add("X");
        bridgeResult.add("O");

        //when
        List<String> bridgeResult = this.bridgeResult.getBridgeResult();

        //then
        Assertions.assertThat(bridgeResult).isEqualTo(Arrays.asList("O", "X", "O"));
    }

    @Test
    void 공백_및_O_혹은_X_결과값_넣기() {
        //given
        bridgeResult.add(" ");
        bridgeResult.add("O");
        bridgeResult.add("X");

        //when
        List<String> bridgeResult = this.bridgeResult.getBridgeResult();

        //then
        Assertions.assertThat(bridgeResult).isEqualTo(Arrays.asList(" ", "O", "X"));
    }

    @Test
    void X가_나올_경우_마지막_결과값_되돌리기() {
        //given
        bridgeResult.add("O");
        bridgeResult.add("O");
        bridgeResult.add("X");
        bridgeResult.revert();

        //when
        List<String> bridgeResult = this.bridgeResult.getBridgeResult();

        //then
        Assertions.assertThat(bridgeResult).isEqualTo(Arrays.asList("O", "O"));
    }

    @Test
    void 출력을_위해_포맷팅_작업() {
        //given
        bridgeResult.add(" ");
        bridgeResult.add("O");
        bridgeResult.add("O");

        //then
        Assertions.assertThat(bridgeResult.toString()).isEqualTo("   | O | O ");
    }
}