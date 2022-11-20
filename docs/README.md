
## Description
* 다리 건너기 게임을 진행할 수 있는 서비스이다.
* 다리 건너기 실패 시 재시도 또는 종료가 가능하다.
* 다리 건너기 게임이 종료된 뒤 성공 여부와 총 시도 횟수 확인이 가능하다.

## Environment
* JDK 11.0.17+8

## Functions
**BrigdeMaker.java**
* makeBridge : 입력받은 다리의 길이만큼 각 다리의 건널 수 있는 칸을 표현한 리스트를 반환한다.

**InputView.java**
* readBridgeSize : 다리의 길이를 입력받는다.
* readMoving : 사용자가 이동할 칸을 입력받는다.
* readGameCommand : 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.

**OutputView.java**
* printStart : 게임 시작을 알리는 내용과 다리의 길이를 입력하도록 지시하는 내용을 출력한다.
* printMoving : 이동할 칸을 선택하도록 지시하는 내용을 출력한다.
* printGameCommand : 게임을 재시도할지 종료할지를 선택하도록 지시하는 내용을 출력한다.