## 기능 요구 사항

- 게임 시작 문구 (OUTPUTVIEW)

- 다리의 길이
  - 숫자로 입력 (INPUTVIEW)
    - 입력 문구 (OUTPUTVIEW)
  - 생성 (BRIDGEMAKER)
    - 다리 칸을 생성하기 위한 Random 값은 아래와 같이 추출한다. (BRIDGERANDOMGENERATOR)
      - int number = bridgeNumberGenerator.generate();

- 다리가 생성되면 
  - 플레이어가 이동할 칸을 선택. (INPUTVIEW)
    - 선택 문구 (OUTPUTVIEW)

- 다리를 건너다
  - 이동한 칸 표시 (OUTPUTVIEW)
  - 시도 횟수(BRIDGEGAME)
  - 게임 재시작 (BRIDGEGAME)
    - 선택 문구 (OUTPUTVIEW)
    - 선택 입력 (INPUTVIEW)

- 종료
  - 최종게임결과 (BRIDGEGAME)
    - 출력 (OUTPUTVIEW)
  - 게임 성공 여부 (BRIDGEGAME)
    - 출력문구 (OUTPUTVIEW)
  - 총 시도 횟수 (BRIDGEGAME)
    - 출력문구 (OUTPUTVIEW)
    
- 사용자가 잘못된 값을 입력할 경우 
  - IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 클래스별 정리
#### INPUTVIEW
- 다리 길이 숫자 입력
- 다리 이동 칸 입력 
- 게임 재시작 / 종료 입력

#### OUTPUTVIEW
- 게임 시작 문구 @ printGameStart
- 다리 길이 입력 문구 @ printBridgeSizeInput
- 다리 선택 문구 @ printMovingInput
- 다리 이동 표시 문구
- 게임 재시작/종료 선택 문구 @ printGameOver
- 최종 게임 결과 문구
- 게임 성공 여부 문구 @ printSuccess
- 게임 시도 횟수 문구 @ printTrialAmount
- 이동 불가능 칸 표시 @ printNotMovable
- 이동 가능 칸 표시 @ printMovable

#### BRIDGEGAME
- 시도 (다리 생성) 횟수 / 총 시도 횟수 @trialAmount
- 게임 재시작
- 게임 종료 @ gameOver
- 최종 게임 결과 @ finalResult
- 게임 성공 여부 @ gamePass
- 게임 실패 여부 @ gameEnd

#### BRIDGEMAKER
- 다리 생성


## 프로그래밍 요구 사항
### InputView 
- 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
  - 해당 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
- 제공된 클래스를 사용해야 하며, 패키지는 변경 가능하다
- 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 가능하다.

### OutputView
- 값 출력을 위한 메소드 추가 가능
- 메서드명 변경 불가
- 인자 / 반환 타입 추가 / 변경 가능

### BridgeGame
- 게임 진행을 위해 필요한 메서드 추가 / 변경 가능
- 클래스에서 InputView, OutputView 를 사용하지 않는다.
- 필드(인스턴스 변수)를 추가 가능
- 패키지 변경 가능
- 메서드명 변경 불가
- 인자 / 반환 타입 추가 / 변경 가능

### BridgeMaker
- 필드(인스턴스 변수) 변경 불가
- 메서드 시그니처 변경 불가

### BridgeRandomNumberGenerator
- Random 값 추출은 제공된 bridge.BridgeRandomNumberGenerator의 generate()를 활용한다.
- BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드는 변경할 수 없다.
