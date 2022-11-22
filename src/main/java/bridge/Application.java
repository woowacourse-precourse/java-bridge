package bridge;

import static bridge.InputView.readBridgeSize;

public class Application {

    public static void main(String[] args) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        OutputView.String("다리 건너기 게임을 시작합니다.");

        new BridgeGame(bridgeMaker.makeBridge(RepeatReadBridgeSize()));
    }

    private static int RepeatReadBridgeSize() {
        while (true) {
            try {
                return readBridgeSize();
            } catch (NumberFormatException e) { OutputView.String("[ERROR] 입력된 값이 정수가 아닙니다."); }
            catch (IllegalArgumentException e) { OutputView.String("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."); }
        }
    }
}
