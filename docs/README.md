## 기능 목록
- Domain
  - [x] 특정 길이의 다리 생성 - BridgeMaker#makeBridge()
  - [x] 입력한 이동 위치의 성공 여부 확인, 다리 이동시 사용할 메서드, (추가) 이동 위치 및 성공 여부에 따라 리스트에 데이터를 저장한다. - BridgeGame#move()
    - [x] 이동 위치에 따라 다른 리스트에 데이터 저장하는 클래스 생성 - BridgeMessageAdder, UpBridgeMessageAddStrategy, DownBridgeMessageAddStrategy
    - [x] 리스트를 활용해 출력할 메세지를 만들어 리턴 - BridgeGame#makeBridgeMessage()
  - [x] 게임을 다시 시도할 때 사용할 메서드 - BridgeGame#retry()
  - [x] 게임의 성공 여부를 확인하는 메서드 - BridgeGame#checkComplete()
  - [x] 게임 시도 횟수를 반환하는 getter 메서드 - BridgeGame#getRetyrNumber()
- View
  - [x] 다리 길이 입력 - InputView#readBridgeSize()
  - [x] 이동할 위치 입력 - InputView#readMoving()
  - [x] 재시도 여부 입력 - InputView#readGameCommand()
  - [x] BridgeGame 의 객체로부터 bridgeMessage 를 받아 다리 출력하기 - OutputView#printMap()
  - [x] 기타 안내용 출력 메시지 (시작, 길이입력 등..) - InputView
  - [x] 최종 결과, 성공여부, 시도 횟수 출력 - OutputView#printResult()
- Controller
  - [x] Domain 과 View 를 연결하기  - BridgeGameController
    - [x] bridge 및 BridgeGame, OutputView 객체 생성 - BridgeGameController#makeGame()
    - [x] makeGame 에서 생성한 객체로 게임 시작 및 진행하기 - BridgeGameController#startGame()
      - [x] move 에 실패한 경우 게임 종료 여부 입력받아 게임 진행 여부 반환하기 - BridgeGameController#quitGame()
    - [x] 게임 종료 메세지 출력하기 - BridgeGameController#endGame()
- Error
  - [x] 다리 길이가 숫자인지, 3이상 20이하 인지 확인 - ErrorControl#validateNumberOrNot(), validateBridgeSize()
  - [x] 입력한 문자가 verifier 와 동일한지 확인 - ErrorControl#validateLetter()
  - [x] 에러 발생 시 재시도할 수 있도록 검사 결과를 반환 - ErrorControl
- Application
  - [x] main() 을 통해 최종 구현 - Application#main() 

## 삭제한 기능 목록
- upBridge, downBridge 리스트를 반환하는 getter 메서드 - BridgeGame#getUpBridge(), getDownBridge()
- bridge 리스트에 저장된 데이터를 사용해 다리를 출력한다. - OutputView#printBridge()
- 이동 위치, 성공 여부에 따른 위치 출력
- 성공여부, 시도 횟수 출력
- 이동 위치 U,D 둘 중 하나인지 확인 (소문자는?)
- 재시도 여부 R,Q 둘 중 하나인지 확인

## 구현 사항
1. 생성할 다리의 길이를 입력받아 숫자 0, 1 로 이루어진 다리를 생성
2. 위:U, 아래:D 로 입력받고 일치 여부에 따른 다리를 출력
3. 중간에 오답인 경우 재시도: R, 종료: Q 로 입력받아 입력값에 따라 2. 다시 시작
4. 전부 정답 혹은 종료를 입력한 경우 가장 최근 다리를 최종 게임 결과로 출력하고, 성공여부, 총 시도 횟수를 출력한 후 프로그램 종료
5. 에러 발생시 틀린 값을 입력한 위치에서 다시 시작

## 제한 사항
1. 함수 길이 10라인 넘지 않도록.
2. 메서드의 파라미터는 최대 3개까지만.
3. InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스 아래 제한사항 지키며 활용
   - InputView : 변경 가능, Console.readLint() 사용해 입력 받기
   - OutputView : 메서드 이름 제외 변경 가능, 값 출력을 위해 필요한 메서드 추가
   - BridgeGame : 메서드 이름 제외 변경 가능, 인스턴스 변수, 게임 진행을 위해 필요한 메서드 추가 가능
   - BridgeMaker : 인스턴스 변수, 메서드 변경 불가. 추가는 가능??
   - BridgeRandomNumberGenerator : 코드 변경 X, Random 값 추출은 generate() 활용

## 3주차 공통 피드백
1. 발생할 수 있는 예외 상황에 대해 고민한다.
2. 비즈니스 로직과 UI 로직을 분리한다.
3. 연관성 있는 상수는 enum을 활용한다.
4. final 을 활용해 값의 변경을 막는다.
5. private 을 활용해 객체의 상태 접근을 제한한다.
6. 객체에서 데이터를 꺼내지 말고 메시지를 던지도록 데이터를 가지는 객체가 일하도록 한다.
   - (getter 사용하지 말고 객체에 메시지를 보내자)
7. 인스턴스 변수의 수를 줄이기 위해 노력한다.
   - 모든 데이터를 인스턴스 변수로 만들지 말고, 가장 근본 데이터만 저장하고 나머진 메서드로 구현한다.
8. 예외에 대한 케이스도 테스트한다.
9. 단위 테스트가 어려운 경우 테스트가 가능하게끔 변경해보자.

## 개인 목표
1. 객체를 객체답게 활용하기! getter 를 사용하기 전에 다른 방법이 있을지 고민해보기.
2. if 문을 사용하는 경우, 단순 else 를 사용하지 않는게 아니라 코드에 대해 고민해보기. if 조건문 실패시 다른걸 하는 방식은 else 를 사용하는 것과 크게 다르지 않는 것 같다..