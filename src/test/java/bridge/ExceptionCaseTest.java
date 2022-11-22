package bridge;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionCaseTest {

    @Test
    void 다리_길이_정수형_확인_테스트() {
        assertThatThrownBy(() -> new ExceptionCase()
                .validateBridgeSizeIsInteger("3 5"))
                .isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> new ExceptionCase()
                .validateBridgeSizeIsInteger("a"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 다리_길이_범위_확인_테스트() {
        assertThatThrownBy(() -> new ExceptionCase()
                .validateBridgeSizeInRange(25))
                .isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> new ExceptionCase()
                .validateBridgeSizeInRange(0))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 움직임_입력_확인_테스트() {
        assertThatThrownBy(() -> new ExceptionCase()
                .validateMoves("T"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 재도전_입력_확인_테스트() {
        assertThatThrownBy(() -> new ExceptionCase()
                .validateMoves("T"))
                .isInstanceOf(NoSuchElementException.class);
    }
}