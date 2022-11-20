package bridge;

public class Application {
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run(){
        // output view
        System.out.println("다리 건너기 게임을 시작합니다.");
        // 자동으로 생성할 다리 길이를 입력 받는다. --> input view
        int bridgeSize = inputView.readBridgeSize();

        // 다리를 생성합니다. --> bridge maker
        bridgeMaker.makeBridge(bridgeSize);

        // 이동할 칸을 선택해주세요 --> output view
        // U 또는 D 입력 받기 --> input view
        // 다리를 출력합니다 --> output view

        // 게임 실패시 다시 시도 여부 --> bridge game, output view
        // R 또는 Q 입력 --> input view

        // 마지막 칸 도착시
        // 최종 게임 결과 -- > outputView
        // 다리 출력
        // 게임 성공 여부 출력
        // 시도 횟수 출력
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
