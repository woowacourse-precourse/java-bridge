package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class NormalBlockTest {
    @CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
    @ParameterizedTest
    void 첫_번째_블럭을_생성한다(String input, BlockPosition position) {
        NormalBlock firstBlock = NormalBlock.firstBlock(input);

        assertAll(
                () -> assertThat(firstBlock.position()).isEqualTo(position),
                () -> assertThat(firstBlock.next()).isNull()
        );
    }

    @CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
    @ParameterizedTest
    void 중간_블럭을_생성한다(String input, BlockPosition position) {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");
        NormalBlock middleBlock = firstBlock.nextBlock(input);

        assertAll(
                () -> assertThat(middleBlock.position()).isEqualTo(position),
                () -> assertThat(firstBlock.next()).isEqualTo(middleBlock)
        );
    }

    @CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
    @ParameterizedTest
    void 마지막_블럭을_생성한다(String input, BlockPosition position) {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");
        NormalBlock middleBlock = firstBlock.nextBlock("U");
        LastBlock lastBlock = middleBlock.lastBlock(input);

        assertAll(
                () -> assertThat(lastBlock.position()).isEqualTo(position),
                () -> assertThat(middleBlock.next()).isEqualTo(lastBlock),
                () -> assertThat(lastBlock.isLastBlock()).isTrue()
        );
    }

    @Test
    void 블럭을_방문한다() {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");
        NormalBlock middleBlock = firstBlock.nextBlock("U");

        middleBlock.visit(BlockPosition.D);

        assertThat(middleBlock.isVisited()).isTrue();
    }

    @Test
    void 블럭을_초기화한다() {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");
        firstBlock.visit(BlockPosition.D);

        firstBlock.reset();

        assertThat(firstBlock.isVisited()).isFalse();
    }

    @Test
    void 이미_방문한_블럭은_다시_방문할_수_없다() {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");
        firstBlock.visit(BlockPosition.D);

        assertThatThrownBy(() -> firstBlock.visit(BlockPosition.D))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 다음_블럭을_반환한다() {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");
        NormalBlock middleBlock = firstBlock.nextBlock("U");

        assertThat(firstBlock.next()).isEqualTo(middleBlock);
    }

    @CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
    @ParameterizedTest
    void 블럭의_위치를_반환한다(String input, BlockPosition position) {
        NormalBlock firstBlock = NormalBlock.firstBlock(input);

        assertThat(firstBlock.position()).isEqualTo(position);
    }

    @Test
    void 블럭을_방문했으면_true를_반환한다() {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");
        firstBlock.visit(BlockPosition.D);

        assertThat(firstBlock.isVisited()).isTrue();
    }

    @Test
    void 블럭을_방문하지_않았으면_false를_반환한다() {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");

        assertThat(firstBlock.isVisited()).isFalse();
    }

    @Test
    void 블럭이_마지막_블럭인지_여부를_반환한다() {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");

        assertThat(firstBlock.isLastBlock()).isFalse();
    }

    @CsvSource(value = {"U:true", "D:false"}, delimiter = ':')
    @ParameterizedTest
    void 블럭을_성공적으로_지나갔는지_여부를_반환한다(BlockPosition position, boolean result) {
        NormalBlock firstBlock = NormalBlock.firstBlock("U");
        NormalBlock middleBlock = firstBlock.nextBlock("U");

        middleBlock.visit(position);

        assertThat(middleBlock.isPassed()).isEqualTo(result);
    }
}
