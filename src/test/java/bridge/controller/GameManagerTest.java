package bridge.controller;

import org.junit.jupiter.api.BeforeEach;

class GameManagerTest {

    AppConfig appConfig;
    GameManager gameManager;

    @BeforeEach
    void beforeEach() {
        appConfig = new AppConfig();
        gameManager = appConfig.gameManager();
    }



}