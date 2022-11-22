package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView;
    BridgePlayerCheck bridgePlayerCheck;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        bridgePlayerCheck = new BridgePlayerCheck();
    }

    @Test
    void isOTrueTest() {
        assertThat(bridgePlayerCheck.isO("U", "U", "U")).isTrue();
    }

    @Test
    void isOFalseTest() {
        assertThat(bridgePlayerCheck.isO("U", "U", "D")).isFalse();
    }

    @Test
    void isXTrueTest() {
        assertThat(bridgePlayerCheck.isX("D", "U", "U")).isTrue();
    }

    @Test
    void isXFalseTest() {
        assertThat(bridgePlayerCheck.isX("U", "U", "D")).isFalse();
    }

    @Test
    void printMapTestU() {
        outputView.printSingleMap(List.of("U", "D", "D"), List.of("U", "U"), "U");
        assertThatNoException();
    }

    @Test
    void printMapTestD() {
        outputView.printSingleMap(List.of("U", "D", "D"), List.of("U", "U"), "D");
        assertThatNoException();
    }

    @Test
    void printMapTest() {
        outputView.printMap(List.of("U", "U", "D"), List.of("U", "U"));
        assertThatNoException();
    }
}