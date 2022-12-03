package bridge.controller;

import bridge.model.Score;
import bridge.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GameManagerTest {

    GameManager gameManager;

    public InputStream getPlayerInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    void beforeEach() {
        gameManager = new GameManager();
    }

    @ParameterizedTest
    @DisplayName("게임 세팅 초기화")
    @ValueSource(strings = {"3"})
    void initTest(String input){
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        gameManager.initGameSetting();
        Assertions.assertThat(gameManager.bridgeGame.bridge.getBridge().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("사용자 입력에 따라 이동 가능한지 확인하기")
    @ValueSource(strings = {"U"})
    void checkMoveByInput(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        gameManager.bridgeGame.makeBridge(3);
        boolean gameResult =  gameManager.checkMove(new User(), new Score());
        Assertions.assertThat(gameResult).isEqualTo(input.equals(gameManager.bridgeGame.bridge.getBridge().get(0)));
    }






}