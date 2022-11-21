package bridge.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
[X] 목적지를 주면 캐릭터가 다음 목적지를 알고 결과를 저장하고 움직이는 테스트 : move(String destination)
[X] 다음 움직임 저장 : saveNextMove()
[X] 캐릭터가 다음 목적지로 이동이 가능한지 : boolean isAbleToMove()
[X] 다리의 원하는 구역에 이동가능 위치를 얻는다 : String showRightDestinationInArea(int area)
[X] 움직임 생성 : Progress makeMove(String destination, boolean result)
[X] 이동 결과 반환 받기 : Result moveResult()
[X] 도전기회 증가 : addTotalTry()
[X] 재도전 : void retry()
[X] 현재까지 이동 결과 조회 : List<Progress> showCurrentResult()
[X] 성공 표시 : void success()
[X] 성공 조회 : boolean isSuccess()
[X] 성공 표시 : String showSuccess()
[X] 총 도전 횟수 조회 :  int showTotalTry()
 */

class BridgeGameTest {
    private final int BRIDGE_SIZE = 20;
    private GameCharacter character;
    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        character = new GameCharacter();
        bridgeGame = new BridgeGame(character, BRIDGE_SIZE);
    }

    @DisplayName("다리의 원하는 구역에 이동가능 위치를 확인하는 기능 테스트")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    @ParameterizedTest
    void showRightDestinationInArea(int area) {
        //given
        List<String> bridge = bridgeGame.showBridge();
        //when
        String destination = bridgeGame.showRightDestinationInArea(area);
        //then
        assertThat(bridge.get(area)).isEqualTo(destination);
    }

    @DisplayName("현재까지 이동 결과 조회 기능 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void showCurrentResult(String destination) {
        //given
        bridgeGame.moveCycle(destination);
        String answer = bridgeGame.showRightDestinationInArea(0);
        //when
        List<Move> moves = bridgeGame.showCurrentResult();
        //then
        assertThat(moves.size()).isEqualTo(1);
        assertThat(moves.get(0).getDestination()).isEqualTo(destination);
        assertThat(moves.get(0).isSuccess()).isEqualTo(destination.equals(answer));
    }

    @DisplayName("재도전 기능 테스트")
    @Test
    void retry() {
        //given
        bridgeGame.moveCycle("D");
        bridgeGame.moveCycle("U");
        //when
        bridgeGame.retry();
        //when
        assertThat(bridgeGame.showCurrentResult().size()).isEqualTo(0);
        assertThat(character.showCurrentLocation()).isEqualTo(-1);
    }

    @DisplayName("이동 결과 반환 받기 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void moveResult(String destination) {
        //given
        bridgeGame.moveCycle(destination);
        String answer = bridgeGame.showRightDestinationInArea(0);
        //when
        Result result = bridgeGame.moveResult();
        //then
        if (destination.equals(answer)) {
            assertThat(result).isEqualTo(Result.CONTINUE);
        }
        if (!destination.equals(answer)) {
            assertThat(result).isEqualTo(Result.FAIL);
        }
    }

    @DisplayName("총 도전 횟수 조회")
    @Test
    void showTotalTry() {
        //given
        //when
        int start = bridgeGame.showTotalTry();
        //then
        assertThat(start).isEqualTo(0);
    }

    @DisplayName("도전 횟수 추가")
    @Test
    void addTotalTry() {
        //given
        int before = bridgeGame.showTotalTry();
        //when
        bridgeGame.addTotalTry();
        //then
        int after = bridgeGame.showTotalTry();
        assertThat(before).isEqualTo(0);
        assertThat(after).isEqualTo(1);
    }

    @DisplayName("성공 조회 기능 테스트")
    @Test
    void isSuccess() {
        //given
        //when
        boolean defaultSuccess = bridgeGame.isSuccess();
        //then
        assertThat(defaultSuccess).isFalse();
    }

    @DisplayName("성공 체크 기능 테스트")
    @Test
    void success() {
        //given
        final boolean FAIL = false;
        final boolean SUCCESS = true;
        boolean before = bridgeGame.isSuccess();
        //when
        bridgeGame.success();
        //then
        boolean after = bridgeGame.isSuccess();
        assertThat(before).isEqualTo(FAIL);
        assertThat(after).isEqualTo(SUCCESS);
    }

    @DisplayName("성공 여부 표시 테스트")
    @Test
    void showSuccess() {
        //given
        final String FAIL = "실패";
        final String SUCCESS = "성공";
        //when
        String fail = bridgeGame.showSuccess();
        bridgeGame.success();
        String success = bridgeGame.showSuccess();
        //then
        assertThat(fail).isEqualTo(FAIL);
        assertThat(success).isEqualTo(SUCCESS);
    }

    @DisplayName("게임 캐릭터가 이동할 칸의 이동 가능 여부 체크 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void isAbleToMove(String destination) {
        //given
        String answer = bridgeGame.showRightDestinationInArea(character.showNextArea());
        boolean expect = answer.equals(destination);
        character.setNextMove(destination);
        int nextArea = character.showNextArea();
        //when
        boolean ableToMove = bridgeGame.isAbleToMove(nextArea, destination);
        //then
        assertThat(ableToMove).isEqualTo(expect);
    }

    @DisplayName("다음 진행 결과 만들기")
    @Test
    void makeMove() {
        //given
        String destination = "U";
        boolean isSuccess = true;
        //when
        Move move = bridgeGame.makeMove(destination, isSuccess);
        //then
        assertThat(move.getDestination()).isEqualTo(destination);
        assertThat(move.isSuccess()).isEqualTo(isSuccess);
    }

    @DisplayName("다음 이동 결과 저장")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void saveNextMove(String destination) {
        //given
        character.setNextMove(destination);
        String answer = bridgeGame.showRightDestinationInArea(character.showNextArea());
        boolean moveResult = destination.equals(answer);
        //when
        bridgeGame.saveNextMove();
        //then
        List<Move> currentResult = bridgeGame.showCurrentResult();
        assertThat(currentResult.size()).isEqualTo(1);
        assertThat(currentResult.get(0).getDestination()).isEqualTo(destination);
        assertThat(currentResult.get(0).isSuccess()).isEqualTo(moveResult);
    }

    @DisplayName("입력한 곳으로 캐릭터가 이동시 결과 저장 후 이동")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void moveCycle(String destination) {
        //given
        //when
        bridgeGame.moveCycle(destination);
        //then
        assertThat(character.showNextDestination()).isEqualTo(destination);
        assertThat(character.showCurrentLocation()).isEqualTo(0);
        List<Move> moves = bridgeGame.showCurrentResult();
        assertThat(moves.size()).isEqualTo(1);
        assertThat(moves.get(0).getDestination()).isEqualTo(destination);
    }
}