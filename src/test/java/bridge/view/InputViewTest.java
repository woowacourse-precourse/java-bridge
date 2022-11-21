package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
//    @DisplayName("다리 길이 정상 입력 테스트")
//    @Test
//    void ValidateBridgeSize_normal() {
//        InputView inputView = new InputView();
//
//        IntStream.range(3,21).mapToObj(String::valueOf).
//                forEach(x ->
//                    assertThatCode(()->inputView.validateBridgeSize(x)).doesNotThrowAnyException()
//        );
//    }
//
//    @DisplayName("다리 길이 비정상 입력(범위초과)")
//    @Test
//    void ValidateBridgeSize_outOfRange() {
//        InputView inputView = new InputView();
//
//        assertThatCode(()->inputView.validateBridgeSize("0")).isInstanceOf(IllegalArgumentException.class);
//        assertThatCode(()->inputView.validateBridgeSize("1")).isInstanceOf(IllegalArgumentException.class);
//        assertThatCode(()->inputView.validateBridgeSize("2")).isInstanceOf(IllegalArgumentException.class);
//        IntStream.range(21,150).mapToObj(String::valueOf).
//                forEach(x ->
//                            assertThatCode(()->inputView.validateBridgeSize(x)).isInstanceOf(IllegalArgumentException.class)
//                );
//    }
//
//    @DisplayName("다리 길이 비정상 입력(문자입력)")
//    @Test
//    void ValidateBridgeSize_includeChar() {
//        InputView inputView = new InputView();
//        assertThatCode(()->inputView.validateBridgeSize("a")).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("이동 입력 테스트")
//    @Test
//    void validateMoving() {
//        //정상입력
//        assertThatCode(() -> new InputView().validateMoving("U")).doesNotThrowAnyException();
//        //비정상 입력(예외발생)
//        assertThatCode(() -> new InputView().validateMoving("ㄹ")).isInstanceOf(IllegalArgumentException.class);
//        assertThatCode(() -> new InputView().validateMoving("UU")).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void validateGame() {
//        //정상입력
//        assertThatCode(() -> new InputView().validateGame("Q")).doesNotThrowAnyException();
//        //비정상 입력(예외발생)
//        assertThatCode(() -> new InputView().validateGame("ㄹ")).isInstanceOf(IllegalArgumentException.class);
//        assertThatCode(() -> new InputView().validateGame("RQ")).isInstanceOf(IllegalArgumentException.class);
//    }
}