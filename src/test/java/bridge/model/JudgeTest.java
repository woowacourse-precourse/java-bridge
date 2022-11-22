package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JudgeTest {

    Judge judge;

    @BeforeEach
    void setUp(){
        List<String> bridge = List.of("U", "D", "D");
        judge = new Judge(bridge);
        judge.initUserBridge();
    }

    @DisplayName("addUserBridge 함수에 Moving.DOWN 객체를 인자로 넣으면 유저 다리리스트가 제대로 입력되는지 알아본다")
    @Test
    void addUserBridge() {
        judge.addUserBridge(Moving.DOWN);
        assertThat(judge.getUserBridge().get(0))
                .isEqualTo(Moving.DOWN.getValue());
    }

    @DisplayName("checkIsCorrectMoving 함수에 맞는 값이 들어왔을때 제대로 MoveResult.CORRECT를 return 하는 지 알아본다")
    @Test
    void checkIsCorrectMoving() {
        judge.addUserBridge(Moving.UP);
        judge.addUserBridge(Moving.DOWN);
        assertThat(judge.checkIsCorrectMoving(Moving.DOWN))
                .isEqualTo(MoveResult.CORRECT);
    }

    @DisplayName("checkIsCorrectMoving 함수에 틀린 값이 들어왔을때 제대로 MoveResult.NOT_CORRECT를 return 하는 지 알아본다")
    @Test
    void checkIsCorrectMoving2() {
        Moving moving = Moving.DOWN;
        judge.addUserBridge(moving);
        assertThat(judge.checkIsCorrectMoving(moving))
                .isEqualTo(MoveResult.NOT_CORRECT);
    }

    @DisplayName("유저의 다리 길이와 다리길이가 다를 때 isGameEnd 함수가 제대로 true를 return 하는 지 알아본다")
    @Test
    void isGameEnd() {
        judge.addUserBridge(Moving.UP);
        judge.addUserBridge(Moving.DOWN);
        assertThat(judge.isGameEnd(MoveResult.CORRECT))
                .isEqualTo(true);
    }

    @DisplayName("유저의 다리 길이와 다리길이가 같을 때 isGameEnd 함수가 제대로 false를 return 하는 지 알아본다")
    @Test
    void isGameEnd2() {
        judge.addUserBridge(Moving.UP);
        judge.addUserBridge(Moving.DOWN);
        judge.addUserBridge(Moving.DOWN);
        assertThat(judge.isGameEnd(MoveResult.CORRECT))
                .isEqualTo(false);
    }

    @DisplayName("유저의 다리 길이와 다리길이가 다를 때 MoveResult.NOT_CORRECT함수가 인자로 들어오면 isGameEnd 함수가 제대로 false를 return 하는 지 알아본다")
    @Test
    void isGameEnd3() {
        judge.addUserBridge(Moving.UP);
        judge.addUserBridge(Moving.DOWN);
        assertThat(judge.isGameEnd(MoveResult.NOT_CORRECT))
                .isEqualTo(false);
    }

}