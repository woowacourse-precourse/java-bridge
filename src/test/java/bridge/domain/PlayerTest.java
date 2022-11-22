package bridge.domain;

import bridge.domain.Bridge;
import bridge.domain.Player;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {
    @Test
    public void movable_다리_시작점에서_움직일_수_있는지() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        assertThat(player.movable()).isTrue();
    }

    @Test
    public void movable_다리_끝에서_움직일수_있는지() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        player.move("U");
        player.move("U");

        assertThat(player.movable()).isFalse();
    }

    @Test
    public void movable_move실패시_움직일수_있는지() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        player.move("U");
        player.move("D");

        assertThat(player.movable()).isFalse();
    }

    @Test
    public void move_다리_시작점에서_움직임이_성공인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        assertThat(player.move("U")).isEqualTo(0);
    }

    @Test
    public void move_다리_끝점에서_움직임이_실패인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        player.move("U");
        player.move("U");

        assertThat(player.move("U")).isEqualTo(1);
    }

    @Test
    public void 다리_끝까지_온_플레이어가_성공인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        //when
        player.move("U");
        player.move("U");

        //then
        assertThat(player.isSuccess()).isTrue();
    }

    @Test
    public void 다리_중간의_플레이어가_성공인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        //when
        player.move("U");

        //then
        assertThat(player.isSuccess()).isFalse();
    }

    @Test
    public void 다리_중간에서_move_실패한_플레이어가_성공인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        //when
        player.move("U");
        player.move("D");

        //then
        assertThat(player.isSuccess()).isFalse();
    }

    @Test
    public void 시작지점에서_footprint_확인() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        assertThat(player.getUpperFootPrint()).isEqualTo(Collections.EMPTY_LIST);
        assertThat(player.getLowerFootPrint()).isEqualTo(Collections.EMPTY_LIST);
    }

    @Test
    public void 다리_중간에서_footprint_확인_한번_move() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        player.move("U");

        assertThat(player.getUpperFootPrint()).isEqualTo(List.of("O"));
        assertThat(player.getLowerFootPrint()).isEqualTo(List.of(" "));
    }

    @Test
    public void 다리_마지막에서_footprint_확인() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U", "D")));
        player.startRound();

        player.move("U");
        player.move("U");
        player.move("D");

        assertThat(player.getUpperFootPrint()).isEqualTo(List.of("O","O"," "));
        assertThat(player.getLowerFootPrint()).isEqualTo(List.of(" "," ","O"));
    }

    @Test
    public void 다리_중간에서_틀렸을떄_footprint_확인() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        player.move("U");
        player.move("D");

        assertThat(player.getUpperFootPrint()).isEqualTo(List.of("O"," "));
        assertThat(player.getLowerFootPrint()).isEqualTo(List.of(" ","X"));
    }

    @Test
    public void startRound시에_라운드_확인() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();
        assertThat(player.showTrials()).isEqualTo(1);
    }

    @Test
    public void startRound시에_결과_리스트에서_X삭제_확인() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        player.move("U");
        player.move("D");

        player.startRound();

        assertThat(player.getUpperFootPrint()).isEqualTo(List.of("O"));
        assertThat(player.getLowerFootPrint()).isEqualTo(List.of(" "));
    }
}