package bridge;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.util.Lists.newArrayList;

class OutputViewTest {

    OutputView outputView;
    BridgeGame bridgeGame;

    @BeforeEach
    void init(){
        outputView = new OutputView();
        bridgeGame = new BridgeGame(new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0)), 3);
    }


//    @Test
//    @DisplayName(value = "틀렸을때 출력이 잘 나오는가 확인")
//    void printMapTest2(){
//        assertSimpleTest(() -> {
//            bridgeGame.move("U");
//            bridgeGame.move("U");
//            assertThat(outputView.getMapLines(bridgeGame))
//                    .containsExactly("[   | X ]"
//                            , "[ O |   ]");
//        });
//    }
//
//    @Test
//    @DisplayName(value = "틀렸을때 출력이 잘 나오는가 확인")
//    void getResultLinesTest1(){
//        assertSimpleTest(() -> {
//            bridgeGame.move("U");
//            bridgeGame.move("U");
//            assertThat(outputView.getResultLines(bridgeGame))
//                    .containsExactly("최종 게임 결과"
//                            , "[   | X ]"
//                            , "[ O |   ]"
//                            , System.lineSeparator()
//                            , "게임 성공 여부: 실패"
//                            , "총 시도한 횟수: 1"
//                            );
//        });
//    }
//
//    @Test
//    @DisplayName(value = "리트라이 했을때도 잘되었는가 확인")
//    void getResultLinesTest2(){
//        assertSimpleTest(() -> {
//            bridgeGame.move("U");
//            bridgeGame.move("U");
//            bridgeGame.retry();
//            bridgeGame.move("D");
//            bridgeGame.move("D");
//            assertThat(outputView.getResultLines(bridgeGame))
//                    .containsExactly("최종 게임 결과"
//                            , "[   | O | O ]"
//                            , "[ O |   |   ]"
//                            , System.lineSeparator()
//                            , "게임 성공 여부: 성공"
//                            , "총 시도한 횟수: 2"
//                    );
//        });
//    }
}