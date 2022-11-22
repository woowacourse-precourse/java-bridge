package bridge;

import bridge.constant.BlockNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BlockNumberTest {
    @Test
    public void 숫자로_블럭넘버_가져옴() throws Exception {
        //given
        int number = 1;

        //when
        BlockNumber blockNumber = BlockNumber.findByNumber(number);

        //then
        assertThat(blockNumber).isEqualTo(BlockNumber.UPPER);
    }

    @Test
    public void 없는_숫자로_블럭넘버_가져옴() throws Exception {
        //given
        int number = 2;

        //when
        BlockNumber blockNumber = BlockNumber.findByNumber(number);

        //then
        assertThat(blockNumber).isEqualTo(BlockNumber.NONE);
    }
}