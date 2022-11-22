package bridge;

public class Application {
    private static final BridgeNumberGenerator bridgeNumberGenerator = null;

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        BridgeGame gamestart = new BridgeGame();
        BridgeMaker bridgeMake = new BridgeMaker(bridgeNumberGenerator);
        System.out.println("다리 건너기 게임을 시작합니다.\n");

        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeLength = input.readBridgeSize();
        if (bridgeLength == 0) {
            return;
        } else if (bridgeLength < 3 || bridgeLength > 21) {
            System.out.println("[ERROR] 다리 길이는 3이상 20이하 숫자를 입력하세요.");
            return;
        }
        int tryCount = 1; // 총 시도 횟수
        int saveLength = bridgeLength;

        while (bridgeLength > 0) {
            bridgeMake.makeBridge(bridgeLength); // 맵 생성
            if (bridgeMake.firstORretry == false)
                if (bridgeMake.error.contains("ERROR")) {
                    System.out.println("[ERROR] U 또는 D를 입력하세요.");
                    return;
                }

            output.printMap(bridgeMake); // Map 출력
            if (bridgeMake.upperMap.contains("X") || bridgeMake.lowerMap.contains("X")) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String retry = gamestart.retry(input.readGameCommand()); // Q or R
                if (retry.equals("R")) {
                    bridgeMake.firstORretry = true;// 재시도
                    if (bridgeMake.possibleToGo == 0) { // "X"가 나온 반대 길을 넣어주기
                        bridgeMake.ll.add(1);
                    } else if (bridgeMake.possibleToGo == 1) {
                        bridgeMake.ll.add(0);
                    }
                    bridgeMake.i = 0;
                    tryCount += 1;
                    bridgeLength = saveLength + 1;
                    bridgeMake.upperMap = "[ ";
                    bridgeMake.lowerMap = "[ ";

                } else if (retry.equals("Q")) {
                    output.printResult(bridgeMake, tryCount); /** 최종결과 출력**/

                    break;
                } else if (retry.equals("ERROR")) {
                    System.out.println("[ERROR] R 또는 Q를 입력하세요.");
                    return;
                }
            }
            bridgeLength--;
        }
        output.printResult(bridgeMake, tryCount);

    }
}

