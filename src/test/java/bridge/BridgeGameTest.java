package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

import bridge.ApplicationTest.TestNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest extends NsTest {
    @BeforeEach
    void 생성자() {
        BridgeGame bridgeGame = new BridgeGame();
    }

    @Test
    void 브릿지_리스트와_유저_인풋에_따른_게임_진행확인_맞췄을때(){

        run("D", "U", "U");
        assertThat(output()).contains(
                "D","U","U"
        );

    }

    @Test
    void 브릿지_리스트와_유저_인풋에_따른_게임_진행확인_틀렸을때(){

        run("D", "D", "R", "D", "U", "U");
        assertThat(output()).contains(
                "D","X","R","D", "U", "U"
        );

    }


    @Override
    protected void runMain() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of(new String[]{"D", "U", "U"}));

    }

}