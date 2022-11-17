package bridge;

public class Application {

    /*
    입력
    [] - 자동으로 생성할 다리 길이 입력 - 3~20이 아니라면 예외
    [] - 라운드마다 플레이어가 이동할 칸 입력 - U(위), D(아래)중 문자 입력 아니라면 예외
    [] - 게임 재시작 / 종료 여부 입력 - R(재시작), Q(종료)중 문자 입력 아니라면 예외

    출력
    [] - 게임 시작 문구
    [] - 게임 종료 문구
    아마도
    두번
    sout[
    for(배열 길이)
    sout(배열 값 + | )
    sout]

    구현
    [] - 다리 생성 시 0과 1 중 무작위 값으로 설정
    [] - U, D 입력시 판단하여 건널 수 있는지 없는지 여부 판단
    [] - 시도한 횟수 기억
    */
    public static void main(String[] args) {
        int bridgeLength = InputView.readBridgeSize();

    }
}
