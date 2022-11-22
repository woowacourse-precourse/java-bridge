## 🚀 게임 목표
- 위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

## domain 기능 목록

### BridgeMaker
 - [x] 다리를 생성한다 - makeBridge()
 - [x] 0과 1로 구성된 list를 생성한다 - generateNumbers()
 - [x] 0을 "D"로 1을 "U"로 변경한다 - numbersToUpAndDown()
 - [x] 입력받은 크기만큼 위의 작업을 수행하며 bridge를 만든다 - convertNumbersToUpAndDown()

### BridgeGame
- [x] U, D를 입력받고, 정답인지 판별한 뒤 결과를 반환한다 - move()
- [x] 사용자의 입력과 해당 입력이 다리의 정답과 맞는지 비교하여 PASS, FAIL, SUCCESS 반환 - compareInputWithBridge()
- [x] 결과가 PASS이면 stage를 1 증가한다 - pass()
- [x] 정답을 다 맞히어 성공하였을 때 게임을 종료하기 위해 예외를 발생시킨다 - success()
- [x] 중간에 게임을 포기한 경우 게임을 종료하기 위해 예외를 발생시킨다 - quit()
- [x] 사용자가 게임에 실패하고 재도전을 하면 stage를 0으로 초기화하고 retry를 1 증가한다 - retry()
 

### BridgeStage
 - [x] 현재 단계를 알려준다 - currentStage()
 - [x] 단계를 증가한다 - nextStage()
 - [x] 단계를 초기화 한다 - resetStage()
 - [x] 현재 재도전 횟수를 알려준다 - getRetry()
 - [x] 재도전 횟수를 증가시킨다 - increaseRetry()
 - [x] 현재 stage가 마지막 stage인지 알려준다 - isFinalStage()


### BridgeController
- [x] 다리 크기를 입력받아 다리를 생성한다 - createBridge()
- [x] 생성한 다리를 BridgeGame에 주입한다 - initBridge()
- [x] 다리를 생성한 뒤 사용자가 입력한 입력값에 따른 결과를 반환한다 - processGame()
- [x] 받은 결괏값에 따라 기능을 수행한다 - processResult()
  - [x] 결과가 SUCCESS이면 bridge의 pass()를 실행한다.
  - [x] 결과가 SUCCESS이면 게임을 종료한다.
  - [x] 결과가 FAIL이면 재시작 여부를 물어본다 - decideRetryOrQuit
      -[x] Q를 입력하였을 때 게임을 종료한다.
      -[x] R을 입력하였을 때 BridgeGame의 retry()를 실행한다.
- [x] 위 기능들을 조합해 전체적인 게임을 실행한다 - playWithExceptionCatch()

### BridgeConfig
 - [x] 의존관계를 주입해주고 객체를 생성한다

---

## UI 기능 목록
### InputView
 - [x] 다리의 길이를 입력받는다 - readBridgeSize()
   - [x] 사용자가 이동할 칸을 입력받는다 - readMoving()
   - [x] 게임을 종료할지 재시작할지 입력받는다 - readGameCommand()

### OutputView
 - [x] 게임 진행 메시지를 출력한다 - printMessage()
 - [x] 게임을 진행하면서 사용자의 입력에 대한 map을 출력한다 - printMap()
    - [x] 사용자의 입력이 정답인지 판별하여 O,X 중 하나를 반환한다 - decideOX()
    - [x] 사용자의 입력이 "U"이면 결과를 key가 UP인 stack에 저장한다 - saveUserInput()
    - [x] 사용자의 입력이 "D"이면 결과를 key가 DOWN인 stack에 저장한다 - saveOppositeSide()
    - [x] key가 UP인 stack과 key가 DOWN인 stack을 합쳐 하나의 String으로 만들어 반환한다 - convertMapToString()
 - [x] 사용자의 입력을 괄호로 감싸서 저장한다 - save()
    - [x] 사용자의 입력을 저장하기 전 stack이 비어있으면 "["를 추가한다 - checkStackIsEmpty()
    - [x] 사용자의 입력을 저장한 뒤 "]" 를 추가한다 - addCloseBrackets()
    - [x] 사용자의 입력을 저장하기 전에 stack 상단에 "]"이 존재하면 stack에서 꺼낸 뒤 "|"를 넣는다 - checkBrackets()
 - [x] 사용자가 게임을 재시작하면 map을 초기화한다 - resetMap()
 - [x] 게임을 성공하면 최종 게임 결과를 출력한다 - printResult()

---
## 예외검사
### Validator
 - [x] 사용자의 입력이 숫자 형식이 아닌 다른 형식을 입력하면 예외를 반환한다 - validateInputIsNumber()
 - [x] 사용자가 입력한 다리의 크기가 3 ~ 20이 아니라면 예외를 반환한다 - validateBridgeSize()
 - [x] 사용자가 이동 입력이 "U", "D"가 아니라면 예외를 반환한다 - validateMove()
 - [x] 중간에 게임을 실패한 후 다시 시작에 대한 사용자의 입력이 "Q", "R"가 아니라면 예외를 반환한다() - validateGameCommand()
