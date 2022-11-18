package bridge;

import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        BridgeNumberGenerator brg = new BridgeRandomNumberGenerator(); // 정석은 완쪽이 인터페이스 오른쪽이 클래스 : 자식 자식 가능, 부모 자식 가능, 자식 부모는 불가능, 부모부모도 불가능 : 부모가 인터페이스니까
        BridgeMaker bm = new BridgeMaker(brg);
//        List<String> bridgeString = bm.makeBridge(string);


//        BridgeMaker bridgeMaker = new BridgeMaker(); Code Error
        BridgeGame.bridgeGameStart();   // 다리 건너기 게임을 시작합니다
        BridgeGame.bridgeLengthMessage();   // 다리의 길이를 입력해주세요.
        int input = inputView.readBridgeSize();  // 다리 길이 입력 숫자
        System.out.println(input);
        BridgeGame.moveStepMessage(); //이동할칸을 선택해주세요
        String string = inputView.readMoving(Collections.singletonList((input)));
        List<String> bridgeString = bm.makeBridge(Integer.parseInt(string));
    }
}
