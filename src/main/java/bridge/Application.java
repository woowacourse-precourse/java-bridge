package bridge;

import controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 리드미 확인할 것
        // TODO: View 에서는 최소한의 검증만 -> 알파벳 대문자인지만 확인하고 도메인에서 확인할 것
        // TODO: 마지막에 실패한 경우 예외 처리
        // TODO: 요구사항 제발 제대로 찬찬히 읽어보기
        // TODO: DTO 넘어가고 검증 도메인에서 잘 되고 있는지 확인하기 어디서 재실행 되는지 꼮꼭꼮꼭꼭꼭꼭!!!!!!!!!!!!!!!
        GameController gameController = new GameController();
        gameController.control();
    }
}
