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

    // 게임 진행
    private void gamePlay() {
        do {
            move();
            if (retry()) {
                break;
            }
        } while (true);
    }

    // 다리를 건너는 기능
    private void move() {
        service.initBridgeUserKeyList();
        do {
            try {
                service.move();
            } catch (IllegalArgumentException error) {
                service.catchError(error);
            }
        } while (!service.isBridgeEnd());
    }

    // 다시 시작 여부를 묻는 기능
    private boolean retry() {
        do {
            try {
                return service.retry();
            } catch (IllegalArgumentException error) {
                service.catchError(error);
            }
        } while (true);
    }
}
