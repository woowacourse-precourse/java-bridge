package bridge.domain.pedestrian;

import bridge.domain.direction.Direction;
import bridge.domain.movingrecord.MovingRecord;
import bridge.domain.referee.Judgement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PedestrianTest {

    private Pedestrian pedestrian;

    @BeforeEach
    void setUp() {
        pedestrian = new Pedestrian();
    }

    @DisplayName("move 메소드에 판정, 방향이 입력되었을 때 멤버변수 movingRecord 에 저장하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForMoveTest")
    void move_test(Judgement judgement, Direction direction, String inputJudgement, String inputDirection) {
        pedestrian.move(judgement, direction);

        assertThat(pedestrian.toString()).contains(inputJudgement, inputDirection);
    }

    @DisplayName("findLocation 메소드를 호출하였을 때 움직인 횟수와 같은 위치 값을 반환하는지 확인")
    @ParameterizedTest(name = "{index} findLocation 메소드, 전체 자료 길이 반환")
    @MethodSource("provideArgumentsForMovingSeveralTimes")
    void findLocation_test(List<Judgement> judgements, List<Direction> directions) {
        Pedestrian pedestrian = moveSeveralTimes(judgements, directions);
        int expectedLocation = judgements.size();

        int actualLocation = pedestrian.findLocation();

        assertThat(actualLocation).isEqualTo(expectedLocation);
    }

    @DisplayName("returnToStartPoint 메소드를 호출하였을 때 위치가 시작 위치로 변하는지 확인")
    @ParameterizedTest(name = "{index} clearRecord 메소드, 자료를 비움")
    @MethodSource("provideArgumentsForMovingSeveralTimes")
    void returnToStartPoint_test(List<Judgement> judgements, List<Direction> directions) {
        int startLocation = pedestrian.findLocation();
        Pedestrian pedestrian = moveSeveralTimes(judgements, directions);

        pedestrian.returnToStartPoint();
        int returnedLocation = pedestrian.findLocation();

        assertThat(returnedLocation).isEqualTo(startLocation);
    }

    @DisplayName("hasIncorrectDirection 메소드를 호출하였을 때 false 판정 존재 여부를 확인해서 반환하는지 확인")
    @ParameterizedTest(name = "{index} hasIncorrectDirection 메소드, false 판정 존재 확인")
    @MethodSource("provideArgumentsForMovingSeveralTimes")
    void hasIncorrectDirection_test(List<Judgement> judgements, List<Direction> directions, boolean expectedValue) {
        Pedestrian pedestrian = moveSeveralTimes(judgements, directions);

        boolean actualValue = pedestrian.hasIncorrectDirection();

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @DisplayName("createMovingRecord 메소드를 호출하였을 때 MovingRecord 객체를 반환하는지 확인")
    @ParameterizedTest(name = "{index} read 메소드, MovingRecord 객체 반환 확인")
    @MethodSource("provideArgumentsForMovingSeveralTimes")
    void createMovingRecord_test(List<Judgement> judgements, List<Direction> directions) {
        Pedestrian pedestrian = moveSeveralTimes(judgements, directions);

        MovingRecord record = pedestrian.createMovingRecord();

        assertThat(record).isInstanceOf(MovingRecord.class);
    }

    private Pedestrian moveSeveralTimes(List<Judgement> judgements, List<Direction> directions) {
        for (int i = 0; i < judgements.size(); i++) {
            Judgement judgement = judgements.get(i);
            Direction direction = directions.get(i);

            pedestrian.move(judgement, direction);
        }
        return pedestrian;
    }

    static Stream<Arguments> provideArgumentsForMoveTest() {
        return Stream.of(
                Arguments.of(new Judgement(true), new Direction("U"), "true", "\"U\""),
                Arguments.of(new Judgement(true), new Direction("D"), "true", "\"D\""),
                Arguments.of(new Judgement(false), new Direction("U"), "false", "\"U\""),
                Arguments.of(new Judgement(false), new Direction("D"), "false", "\"D\"")
        );
    }

    static Stream<Arguments> provideArgumentsForMovingSeveralTimes() {
        return Stream.of(
                Arguments.of(List.of(new Judgement(true),
                                new Judgement(true),
                                new Judgement(false),
                                new Judgement(false),
                                new Judgement(false)),
                        List.of(new Direction("U"),
                                new Direction("D"),
                                new Direction("U"),
                                new Direction("U"),
                                new Direction("D")), true),
                Arguments.of(List.of(new Judgement(false),
                                new Judgement(true),
                                new Judgement(false)),
                        List.of(new Direction("U"),
                                new Direction("U"),
                                new Direction("D")), true),
                Arguments.of(List.of(new Judgement(true),
                                new Judgement(true),
                                new Judgement(true),
                                new Judgement(true),
                                new Judgement(true),
                                new Judgement(true)),
                        List.of(new Direction("D"),
                                new Direction("U"),
                                new Direction("D"),
                                new Direction("U"),
                                new Direction("U"),
                                new Direction("D")), false)
        );
    }
}