package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int count = 0;

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputView.readBridgeSize();

        List<String> strings = bridgeMaker.makeBridge(bridgeSize);
        System.out.println("strings = " + strings);

        while (true) {
            count++;
            try {
                for (int i = 0; i < bridgeSize; i++) {
                    System.out.println("이동할 칸을 선택해주세요.");
                    String movingPos = inputView.readMoving(); // s : U or D // 1,3,5 위치
                    boolean equals = movingPos.charAt(0) == (strings.get(0).charAt(i * 2));
                    if (!(movingPos.charAt(0) == (strings.get(0).charAt(i * 2)))) {
                        throw new IllegalArgumentException();
                    }
                    outputView.printMap();
                }
                System.out.println("게임 성공 여부: 성공");
                System.out.println("총 시도한 횟수: " + count);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("틀렸습니다.");
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String s = inputView.readGameCommand();
                if (s.equals("Q")) {
                    outputView.printMap();
                    System.out.println("게임 성공 여부: 실패");
                    System.out.println("총 시도한 횟수: " + count);
                    return;
                };
            }
        }

    }
}
