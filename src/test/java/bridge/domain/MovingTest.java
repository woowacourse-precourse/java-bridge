package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovingTest {

    @DisplayName("사용자가 위로 움직이고 성공 결과를 생성합니다.")
    @Test
    void 위로_이동_및_성공() {
        Moving moving = new Moving();

        moving.add(Move.UP,Result.SUCCESS);

        assertThat(moving.getResult()).isEqualTo(Result.SUCCESS);
    }

    @DisplayName("사용자가 위로 움직이고 실패 결과를 생성합니다.")
    @Test
    void 위로_이동_및_실패() {
        Moving moving = new Moving();

        moving.add(Move.UP,Result.FAIL);

        assertThat(moving.getResult()).isEqualTo(Result.FAIL);
    }

    @DisplayName("사용자가 아래로 움직이고 성공 결과를 생성합니다.")
    @Test
    void 아래로_이동_및_성공() {
        Moving moving = new Moving();

        moving.add(Move.DOWN,Result.SUCCESS);

        assertThat(moving.getResult()).isEqualTo(Result.SUCCESS);
    }

    @DisplayName("사용자가 아래로 움직이고 실패 결과를 생성합니다.")
    @Test
    void 아래로_이동_및_실패() {
        Moving moving = new Moving();

        moving.add(Move.DOWN,Result.FAIL);

        assertThat(moving.getResult()).isEqualTo(Result.FAIL);
    }

    @DisplayName("사용자가 최근에 다리 이동을 성공했는지 테스트합니다.")
    @Test
    void 최근_이동_결과_조회() {
        Moving moving = new Moving();

        moving.add(Move.DOWN,Result.SUCCESS);
        moving.add(Move.DOWN,Result.SUCCESS);
        moving.add(Move.UP,Result.FAIL);

        assertThat(moving.getResult()).isEqualTo(Result.FAIL);
    }

    @DisplayName("게임 재시도 시 초기화합니다.")
    @Test
    void 초기화_테스트() {
        Moving moving = new Moving();

        moving.add(Move.DOWN,Result.SUCCESS);
        moving.add(Move.UP,Result.FAIL);
        moving.initialize();

        assertThat(moving.getMovingResult(Move.UP).size()).isEqualTo(0);
        assertThat(moving.getMovingResult(Move.DOWN).size()).isEqualTo(0);
    }

}