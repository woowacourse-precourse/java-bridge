package bridge.view;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import bridge.BridgeMaker;
import bridge.TestNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeMove;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeGameStatus;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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
    
    @Nested
    class PrintResultTest extends NsTest {
        
        BridgeGame bridgeGame;
        
        @BeforeEach
        void setUp() {
            List<BridgeMove> expectMoves = List.of(
                    BridgeMove.DOWN,
                    BridgeMove.DOWN,
                    BridgeMove.DOWN,
                    BridgeMove.UP
            );
            TestNumberGenerator testNumberGenerator = new TestNumberGenerator(
                    expectMoves.stream().map(BridgeMove::getGenerateNumber).collect(Collectors.toList()));
            Bridge bridge = new Bridge(new BridgeMaker(testNumberGenerator).makeBridge(expectMoves.size()));
            bridgeGame = new BridgeGame(bridge);
        }
        
        @DisplayName("시도한 경우 중 가장 멀리간 결과를 최종 결과로 출력한다.")
        @Test
        void printByBestRecord() {
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.fail(BridgeMove.UP);
            
            bridgeGame.retry();
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.move(BridgeMove.DOWN);
            
            bridgeGame.retry();
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.fail(BridgeMove.UP);
            
            bridgeGame.setStatus(BridgeGameStatus.FAILURE);
            
            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[   |   |   |   ]",
                        "[ O | O | O | O ]",
                        "게임 성공 여부: 실패"
                );
            });
        }
        
        
        // 방향이 더 추가 되었을 때를 고려함
        @DisplayName("시도한 경우 중 이동에 성공한 거리가 같은 경우 최근의 결과를 출력한다.")
        @Test
        void printByRecentlyRecord() {
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.fail(BridgeMove.UP);
            
            bridgeGame.retry();
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.move(BridgeMove.DOWN);
            bridgeGame.fail(BridgeMove.DOWN);
            
            bridgeGame.setStatus(BridgeGameStatus.FAILURE);
            
            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[   |   |   ]",
                        "[ O | O | X ]",
                        "게임 성공 여부: 실패"
                );
            });
        }
        
        
        @DisplayName("게임 상태 별로 게임 결과 여부를 출력한다.")
        @EnumSource(BridgeGameStatus.class)
        @ParameterizedTest
        void printByGameStatus(BridgeGameStatus status) {
            bridgeGame.setStatus(status);
            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "게임 성공 여부:",
                        status.getOutputText()
                );
            });
        }
        
        @Override
        protected void runMain() {
            outputView.printResult(bridgeGame);
        }
    }
}
