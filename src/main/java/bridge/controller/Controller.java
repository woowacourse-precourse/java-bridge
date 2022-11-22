package bridge.controller;

import bridge.Service.Service;

public class Controller {

    private Service service;

    public Controller() {
        this.service = new Service();
    }

    // 게임 시작 기능
    public void startBridgeGame() {
        initBridgeGame();
        gamePlay();
    }

    // 게임 초기화 기능
    private void initBridgeGame() {
        service.welcomeGame();
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
            service.initBridgeUserKeyList();
            move();
            if (retry()) {
                break;
            }
        } while (true);
        result();
    }

    // 다리를 건너는 기능
    private void move() {
        do {
            if (isAnswerCell()) {
                break;
            }
        } while (!service.isBridgeEnd());
    }

    // 정답 칸으로 이동했는지 boolean값 반환
    private boolean isAnswerCell() {
        try {
            service.move();
            if (!service.isAnswer()) {
                return true;
            }
        } catch (IllegalArgumentException error) {
            service.catchError(error);
        }
        return false;
    }



    // 다시 시작 여부를 묻는 기능
    private boolean retry() {
        while (!service.isBridgeEnd() || !service.isAnswer()) {
            try {
                return service.isRetry();
            } catch (IllegalArgumentException error) {
                service.catchError(error);
            }
        }
        return true;
    }

    // 게임 결과 출력 기능
    private void result() {
        service.gameResult();
    }
}
