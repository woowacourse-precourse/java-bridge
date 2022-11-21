package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        new BridgeGameController().run();
    }
}

// TODO : leftovers
//  - 기능 목록 작성 -> 계속 업데이트 하기 예외사항들도
//  - final, static, public, private 등등 처리
//  - 개행 확인
//  - output 다 to String 으로 바꾸기!