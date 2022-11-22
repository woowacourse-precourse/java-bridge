package bridge.controller;

import bridge.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class InputControllerTest {
    private InputController inputController;
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        inputController = new InputController();
        inputController.init();
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void tearDownAndPrint() {
        System.setOut(standardOut);
        System.out.println(captor.toString().trim());
    }

    @DisplayName("setBridgeSize 예외 테스트.")
    @ParameterizedTest
    @ValueSource(strings = {"1","22","","a"})
    public void setBridgeSizeException(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputController.setBridgeSize();

        Assertions.assertThat(captor.toString()).contains(Constants.ErrorMessages.ERROR);
    }

    @DisplayName("setBridgeSize 옳은 경우 테스트.")
    @ParameterizedTest
    @ValueSource(strings = {"3","5","20"})
    public void setBridgeSize(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int i = inputController.setBridgeSize();

        Assertions.assertThat(i).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("setMoveChoice 예외 테스트.")
    @ParameterizedTest
    @ValueSource(strings = {"1","H",""})
    void setMoveChoiceException(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputController.setMoveChoice();

        Assertions.assertThat(captor.toString()).contains(Constants.ErrorMessages.ERROR);
    }

    @DisplayName("setMoveChoice 옳은 경우 테스트.")
    @ParameterizedTest
    @ValueSource(strings = {"U","D"})
    public void setMoveChoice(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String i = inputController.setMoveChoice();

        Assertions.assertThat(i).isEqualTo(input.toUpperCase());
    }

    @DisplayName("setGameCommand 예외 테스트.")
    @ParameterizedTest
    @ValueSource(strings = {"1","H",""})
    void setGameCommandException(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputController.setGameCommand();

        Assertions.assertThat(captor.toString()).contains(Constants.ErrorMessages.ERROR);
    }

    @DisplayName("setGameCommand 옳은 경우 테스트.")
    @ParameterizedTest
    @ValueSource(strings = {"R","Q"})
    public void setGameCommand(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String i = inputController.setGameCommand();

        Assertions.assertThat(i).isEqualTo(input.toUpperCase());
    }
}