package bridge.utils;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.type.PositionType;
import bridge.type.RetryType;
import bridge.view.InputView;

public class PositionUtils {

    // 현재 플레이어가 선택한 위치와 현재 건널 수 있는 다리의 위치를 비교하여 boolean 으로 반환
    public static boolean compareTo(Player player, Bridge bridge, int start) {
        PositionType passPosition = bridge.currentPosition(start);
        PositionType playerPosition = player.currentPosition(start);

        if (passPosition.equals(playerPosition)) {
            return true;
        }

        return false;
    }

    // 이동 결과에 따라 재시작 종료 문구 출력 및 입력
    public static RetryType toRetryType(boolean isPass) {
        if (!isPass) {
            String readGameCommand = InputView.readGameCommand();

            return RetryType.matchSymbol(readGameCommand)
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] RetryType is not match !!"));
        }

        return RetryType.PASS;
    }
}
