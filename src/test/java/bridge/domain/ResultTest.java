package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void 정상_게임결과_생성() {
        Result result = new Result();
        Assertions.assertThat(result.getTryCnt()).isEqualTo(0);
        Assertions.assertThat(result.getFootPrint()).isNotNull();
    }

    @Test
    void 정상_게임결과_성공() {
        Result result = new Result();
        result.recordSuccess(FootrestLocation.UP);
        Assertions.assertThat(result.getSuccess()).isTrue();
        Assertions.assertThat(result.getTryCnt()).isEqualTo(1);
    }

    @Test
    void 정상_게임결과_실패() {
        Result result = new Result();
        result.recordFail(FootrestLocation.UP);
        Assertions.assertThat(result.getSuccess()).isFalse();
        Assertions.assertThat(result.getTryCnt()).isEqualTo(1);
    }

    @Test
    void 정상_턴_여러번() {
        Result result = new Result();
        result.recordFail(FootrestLocation.UP);
        result.recordFail(FootrestLocation.UP);
        result.recordFail(FootrestLocation.UP);
        result.recordFail(FootrestLocation.UP);
        Assertions.assertThat(result.getTryCnt()).isEqualTo(4);
    }

    @Test
    void 정상_init메서드로_내부_FootPrint_객체_변경() {
        Result result = new Result();
        FootPrint footPrint = result.getFootPrint();
        result.initResult();
        FootPrint changedFootPrint = result.getFootPrint();
        Assertions.assertThat(footPrint).isNotSameAs(changedFootPrint); //객체 같은지 테스트 sameAs
    }

}