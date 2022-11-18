package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;


public class Test_Personal extends NsTest{
    @Test
    void numToStr_test(){
        NumberShape numberShape = new NumberToString();
        String answer = numberShape.numToUpDown(1);
        assertThat(answer).isEqualTo("U");

        answer = numberShape.numToUpDown(0);
        assertThat(answer).isEqualTo("D");
    }


    @Override
    protected void runMain() {

    }
}
