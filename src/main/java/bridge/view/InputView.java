package bridge.view;

import bridge.message.ProgressMessage;

//사용자로부터 입력을 받는 역할을 한다.
public class InputView {



    public InputView() {

    }


    // 게임을 시작하는 메시지
    public void initBridgeGame() {
        System.out.println(ProgressMessage.INIT_GAME_MESSAGE);
        System.out.println();
    }


}
