package bridge.controller;

import bridge.Service.Service;

public class Controller {

    private Service service;

    public Controller() {
        this.service = new Service();
    }

    // 게임 시작 기능
    public void startBridgeGame() {
        service.welcomeGame();
        initBridgeGame();
        gamePlay();
    }

    // 게임 초기화 기능
    private void initBridgeGame() {
        do {
            try {
                service.initGame();
                break;
            } catch (IllegalArgumentException error) {
                service.catchError(error);
            }
        } while (true);
    }

    // 게임 다리건너기 기능
    private void gamePlay() {
        do {
            service.move();
            if (service.retry()) {
                break;
            }
        } while (true);
    }
}
