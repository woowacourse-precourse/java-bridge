package bridge;


import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest extends NsTest {
    @BeforeEach
    void 생성자() {
        BridgeGame bridgeGame = new BridgeGame();
    }

    @Test
    void 브릿지_리스트와_유저_인풋에_따른_게임_진행확인_맞췄을때() {

        run("D", "U", "U");
        assertThat(output()).contains(
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[   ]\n[ O ]",
                "[   | O ]\n[ O |   ]",
                "[   | O | O ]\n[ O |   |   ]"

        );

    }

    @Test
    void 브릿지_리스트와_유저_인풋에_따른_게임_진행확인_틀렸을때() {

        run("D", "D", "R", "D", "U", "U");
        assertThat(output()).contains(
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[   ]\n[ O ]",
                "[   |   ]\n[ O | X ]",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[   ]\n[ O ]",
                "[   | O ]\n[ O |   ]",
                "[   | O | O ]\n[ O |   |   ]"
        );/**
         contain말고 다른 걸로 테스트하자
         */

    }


    @Override
    protected void runMain() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("D",1);

    }

}