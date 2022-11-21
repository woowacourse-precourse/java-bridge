# 📄 기능 목록

---

### 1. 기능 전체 목록

- 다리 건너기 게임 시작 안내문 출력 기능
- 다리 길이 입력 안내문 출력 기능
- 다리 길이 입력 기능
- 입력된 길이만큼 다리를 생성하는 기능
- 이동할 칸 선택 안내문 출력 기능
- 이동할 칸 입력 기능
- 입력된 값으로 이동하고 결과를 반환하는 기능
- 건너기 가능 여부에 따라 다리를 그리는 기능
- 그려진 다리를 출력하는 기능
- 게임 재시작 여부 안내문 출력 기능
- 게임 재시작 여부 입력 기능
- 게임 재시작 시 동작(다리 상태 초기화, 시도 횟수 증가 등) 기능
- 게임 성공 여부 출력 기능
- 총 시도 횟수 출력 기능



### 2. 예외 사항 전체 목록

**예외 발생 시, `IllegalArgumentException` 발생 및 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.**

- 사용자 입력이 비어있는 경우
- 사용자 입력이 숫자, U, D, R, Q가 아닌 경우
- 입력된 다리 길이가 3~20이 아닌 경우
- 입력된 이동할 칸이 U 혹은 D가 아닌 경우
- 입력된 게임 재시작 여부 값이 R 혹은 Q가 아닌 경우



### 3. 기능 정리

#### < Model >

- 다리 : Bridge
  - 필드
    - 다리 리스트 (static) : bridge
    - 다리 생성 여부 (static) : bridgeCreated
  - 모델에서 다리를 생성하는 것이 아닌, 생성자에서 파라미터로 다리를 전달받아 저장만 함. : setBridge()
  - 칸 별로 건널 수 있는지 여부 boolean 타입 반환 : checkMovingPossibility()
  - 다리의 크기를 반환함 : getBridgeSize()


- 다리를 건넌 기록 : CrossRecord
  - 필드
    - 건넌 기록 (static) : crossedBridge
    - 첫칸 그리는지 여부 (static) : isFirst
  - 건넌 기록 추가하는 기능 : recordCrossedBridge()
  - 건넌 기록 리셋 기능 : resetCrossedBridge()
  - 건넌 기록 반환 기능 : getCrossedBridge()


- 게임 결과 정보 : GameResultInformation
  - 필드
    - 게임 성공 여부 : GAME_RESULT
    - 총 시도한 횟수 : countOfTry
  - 게임 성공 여부 설정 기능 : setGameResult()
  - 시도 횟수 증가 기능 : increaseCountOfTry()
  - 게임 성공 여부 반환 기능 : getGameResult()
  - 총 시도 횟수 반환 기능 : getCountOfTry()

#### < View >

- InputView
  - 다리 길이 입력 기능 : readBridgeSize()
  - 이동할 칸 입력 기능 : readMoving()
  - 게임 재시작 여부 입력 기능 : readGameCommand()


- OutputView
  - 다리 건너기 게임 시작 안내문 출력 기능 : printStartGuide()
  - 다리 길이 입력 안내문 출력 기능 : printInputBridgeLengthGuide()
  - 이동할 칸 선택 안내문 출력 기능 : printInputMoveDirectionGuide()
  - 그려진 다리를 출력하는 기능 : printMap()
  - 게임 재시작 여부 안내문 출력 기능 : printRetryGuide()
  - 게임 최종 결과 출력 기능 : printResult()
  - 공백 출력 기능 : printEmptyLine()

#### < Controller >

- BridgeGame
  - 입력된 값으로 이동하고 결과를 반환하는 기능 : move()
  - 게임 재시작 시 동작(다리 상태 초기화, 시도 횟수 증가 등) 기능 : retry()


- BridgeGameOperator
  - 게임 운영 기능 : playBridgeGame()

#### < Constants >

- 안내 문장들 : GuideSentences
    - 게임 시작 안내 (`다리 건너기 게임을 시작합니다.`)
    - 다리 길이 입력 안내 (`다리의 길이를 입력해주세요.`)
    - 이동할 칸 입력 안내 (`이동할 칸을 선택해주세요. (위: U, 아래: D)`)
    - 게임 재시도 여부 입력 안내 (`게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)`)
    - 게임 결과 안내 (`최종 게임 결과`)
    - 게임 성공 여부 안내 (`게임 성공 여부: `)
        - `: `의 우측 공백 포함
    - 시도 횟수 안내 (`총 시도한 횟수: `)
        - `: `의 우측 공백 포함


- 다리 표현 문자 : BridgeDrawer
  - 다리 시작 (`[` 우측 공백 포함)
  - 다리 끝 (`]` 좌측 공백 포함)
  - 칸 나누기 (`|` 양측 공백 포함
  - 건너지 않은 다리 공백 (` `)


- 건너기 가능 여부 : MovingPossibility
  - 가능 (`O`)
  - 불가능 (`X`)


- 방향 : Direction
  - 위 칸 (`U`)
  - 아래 칸 (`D`)


- 게임 결과 : GameResult
  - 성공 (`성공`)
  - 실패 (`실패`)


#### < Root >
- BridgeMaker
  - 입력된 길이만큼 다리를 생성하는 기능 : makeBridge()


### 4. 예외 사항 정리

**예외 발생 시, `IllegalArgumentException` 발생 및 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.**

##### < 예시 >

- 사용자 입력 관련 예외 : InputExceptionHandler
  - 공통 예외 : handleCommonException()
    - 사용자 입력이 비어있는 경우 예외 처리 : handleEmptyInputException()
    - 사용자 입력이 숫자, 알파벳이 아닌 경우 예외 처리 : handleNotNumberOrAlphabetException()
  - 다리 길이 입력 : handleBridgeSizeInputException()
    - 숫자가 아닌 경우 예외 처리 : handleNotNumberException()
  - 이동할 칸 및 게임 재시작 여부 입력 : handleMoveAndRetryException()
    - 대문자 알파벳이 아닌 경우 예외 처리 : handleNotUpperAlphabetException()


- 로직 내 예외
  - Bridge : BridgeExceptionHandler
    - 다리 생성 기능
      - 다리 구성에 U, D 외에 다른 문자가 있을 경우 예외 처리 : handleNotOnlyUOrDException()
    - 건너기 가능 여부 확인 기능
      - 다리 생성 전 건너기 가능 여부 확인 시 예외 처리 : handleBridgeNotCreatedException()
      - 다리의 마지막 인덱스보다 크거나 0보다 작은 숫자를 전달받을 시 예외 처리 : handleCheckSpaceOutOfRangeException()
    - 다리 길이 반환 기능
      - 다리 생성 전 다리 길이 확인 시 예외 처리 : handleBridgeNotCreatedException()
  - BridgeGameOperator : GameOperatorExceptionHandler
    - 다리 길이 입력받는 기능 (setBridge())
      - 입력된 값이 3~20의 범위 내 숫자가 아닐 경우 예외 처리 : handleBridgeSizeOutOfRangeException()
    - 방향 입력받는 기능 (getDirection())
      - 입력된 값이 U 혹은 D가 아닐 경우 예외 처리 : handleNotUOrDException()
    - 게임 재시작 여부 입력받는 기능 (isRetrySelected())
      - 입력된 값이 R 혹은 Q가 아닐 경우 예외 처리 : handleNotROrQException()

### 5. 개발 순서

1. (Constants) Constants 전체
2. (Model) Model 전체
3. (View) `게임 시작 ~ 이동할 칸 선택`까지 안내문 출력 기능
4. (Root) 입력된 길이만큼 다리를 생성하는 기능
5. (Controller) 입력된 값으로 이동하고 결과를 반환하는 기능
6. (View) 다리 길이 입력 기능
7. (View) 이동할 칸 입력 기능
8. (View) 그려진 다리 출력 기능
9. (Controller) `게임 시작 ~ 이동한 다리 출력`까지의 게임 운영 기능
10. (View) 게임 재시작 여부 안내문 출력 기능
11. (Controller) 게임 재시작 시 동작 기능
12. (View) 게임 재시작 여부 입력 기능
13. (Controller) `게임 시작 ~ 재시작 여부에 따른 동작`까지의 게임 운영 기능
14. (Controller) 성공 여부에 따라 게임 결과에 반영하는 기능
15. (View) 게임 성공 여부 출력 기능
16. (View) 총 시도 횟수 출력 기능
17. (Controller) 게임 전체 동작 과정 운영 기능
18. (Exception) 예외 처리 구현 및 전체 적용



### 6. 요구 사항 체크 리스트

#### <프로그래밍 요구 사항>

- ##### 기본 요구 사항

  - JDK 11
  - 시작점 : Application.main()
  - build.gradle 수정 금지, 외부 라이브러리 사용 금지
  - **JAVA 코드 컨벤션 적용**
  - System.exit() 금지
  - **ApplicationTest 모두 성공**
  - 파일, 패키지 이름 수정 or 이동 금지
  - 3항 연산자 금지
  - **함수 최대한 작게**
  - **JUnit, AssertJ 활용 테스트 코드 작성**
  - **indent depth 3 이상 금지, 2까지만 허용**
  - **else 금지**
  - **도메인 로직에 단위 테스트 구현. UI 로직은 제외**
  - **핵심 로직과 UI 담당 로직을 분리**

- ##### 추가 요구 사항

  - **함수 길이 10라인 이상 금지 + 한 가지 일만 잘 하도록**
  - 메서드 파라미터 개수 최대 3개까지만 허용
  - 주어진 클래스 활용
    - `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator`

- ##### 라이브러리 관련 요구 사항

  - **`camp.nextstep.edu.missionutils.Console.readLine` 활용**

- ##### Class 관련 요구 사항

  ##### < 공통 >

  - InputView에서만 Console.readLine() 사용 가능

  - 랜덤 수 뽑을 때는 BridgeRandomNumberGenerator의 generate() 함수 활용.

    - 해당 클래스와 BridgeNumberGenerator 인터페이스는 수정 금지

    ```java
    int number = bridgeNumberGenerator.generate();
    ```



##### < InputView >

- 가능한 사항
  - 패키지 변경
  - 메서드 시그니처(인자, 이름) 변경
  - 반환 타입 변경
  - 메서드 추가

##### < OutputView >

- 가능한 사항
  - 패키지 변경
  - 메서드 인자와 반환 타입 추가 or 변경
  - 메서드 추가
- 불가능한 사항
  - 메서드 이름 변경

##### < BridgeGame >

- 가능한 사항
  - 필드(인스턴스 변수) 추가
  - 패키지 변경
  - 인자와 반환 타입 추가 or 변경
  - 메서드 추가
- 불가능한 사항
  - 메서드 이름 변경
  - InputView 사용
  - OutputView 사용

##### < BridgeMaker >

- 불가능한 사항
  - 필드(인스턴스 변수) 변경
  - 메서드의 시그니처(인자, 이름) 변경
  - 반환 타입 변경

##### < BridgeRandomNumberGenerator >

- 해당 클래스에서 제공되는 generate() 함수로 0 or 1 랜덤 값 뽑으면 된다.
- 변경은 금지.

#### <과제 진행 요구 사항>

- Fork & Clone
- 구현 전 docs/README.md 기능 목록 정리
- 커밋은 기능 목록 단위로
- 커밋 메세지 컨벤션