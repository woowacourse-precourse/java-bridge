# 구현 내용

- Application
    - InputView, OutputView를 사용하여 입출력한다.
    - BridgeGameConfig를 통해 BridgeGame을 생성한다.
    - bridge size에 맞게 bridge를 세팅한다.
    - 게임이 종료될 때까지 게임을 반복한다.

- io 패키지 생성
    - InputView, OutputView를 io 패키지로 구분한다.

- InputView
    - 입력 받은 다리의 길이가 숫자가 아니면 예외를 발생시킨다.
    - 입력 받은 다리의 길이가 3 이상 20 이하의 숫자가 아니면 예외를 발생시킨다.
    - 입력 받은 이동할 칸이 U 또는 D가 아니면 예외를 발생시킨다.
    - 입력 받은 restart 커맨드가 R 또는 Q가 아니면 예외를 발생시킨다.

- OutputView
    - 게임 안내 메세지를 출력한다.
    - 게임 진행 상황을 출력한다.
    - 게임 결과를 출력한다.

- BridgeGame
    - BridgeMaker를 통해 Bridge 생성한다.
    - move
    - retry

- BridgeMaker
    - size에 맞는 bridge를 생성한다.
    - BridgeNumberGenerator를 통해 0 또는 1 숫자 값을 랜덤으로 생성한다.
    - 숫자가 0 또는 1이 아니면 예외를 발생시킨다.
    - 0은 "D", 1은 "U"로 변환한다.
    - bridge 목록을 반환한다.