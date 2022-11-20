# 미션: 다리건너기

-------------------
## 기능 목록 및 제공 클래스 정리
![다리건너기](https://user-images.githubusercontent.com/54941130/202209453-f3d26487-10c2-4298-a7c9-629e03267ea9.png)

-------------------
## 사용할 메소드

<br/>

#### 다리 생성시, `bridge.BridgeRandomNumberGenerator` 의 `generate()` 메소드 이용

예) 
``` java
int number = bridgeNumberGenerator.generate();
```

#### 입력 받을 시, `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메소드 이용

예)
``` java
String answer = readLine();
```
-------------------
### 생각 해야 할 것!
1. InputView 에 있는 OutputView 객체 제거해보기
2. UI 메세지들 모두 모아서 처리해보기..?
3. main 함수 줄 10줄 넘어감. 분리 필요!
-------------------
## 필요한 기능 목록

- [X] 다리 생성하기
- [X] 이동할 위치 입력받기
- [X] 이동시, 가능 유무와 함께 다리 출력하기
- [X] 다리 건너기 실패 &rarr; 게임 재시작 or 종료 입력 받기
- [X] 재시작시, 기존 다리 재사용하기
- [ ] 다리 건너기 성공 &rarr; 게임 종료
- [ ] 게임 종료시, 성공 여부와 시도 횟수 출력하기
- [ ] 예외처리 &rarr; `[ERROR]`와 같이 오류 메세지 출력 후, 그 부분부터 다시 입력받기
-------------------
### 0. 생각에 없던 기능 목록
#### 추가한 기능 목록
###### OutputView
    1. printGameStart()
        게임 시작 문구 출력
-------------------
###### Application
    1. settingGame()
        게임 준비(인사, 다리 출력)
    2. runningGame()
        게임 실행
        2-1. moving()
            다리를 이동함
        2-2. playAgain()
            다시 플레이하는 기능
    3. closingGame()
        게임 종료
-------------------
### 1. 다리 생성하기

#### 추가한 기능 목록
###### BridgeMaker
    1. MAX_BRIDGE_SIZE와 MIN_BRIDGE_SIZE
        다리의 크기 범위를 갖고있는 상수 추가
    2. makeBridge()
        세부 내용 작성: size를 받아와, size만큼의 크기를 가지는 랜덤 다리를 생성하여 반환.
    3. choiceUpDown()
        이번 다리의 UP or DOWN을 랜덤하게 결정해줌: bridgeNumberGenerator.generate() 이용
###### InputView
    1. readBridgeSize()
        세부 내용 작성: try-catch 구문을 이용하여 다리 크기를 입력 받음. 
            오류 발생시, OutputView의 printError로 오류 출력 후 다시 입력 받기
    2. validateSizeNotNumber()
        입력 값이 숫자로 이루어져있으면, int로 변환하여 반환
        입력 값이 숫자가 아니라면, 에러를 발생시키고 "다리 길이는 숫자를 입력해야 합니다." 를 에러메세지로 넘김.
    3. validateSizeOutOfRange()
        입력 값이 범위를 벗어났으면, 에러를 발생시키고 "다리 길이는 3부터 20 사이의 숫자여야 합니다."를 에러메세지로 넘김.
###### OutputView
    1. printAskBridgeSize()
        다리의 크기를 물어보는 문구 출력

-------------------
### 2. 이동할 위치 입력받기

#### 추가한 기능 목록
###### BridgeGame
    1. List<String> bridge
        BridgeMaker 클래스를 통해, 만든 다리를 저장할 필드 추가
    2. BridgeGame() 생성자 추가
        만들어진 다리를 받아서 BridgeGame 객체를 생성하도록 생성자 추가
    3. move()
        인자로 String movement를 받아오도록 함.
###### InputView
    1. readMoving()
        세부 내용 작성: try-catch 구문을 이용하여 움직임 입력 받음.
            오류 발생시, OutputView의 printError로 오류 출력 후 다시 입력 받기
    2. validateMovement()
        입력 값이 'U' 또는 'D'가 아니라면, 에러를 발생시키고 "이동할 칸은 'U' 또는 'D' 만 입력 가능합니다." 를 에러메세지로 넘김.
###### OutputView
    1. printAskMovement()
        움직일 위치를 물어보는 문구 출력

-------------------
### 3. 이동시, 가능 유무와 함께 다리 출력하기

#### 추가한 기능 목록
###### BridgeGame
    1. List<String> moveResult
        move()를 통해 움직였을 때, 움직인 결과를 저장할 필드 추가
    2. move()
        세부 내용 작성: 움직인 결과(O or X)를 moveResult에 저장
        움직인 결과를 boolean 으로 리턴함(성공:true, 실패:false)
###### OutputView
    1. printMap()
        세부 내용 작성: 위쪽 다리 출력, 아래쪽 다리 출력
    2. bridgeOfTop()
        위쪽 다리 만들어, String으로 반환
        2-1. checkMoveTop()
            마지막 이동을 제외한 나머지 이동 중, 위쪽으로 이동한 것을 체크(위쪽 이동 시 O, 아래쪽 이동 시 공백 추가)
        2-2. checkLastMoveTop()
            마지막 이동에서 위쪽으로 이동했는지 체크(위쪽 이동이면서 성공 시 O, 실패 시 X 추가, 아래쪽 이동이면 공백 추가)
    3. bridgeOfBottom()
        아래쪽 다리 만들어, String으로 반환
        3-1. checkMoveBottom()
            마지막 이동을 제외한 나머지 이동 중, 아래쪽으로 이동한 것을 체크(아래쪽 이동 시 O, 위쪽 이동 시 공백 추가)
        3-2. checkLastMoveBottom()
            마지막 이동에서 아래쪽으로 이동했는지 체크(아래쪽 이동이면서 성공 시 O, 실패 시 X 추가, 위쪽 이동이면 공백 추가)
-------------------
### 4. 다리 건너기 실패 &rarr; 게임 재시작 or 종료 입력 받기

#### 추가한 기능 목록
###### Application
    1. boolean playing field 추가
        while문을 돌며, move를 하고, 성공 여부를 받아 playing에 저장.
        playing이 false가 되면(move 실패 시), retry를 입력받음.
###### InputView
    1. readGameCommand()
        세부 내용 작성: try-catch 구문을 이용하여 게임 커맨드를 입력받음.
            오류 발생시, OutputView의 printError로 오류 출력 후 다시 입력 받기
    2. validateGameCommand()
        입력 값이 'R' 또는 'Q'가 아니라면, 에러를 발생시키고 "커맨드는 'R' 또는 'Q' 만 입력 가능합니다." 를 에러메세지로 넘김.
###### OutputView
    1. printAskRetry()
        다시하기 여부를 묻는 문구 출력
-------------------
### 5. 재시작시, 기존 다리 재사용하기
    포인트는 재시작시, 새로운 BridgeGame 객체를 사용하는 것이 아니라,
    기존 객체를 사용하며, 그 안의 List<String> moveResult 만 다시 초기화하여 구현.
#### 추가한 기능 목록
###### BridgeGame
    1. retry()
        세부 내용 작성: 받은 값이 "R" 이면, moveResult를 초기화 시켜주고 true 반환
            -> Application의 playing이 true로 변경되어 다시 실행 가능.
-------------------
### 6. 다리 건너기 성공 &rarr; 게임 종료

#### 추가한 기능 목록

-------------------
### 7. 게임 종료시, 성공 여부와 시도 횟수 출력하기

#### 추가한 기능 목록

-------------------
### 8. 예외처리 &rarr; `[ERROR]`와 같이 오류 메세지 출력 후, 그 부분부터 다시 입력받기

#### 추가한 기능 목록
###### OutputView
    1. ERROR_MESSAGE = "[ERROR]"
        에러메세지의 시작 부분을 가진 상수 추가.
    2. printError()
        에러를 받아와, 에러메세지를 ERROR_MESSAGE와 결합하여 출력.

-------------------
