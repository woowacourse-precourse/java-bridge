# 🦑 다리 건너기

> ## 🧭 OverView
>
> <img src="./bridgeUML.png" width="800">
> 
> 아래와 같은 MVC 패턴으로 설계
>
> | Model    |                   View                    |              Controller                |                     Enum                     |
> ----------|:-----------------------------------------:|:-------------------------------------:|:--------------------------------------------:|
>  BridgeGame | BridgeView <br/> InputView<br/>OutPutView | BridgeController<br/>ExceptionHandler| Command<br/>Glass<br/>Message<br/>State<br/> | 

>### 🏗 BridgeGame
> * Bridge 관련 정보를 저장하는 모델
>
> 
> ### Method List
> 
>| No. | 함수명           | 기능                                        | 
>---|:--------------|:------------------------------------------|
>1 | history()     | 현재까지 user가 지나온 bridge 리턴                  |
>2 | playTime()    | playTime(플레이 횟수) 리턴                       |
>3 | move()        | Controller로부터 전달받은 칸으로 이동                 |
>4 | retry()       | 게임 재시작                                    |
>5 | buildBridge() | 전달받은 String List를 Glass List로 변환 후 필드에 저장 |
>6| isLastGlass()       | Bridge와 최종 State로 유저의 이동 방향을 도출             | 
>7| isLastState()       | 유저의 State를 도출, 전달받은 최종 State 외에 모두 SAFE로 처리 | 
>8| updateMap()         | 지나온 Bridge UI를 UP, DOWN 별로 생성               | 
>9| combineMap()        | UP/DOWN Bridge UI를 연결해 최종 UI 생성             | 
>10| drawMap()           | 현재까지 진행한 Bridge 현황 UI 생성                    | 
>11| drawResult()        | 최종 결과 UI 생성                                 | 



>### 👁 BridgeView
>
> * 입출력을 수행하는 UI
> * **InputView**와 **OutputView**을 필드로 삼아 동작
> ### Method List
>
>| No.          | 함수명                 | 기능                      |   분류   |
>------------|:--------------------|:------------------------|:------:|
>1 | sizeIO()            | 유저로부터 Bridge의 길이를 입력 받음 |  I/O   |
>2| moveIO()            | 유저로부터 이동할 칸을 입력 받음      |  I/O   |
>3| commandIO()         | 유저로부터 게임 진행 여부를 입력 받음   |  I/O   |
>4| printMap()          | 현재까지 진행한 Bridge 현황 출력   | OUTPUT |
>5| printStartMessage() | 시작 메시지 출력               | OUTPUT |
>6| printResult()       | 최종 결과 출력                | OUTPUT |
>7| printErrorMessage() | 에러 메시지 출력               | OUTPUT |

>### 👁 InputView
>
> * 입력을 수행하는 UI
> ### Method List
>
>| No.          | 함수명                 | 기능                                          |   
>------------|:--------------------|:--------------------------------------------|
>1 | readBridgeSize()    | 유저로부터 Bridge의 길이를 입력 받음                     | 
>2| readMoving()        | 유저로부터 이동할 칸을 입력 받음                          | 
>3| readGameCommand()   | 유저로부터 게임 진행 여부를 입력 받음                       | 

>### 👁 OutputView
>
> * 출력을 수행하는 UI
> ### Method List
> 
>| No.          | 함수명                   | 기능                      |  
>------------|:----------------------|:------------------------|
>1| printMap()            | 현재까지 진행한 Bridge 현황 출력   | 
>2| printResult()         | 최종 결과 출력                | 
>3| printStartMessage()   | 시작 메시지 출력               |
>3| printSizeMessage()    | Bridge 사이즈 입력 안내 메시지 출력 |
>3| printMoveMessage()    | 이동 방향 입력 안내 메시지 출력      |
>3| printCommandMessage() | 게임 진행 여부 입력 안내 메시지 출력   |
>3| printErrorMessage()   | 에러 메시지 출력               |



>### 🕹 BridgeController
> * Bridge 게임을 진행하는 도메인 로직
> * BridgeGame과 BridgeView를 조작
> * BridgeMaker를 상속
>
> ### Method List
>
>| No.         | 함수명          | 기능                              | 
>------------|:-------------|:--------------------------------|
>1 | initGame()   | 게임 시작                           | 
>2| makeBridge() | Bridge 제작                       |
>3 | playGame()   | 게임 진행                           | 
>5| getSize()    | Bridge의 size를 입력 받음             |
>6| getMove()    | 다음 칸을 입력 받고, 이동 후 State를 리턴     |
>7| getCommand() | 재시작 혹은 종료 요청을 입력 받음             |
>8| dead()       | 유저 입력에 따라 재시작("R") 혹은 종료("Q") 수 |
>9| quitGame()   | 게임 종료                           | 
>10| retryGame()  | 게임 재시작                          | 



> ### 💣 ExceptionHandler 
> * 예외처리
>
> ### Method List
>
>| No.          | 함수명                   | 기능                                  |         대상          |
>------------|:----------------------|:------------------------------------|:-------------------:|
>1 | validBridgeSize()     | 다리 사이즈가 올바르게 입럭되었는지 검증              |    BridgeView #1    |
>2| validMoving()         | 이동 값이 올바르게 입력되었는지 검증                |    BridgeView #2    |
>3| validGameController() | 게임 진행 여부가 올바르게 입력되었는지 검증            |    BridgeView #3    |
>4| excParseInt()         | 입력받은 문자열의 정수로 변환이 가능한지 검증한 후 정수로 변환 |    BridgeView #1    |
>5| viewControlByError()  | 에러로 진행 중이던 입력 작업을 판별, 해당 작업을 재실행    | BridgeView #1,#2,#3 |
>6| reEnter()             | 에러가 발생하지 않을 때까지 특정 입력 작업을 반복        | BridgeView #1,#2,#3 |

