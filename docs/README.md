# 🦑 다리 건너기

> ## 🧭 OverView
>
> <img src="./bridgeUML.png" width="800">
> 
> 아래와 같은 MVC 패턴으로 설계
>
> | Model    |                   View                    |              Controller                |
> ----------|:-----------------------------------------:|:-------------------------------------:|
>  BridgeGame | BridgeView <br/> InputView<br/>OutPutView | BridgeController<br/>ExceptionHandler| 

>### 🏗 BridgeGame
> * Bridge 관련 정보를 저장하는 모델
>
> 
> ### Method List
> 
>| No. | 함수명    | 기능                                   | 
>-----|:-------|:-------------------------------------|
> 1   | history()| 현재까지 user가 지나온 bridge 리턴                                |
>| 2   | step() |  step(user가 지나온 칸의 수) 리턴            |
>| 3   | play() |  play(플레이 횟수) 리턴            |
>| 4   | move() | Controller로부터 전달받은 칸으로 이동            |
>| 5   | retry() | 게임 재시작           |
>| 6   | buildBridge() | 전달받은 String List를 Glass List로 변환 후 필드에 저장            |



>### 👁 BridgeView
>
> * 입출력을 수행하는 UI
> * **InputView**와 **OutputView**을 필드로 삼아 동작
> ### Method List
>
>| No.          | 함수명               | 기능                                          |   분류   |
>------------|:------------------|:--------------------------------------------|:------:|
>1 | readBridgeSize()  | 유저로부터 Bridge의 길이를 입력 받음                     | INPUT  |
>2| readMoving()      | 유저로부터 이동할 칸을 입력 받음                          | INPUT  |
>3| readGameCommand() | 유저로부터 게임 진행 여부를 입력 받음                       | INPUT  |
>4| printMap()        | 현재까지 진행한 Bridge 현황 출력                       | OUTPUT |
>5| printResult()     | 최종 결과 출력                                    | OUTPUT |
>6| printErrorMessage() | 에러 메시지 출력 | OUTPUT|
>7| getDirection()    | Bridge와 최종 State로 유저의 이동 방향을 도출             | OUTPUT |
>8| getState() | 유저의 State를 도출, 전달받은 최종 State 외에 모두 SAFE로 처리 | OUTPUT|
>9| updateMap()       | 진행한 Bridge 현황 UI를 UP, DOWN 별로 생성            | OUTPUT |
>10|drawMap() | 현재까지 진행한 Bridge 현황 UI 생성                    | OUTPUT|
>111|drawResult()| 최종 결과 UI 생성                                 | OUTPUT|                                     

>### 🕹 BridgeController
> * Bridge 게임을 진행하는 도메인 로직
> * BridgeGame과 BridgeView를 조작
> * BridgeMaker를 상속
>
> ### Method List
>
>| No.         | 함수명          | 기능             | 
>------------|:-------------|:---------------|
>1 | initGame()   | 게임 시작          | 
>2| makeBridge() | Bridge 제작      |
>3 | playGame()   | 게임 진행          | 
>4| moveTo()     | 다음 칸으로 이동      |
>5| judge()      | 이동한 칸이 유효한지 판정 |
>6| dead()       | 빈 칸으로 이동해 사망   |
>7| clear()      | 게임 클리어 |
>7| quitGame()   | 게임 종료          | 
>8| retryGame()  | 게임 재시작         | 



> ### 💣 ExceptionHandler 
> * 예외처리
>
> ### Method List
>
>| No.          | 함수명                   | 기능                                  |      대상       |
>------------|:----------------------|:------------------------------------|:-------------:|
>1 | validBridgeSize()     | 다리 사이즈가 올바르게 입럭되었는지 검증              | BridgeView #1 |
>2| validMoving()         | 이동 값이 올바르게 입력되었는지 검증                | BridgeView #2 |
>3| validGameController() | 게임 진행 여부가 올바르게 입력되었는지 검증            | BridgeView #3 |
>4| excParseInt() | 입력받은 문자열의 정수로 변환이 가능한지 검증한 후 정수로 변환 | BridgeView #1 |

