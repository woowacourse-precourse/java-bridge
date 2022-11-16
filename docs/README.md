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

    - AllMessage (Class)
        모든 메시지 enum 모음 클래스 

* GuideMessage
    - 안내 메시지 Enum
* ExceptionMessage
    - 예외 메시지 Enum
* ResultMessage
    - 결과 메시지 Enum
