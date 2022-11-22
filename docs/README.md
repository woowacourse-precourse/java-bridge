# 구현 내용

- Application
    - InputView, OutputView를 사용하여 입출력한다.
    - BridgeGameConfig를 통해 BridgeGame을 생성한다.
    - bridge size에 맞게 bridge를 세팅한다.
    - 게임이 종료될 때까지 게임을 반복한다.

- config 패키지 생성
    - BridgeGame을 생성하는 config 클래스 생성.

- io 패키지 생성
    - InputView, OutputView를 io 패키지로 구분한다.

- InputView
    - 입력 받은 다리의 길이가 숫자가 아니면 예외를 발생시킨다.
    - 입력 받은 다리의 길이가 3 이상 20 이하의 숫자가 아니면 예외를 발생시킨다.
    - 입력 받은 이동할 칸이 U 또는 D가 아니면 예외를 발생시킨다.
    - 입력 받은 restart 커맨드가 R 또는 Q가 아니면 예외를 발생시킨다.

- OutputView
    - 2개의 StringBuilder로 위쪽 다리와 아래쪽 다리 진행상황을 담는다.
    - 게임 안내 메세지를 출력한다.
    - 게임 진행 상황을 출력한다.
    - 게임 결과를 출력한다.

- BridgeGame
    - BridgeMaker를 통해 Bridge 생성한다.
    - 게임을 새로 시작할때마다 tries 값을 1씩 증가시킨다.
    - move(String course)
        - bridge course를 입력받아 한 칸 이동하고 성공, 실패 여부를 boolean type으로 반환한다.
        - nowIndex를 1 증가시킨다.
    - retry()
        - nowIndex를 0으로 세팅하고, tries 횟수를 1 증가시킨다.
    - 성공했는지 여부를 boolean type으로 가진다.

- BridgeMaker
    - size에 맞는 bridge를 생성한다.
    - BridgeNumberGenerator를 통해 0 또는 1 숫자 값을 랜덤으로 생성한다.
    - 숫자가 0 또는 1이 아니면 예외를 발생시킨다.
    - 0은 "D", 1은 "U"로 변환한다.
    - bridge 목록을 반환한다.
