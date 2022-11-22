package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingTest {

    @Test
    public void 숫자여부_확인(){
        assertThatThrownBy(() -> ExceptionHandling.instanceChangeChecking("A"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.instanceChangeChecking("twenty"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.instanceChangeChecking("십구"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자범위_확인(){
        assertThatThrownBy(() -> ExceptionHandling.numberBoundaryChecking(1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.numberBoundaryChecking(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.numberBoundaryChecking(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 업다운_확인(){
        assertThatThrownBy(() -> ExceptionHandling.upDownChecking("2"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.upDownChecking("A"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.upDownChecking("u"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.upDownChecking("d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 지속스탑_확인(){
        assertThatThrownBy(() -> ExceptionHandling.choiceChecking("2"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.choiceChecking("u"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.choiceChecking("D"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ExceptionHandling.choiceChecking("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}