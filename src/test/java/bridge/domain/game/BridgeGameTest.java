package bridge.domain.game;

import bridge.domain.direction.Direction;
import bridge.domain.factory.BridgeGameFactory;
import bridge.domain.pedestrian.Pedestrian;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private static final int FIRST_ROUND = 1;
    private static final int STARTING_POINT = 0;
    private static final int EXAMPLE_SIZE = 5;
    private BridgeGame game;
    private Pedestrian pedestrian;

    @BeforeEach
    void setUp() {
        BridgeGameFactory bridgeGameFactory = new BridgeGameFactory();
        pedestrian = new Pedestrian();
        game = bridgeGameFactory.createBridgeGame(EXAMPLE_SIZE);
    }

    @DisplayName("move 메소드에 방향을 입력하였을 때 Pedestrian의 위치가 변하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForMoveTest")
    void move_test(List<String> inputDirections) {
        List<Direction> directions = createDirections(inputDirections);
        int expectedLocation = directions.size();

        moveInManyDirections(game, directions);

        assertThat(pedestrian.findLocation()).isEqualTo(expectedLocation);
    }

    @DisplayName("retry 메소드에 Pedestrian 객체를 입력하였을 때 Pedestrian이 시작점의 위치를 갖는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForMoveTest")
    void retry_test(List<String> inputDirections) {
        List<Direction> directions = createDirections(inputDirections);
        moveInManyDirections(game, directions);

        game.retry(pedestrian);

        assertThat(pedestrian.findLocation()).isEqualTo(STARTING_POINT);
    }


    private void moveInManyDirections(BridgeGame game, List<Direction> directions) {
        for (Direction direction : directions) {
            game.move(pedestrian, direction);
        }
    }

    private List<Direction> createDirections(List<String> userInputs) {
        return userInputs.stream()
                .map(Direction::new)
                .collect(Collectors.toList());
    }

    @DisplayName("createRound 메소드가 게임 라운드를 담은 Round 객체를 반환하는지 확인")
    @ParameterizedTest(name = "{index} : 시도횟수 {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void createRound_test(int times) {
        retryGameMultiple(times);
        Round round = game.createRound();
        int expectedRound = times + FIRST_ROUND;

        int actualRound = round.getGameRound();

        assertThat(actualRound).isEqualTo(expectedRound);
    }

    private void retryGameMultiple(int times) {
        for (int i = 0; i < times; i++) {
            game.retry(pedestrian);
        }
    }

    @DisplayName("isEndLocation 메소드에 Pedestrian 객체를 입력하였을 때 Pedestrian가 다리 끝에 위치했는지 여부를 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForIsSuccessTest")
    void isEndLocation_test(List<String> inputDirections, boolean expected) {
        List<Direction> directions = createDirections(inputDirections);
        moveInManyDirections(game, directions);

        boolean actual = game.isEndLocation(pedestrian);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideArgumentsForMoveTest() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "D", "U", "D")),
                Arguments.of(List.of("U", "D", "D", "U", "U")),
                Arguments.of(List.of("U", "U", "U", "U", "U")),
                Arguments.of(List.of("D", "D", "D", "D", "D"))
        );
    }

    static Stream<Arguments> provideArgumentsForIsSuccessTest() {
        return Stream.of(
                Arguments.of(List.of("U"), false),
                Arguments.of(List.of("U", "D"), false),
                Arguments.of(List.of("U", "U", "U"), false),
                Arguments.of(List.of("U", "U", "U", "D"), false),
                Arguments.of(List.of("D", "D", "D", "D", "D"), true)
        );
    }
}