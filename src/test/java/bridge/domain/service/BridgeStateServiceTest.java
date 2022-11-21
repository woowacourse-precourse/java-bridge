package bridge.domain.service;


import bridge.domain.resources.Move;
import bridge.domain.resources.bridge.Bridge;

import bridge.utils.parser.MoveInputParser;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeStateServiceTest {

    @Nested
    @DisplayName("BridgeStateService Class")
    class BridgeStateServiceKoTest {

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("check compare logic")
        class DescribeCompareLogic {

            @DisplayName("up or down")
            @ParameterizedTest(name = "{1}")
            @MethodSource("validParameters")
            void UpOrDown(String moveInput, String message, String outputOfBridge) {

                List<String> bridgeEx = List.of("U", "D", "D");
                Bridge bridge = new Bridge(bridgeEx);

                BridgeGame bridgeGame = new BridgeGame();
                Move move = MoveInputParser.parseMove(moveInput);
                bridgeGame.move(bridge, move);

                String output = bridgeGame.mapService();

                assertThat(output).isEqualTo(outputOfBridge);
            }

            Stream<Arguments> validParameters() {
                return Stream.of(
                    Arguments.of("U", "Up", "[ O ]\n[   ]"),
                    Arguments.of("D", "Down", "[   ]\n[ X ]")
                );
            }
        }
    }
}