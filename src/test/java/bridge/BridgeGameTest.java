package bridge;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.identifiers.Direction;
import bridge.paths.PlayerPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    @Test
    void 사용자_경로_이동은_다리의_안전경로와_같을때_적절히_실행된다(){
        BridgeGame game = new BridgeGame();
        game.initComponents(
                new TestNumberGenerator(newArrayList(1, 0, 1)),
                3);
        game.move(Direction.UP);

        assertThat(game.getPlayerPath().getIsAlive()).isTrue();
    }

    @Test
    void 사용자_경로_이동은_다리의_안전경로와_다를때_적절히_실행된다(){
        BridgeGame game = new BridgeGame();
        game.initComponents(
                new TestNumberGenerator(newArrayList(1, 0, 1)),
                3);
        game.move(Direction.DOWN);

        assertThat(game.getPlayerPath().getIsAlive()).isFalse();
    }

    @Test
    void 게임_재시도_데이처_처리는_정상동작한다(){
        BridgeGame game = new BridgeGame();
        PlayerPath path1 = game.getPlayerPath();
        game.retry();
        PlayerPath path2 = game.getPlayerPath();

        assertThat(path2).isNotEqualTo(path1);
    }

    @Nested
    class CheckCompletelyMatchedTest {
        BridgeGame game;
        @BeforeEach
        void init(){
            game = new BridgeGame();
            game.initComponents(
                    new TestNumberGenerator(newArrayList(1, 0, 1)),
                    3);
        }

        @Test
        void 사용자경로길이가_다리_안전경로보다_모든부분이_일치해야_완전일치다(){
            game.move(Direction.UP);
            game.move(Direction.DOWN);
            game.move(Direction.UP);
            assertThat(game.getIsSuccess()).isTrue();
        }
        @Test
        void 사용자경로길이가_다리_안전경로보다_짧으면_완전일치가_아니다(){
            game.move(Direction.UP);
            game.move(Direction.DOWN);
            assertThat(game.getIsSuccess()).isFalse();
        }

        @Test
        void 사용자경로길이가_다리_안전경로와_첫부분이_다르면_완전일치가_아니다(){
            game.move(Direction.DOWN);
            game.move(Direction.DOWN);
            game.move(Direction.UP);
            assertThat(game.getIsSuccess()).isFalse();
        }

        @Test
        void 사용자경로길이가_다리_안전경로와_중간부분이_다르면_완전일치가_아니다(){
            game.move(Direction.UP);
            game.move(Direction.UP);
            game.move(Direction.UP);
            assertThat(game.getIsSuccess()).isFalse();
        }

        @Test
        void 사용자경로길이가_다리_안전경로와_끝부분이_다르면_완전일치가_아니다(){
            game.move(Direction.UP);
            game.move(Direction.DOWN);
            game.move(Direction.DOWN);
            assertThat(game.getIsSuccess()).isFalse();
        }
    }
}