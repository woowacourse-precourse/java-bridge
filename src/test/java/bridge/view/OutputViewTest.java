package bridge.view;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import bridge.BridgeMaker;
import bridge.TestNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeMove;
import bridge.domain.game.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    
    OutputView outputView;
    
    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }
    
    @Nested
    class PrintMapTest extends NsTest {
        
        BridgeGame bridgeGame;
        
        @BeforeEach
        void setUp() {
            List<BridgeMove> expectMoves = List.of(
                    BridgeMove.UP,
                    BridgeMove.UP,
                    BridgeMove.UP,
                    BridgeMove.DOWN
            );
            TestNumberGenerator testNumberGenerator = new TestNumberGenerator(
                    expectMoves.stream().map(BridgeMove::getGenerateNumber).collect(Collectors.toList()));
            Bridge bridge = new Bridge(new BridgeMaker(testNumberGenerator).makeBridge(expectMoves.size()));
            bridgeGame = new BridgeGame(bridge);
        }
        
        @DisplayName("이동 별로 성공했을 때는 O, 실패했을 때는 X, 선택되지 않았을 때는 공백, [와 ]로 감싸지고 |로 나누어 출력된다.")
        @Test
        void printFormat() {
            bridgeGame.move(BridgeMove.UP);
            bridgeGame.move(BridgeMove.UP);
            bridgeGame.fail(BridgeMove.DOWN);
            
            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "[ O | O |   ]",
                        "[   |   | X ]"
                );
            });
        }
        
        @DisplayName("UP 이동의 결과가 더 먼저 출력된다.")
        @Test
        void upSideFirst() {
            bridgeGame.move(BridgeMove.UP);
            bridgeGame.move(BridgeMove.UP);
            bridgeGame.move(BridgeMove.UP);
            bridgeGame.move(BridgeMove.DOWN);
            
            assertSimpleTest(() -> {
                run();
                
                int upSideIndex = output().indexOf("[ O | O | O |   ]");
                int downSideIndex = output().indexOf("[   |   |   | O ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            });
        }
        
        @DisplayName("현재까지 이동 시도한 길이까지만 출력된다.")
        @Test
        void printByCurrentTryCount() {
            bridgeGame.move(BridgeMove.UP);
            bridgeGame.fail(BridgeMove.UP);
            
            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "[ O | X ]",
                        "[   |   ]"
                );
            });
        }
        
        @Override
        protected void runMain() {
            outputView.printMap(bridgeGame);
        }
    }
}
