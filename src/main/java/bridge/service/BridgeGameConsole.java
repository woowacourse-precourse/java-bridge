package bridge.service;

public class BridgeGameConsole {

    private final Emcee emcee = new Emcee();
    private final Player player = new Player();

    public void run() {
        // 게임 시작 안내문을 출력한다.
        // 다리 길이를 입력 받는다.
        // 다리 생성
        // 다리 건너기
        // 게임 결과 출력
    }

    private int createBridgeLength() {
        emcee.guideEnteringBridgeLength();
        return player.enterBridgeLength();
    }

    private void crossBridge() {
        while (true) {
            // 이동 방향 입력 안내
            // 이동 방향 입력
            // 이동 방향 입력값 처리
            // 이동 결과 출력
            // 이동 결과 처리
        }
    }

    private void showGameResult() {
        // 최종 다리 이동 결과 출력하기
        // 게임 성공 여부 출력하기
        // 시도 횟수 출력하기
    }
}
