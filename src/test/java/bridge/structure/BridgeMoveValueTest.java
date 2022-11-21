package bridge.structure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMoveValueTest {

    @Test
    void 다리_방향_만들기_문자() throws Exception {
        //given
        String stringIdentifier = "U";
        //when
        BridgeMoveValue bridgeMoveValue = BridgeMoveValue.generate(stringIdentifier);

        //then
        Assertions.assertThat(bridgeMoveValue)
                .isEqualTo(BridgeMoveValue.UP);

    }

    @Test
    void 다리_방향_만들기_숫자() throws Exception {
        //given
        int numberIdentifier = 1;

        //when
        BridgeMoveValue bridgeMoveValue = BridgeMoveValue.generate(numberIdentifier);

        //then
        Assertions.assertThat(bridgeMoveValue)
                .isEqualTo(BridgeMoveValue.UP);

    }

    @Test
    void 다리_방향_만들기_문자_예외() throws Exception {
        //given
        String stringIdentifier = "X";
        //when

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgeMoveValue.generate(stringIdentifier));

    }

    @Test
    void 다리_방향_만들기_숫자_예외() throws Exception {
        //given
        int numberIdentifier = 3;

        //when

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgeMoveValue.generate(numberIdentifier));

    }

    @Test
    void 다리_방향_검증_예외() throws Exception {

        //given

        //when

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgeMoveValue.validateInput("X"));

    }
}