package bridge.controller;

import bridge.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    AppConfig appConfig;
    GameManager gameManager;

    @BeforeEach
    void beforeEach() {
        appConfig = new AppConfig();
        gameManager = appConfig.gameManager();
    }



}