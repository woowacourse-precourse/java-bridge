package bridge;

import bridge.domain.GameProgress;
import bridge.domain.GameResult;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 객체 생성 및 다리 생성
        BridgeGame game = new BridgeGame();

        // 게임 진행
        while (true) {
            // 길 입력받기
            game.move();
            // 결과확인
            GameResult gameResult = game.getResult();
            BridgeGame.printGameResult(gameResult);

            // 실패시 재시도할지 확인
            if (gameResult.getProgress() == GameProgress.FAILURE) {
                if (!game.retry()) {
                    break;
                }
            }
            // 성공시 게임 종료
            if (gameResult.getProgress() == GameProgress.SUCCESS) {
                break;
            }
        }
    }
}
