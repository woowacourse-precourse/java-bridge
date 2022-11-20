
## Description
* 다리 건너기 게임을 진행할 수 있는 서비스이다.
* 다리 건너기 실패 시 재시도 또는 종료가 가능하다.
* 다리 건너기 게임이 종료된 뒤 성공 여부와 총 시도 횟수 확인이 가능하다.

## Environment
* JDK 11.0.17+8

## Functions
**BrigdeMaker.java**
* makeBridge : 입력받은 다리의 길이만큼 각 다리의 건널 수 있는 칸을 표현한 리스트를 반환한다.

**BrigdeGame.java**
* setSize : 인스턴스 변수 size(다리 길이)에 대한 setter 함수이다.
* getCount : 인스턴스 변수 count(시도 횟수)에 대한 getter 함수이다.
* isDone : 사용자가 다리를 다 건너는 데 성공한 상태인지 확인할 때 사용한다.
* isOver : 사용자가 칸을 이동에 실패한 상태인지 확인할 때 사용한다.
* makeBridgeGame : 사용자가 게임을 시작할 때 사용한다.
* move : 사용자가 칸을 이동한 뒤의 결과를 반환한다.
* retry : 사용자가 게임을 재시작할 때 사용한다.

**InputView.java**
* readBridgeSize : 다리의 길이를 입력받는다.
* readMoving : 사용자가 이동할 칸을 입력받는다.
* readGameCommand : 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
* checkBridgeSize : 입력받은 다리의 길이 값이 잘못되었는지 판단한다.
* checkMoving : 입력받은 칸의 값이 잘못되었는지 판단한다.
* checkGameCommand : 입력받은 게임 재시작 여부 값이 잘못되었는지 판단한다.

**OutputView.java**
* printMap : 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
* getbridgeStatus : 현재 다리 한 칸의 상태를 형식에 맞는 문자열로 반환한다.
* printResult : 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
* printStart : 게임 시작을 알리는 내용과 다리의 길이를 입력하도록 지시하는 내용을 출력한다.
* printMoving : 이동할 칸을 선택하도록 지시하는 내용을 출력한다.
* printGameCommand : 게임을 재시도할지 종료할지를 선택하도록 지시하는 내용을 출력한다.

**Application.java**
* start : 게임 시작 화면 구성 후 다리 길이를 입력받아 랜덤 다리를 생성한다.
* choice : 사용자에게 칸을 입력받아 다리에서 이동한다.
* result : 다리에서 이동한 결과를 출력 후 사용자가 다리를 건너는 데 실패한 경우 재시도, 종료를 선택하도록 한다.
* finish : 게임이 완전히 종료된 경우 결과를 출력한다.