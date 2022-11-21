---

## Crossing The Bridge Game


### 설명 요약

    - 다리 길이 만큼 끝까지 건너기
    - 위 아래로 결정하여 건너기
    - 우측으로 이동
    - 건너기는 O 면 가능, X 면 불가능
    - 게임 성공 여부와 총 시도 횟수 반환


<br/>

### 기능 설계

    - InputView (Class)
        값 입력을 위해 필요한 메서드를 가진 클래스

* readBridgeSize()
    - 다리의 길이를 입력
* readMoving()
    - 사용자가 이동할 칸을 입력
* readGameCommand()
    - 사용자가 게임을 다시 시도할지 종료할지 여부를 입력
* checkInputError()
    - 사용자의 입력값이 예외처리 하는지 확인

<br/>

    - OutputView (Class)
        값 출력을 위해 필요한 메서드를 가진 클래스

* printMessage()
    - 기본 안내 메시지 인수로 받아 출력
* printMap()
    - 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력
* printResult()
    - 게임의 최종 결과를 정해진 형식에 맞춰 출력
* printError()
    - 예외처리 출력

<br/>

    - BridgeGame (Class)
        게임 진행을 위해 필요한 메서드를 가진 클래스

* move()
    - 사용자가 칸을 이동할 때 사용하는 메서드
* retry()
    - 게임의 최종 결과를 정해진 형식에 맞춰 출력
* checkAbleToMove()
    - 이동 가능한지 확인
* checkEnd()
    - 끝인지 확인


<br/>

    - Bridge (Class)
        BridgeGame 등에 사용할 모델 클래스 

* drawResult
  - 최종 게임 결과 OutputView.printResult 하기
* move
  - 이동 입력 후 moveStates 에 추가 후 그리기 
* compareStates
  - 해당 길이의 다리 상태 비교
* checkSuccess
  - 올바른 다리 상태와 비교 후 성공 여부 반환
* checkRetru
  - 재시도할지 종료할지 선택 후 재시도 여부 반환
* addMoveState
  - List<String> moveStates 에 값 추가
* removeLastState
  - List<String> moveStates 에 값 제거
* getMapToString
  - 다리 윗부분과 아랫부분의 map 합쳐서 String 값으로 반환
* getSize
  - List<String> moveStates 의 크기 반환
* getLastIndex
  - List<String> moveStates 의 마지막 index 반환
* getMoveStates
  - List<String> moveStates 반환
* getMoveState
  - 해당 index 값 state 반환
* getUpMap
  - 다리 윗부분 Bridge map 형식으로 String 값 반환
* getDownMap
  - 다리 아랫부분 Bridge map 형식으로 String 값 반환
* getUpMoves
  - 다리 윗부분, 정답인 다리와 states 비교 후 List<String> 값으로 반환
* getDownMoves
  - 다리 아랫부분, 정답인 다리와 states 비교 후 List<String> 값으로 반환
* getUpMove
  - 다리 윗부분, 정답인 다리와 해당 index 의 state 비교 후 List<String> 값 갱신 후 반환
* getDownMove
  - 다리 아랫부분, 정답인 다리와 해당 index 의 state 비교 후 List<String> 값 갱신 후 반환
* updateMove
  - move 와 divisionOrNot 추가 후 List<String> 값 갱신 후 반환


<br/>

    - BridgeMaker (Class)
        다리 만들기 위해 필요한 메서드를 가진 클래스

* makeBridge()
    - 다리 길이만큼 다리 만드는 메서드


<br/>

    - BridgeValue (Class)
        다리 건너기 처리에 필요한 enum 모음 클래스 

* Information
    - 조건 상수 Enum
* Drawing
    - 다리 그리기에 필요한 상수 Enum

<br/>

    - GameMessage (Class)
        모든 메시지 enum 모음 클래스 

* Guide
    - 안내 메시지 Enum
* Exception
    - 예외 메시지 Enum
* Result
    - 결과 메시지 Enum
