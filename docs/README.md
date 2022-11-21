## 🚀 게임 목표
- 위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

## domain 기능 목록

### BridgeMaker(나중에 메서드 이름 알기 쉽게 변경하기)
 - [x] 다리를 생성한다
 - [x] 0과 1중 무작위 값을 생성한다
 - [x] 0을 "D"로 1을 "U"로 변경한다
 - [x] 입력받은 크기만큼 위의 작업을 수행하며 bridge를 만든다

### BridgeGame
 - [x] 위, 아래중 입력을 받아 해당 입력을 record에 저장 - move()
 - [x] 사용자의 입력과 해당 입력이 다리의 정답과 맞는지 비교하여 PASS, FAIL, SUCCESS 반환 - compareInputWithBridge()
 - [x] move()와 compareInputWithBridge()를 조합하여 한 단계를 진행 한 후 결과 반환- processStage()
 - [x] 결과가 PASS이면 Stage단계를 증가한다
 - [x] 사용자가 게임에 실패하고 재도전을하면 stage와 record를 초기화 한다
 

### BridgeStage
 - [x] 현재 단계를 알려준다
 - [x] 단계를 증가한다
 - [x] 단계를 초기화 한다

### BridgeRecord
 - [x] 현재 사용자의 입력이 저장된 record 반환
 - [x] 사용자의 입력을 record에 저장
 - [x] 현재 사용자의 입력이 저장된 record 초기화

### BridgeController
 - [x] 다리 크기를 입력받아 다리를 생성한다 - initBridge()
 - [x] BridgeGame의 processStage() 결과를 받아 PASS, FAIL, SUCCESS에 대응하는 기능 실행 - processResult()
 - [ ] 결과가 FAIL이면 재시작 여부를 물어본다
 - [ ] 결과가 SUCCESS이면 최종결과와 시도횟수를 출력 한 뒤 종료한다
 - [ ] 구현된 기능을 통해 전체적 게임을 진행한다 - processGame()
 

---

## UI 기능 목록
### InputView
 - [x] 다리의 길이를 숫자로 입력받는다.
 - [x] 다리가 생성되면 플레이어가 이동할 칸을 선택한다.

### OutputView
 - [x] 게임 진행 메시지를 출력한다
 - [ ] 게임을 진행하면서 사용자의 입력에 대한 map을 출력한다
    - [x] 사용자의 입력이 정답인지 판별하여 O,X중 하나를 반환한다
    - [x] 사용자의 입력이 "U"이면 윗쪽, "D"이면 아래쪽에 사용자 입력 결과를 저장한다  
    - [ ] stack에 저장된 값들을 출력 형식에 맞게 변환한다
 - [ ] 사용자가 게임을 재시작하면 map을 초기화한다
 - [ ] 게임을 성공하면 최종 게임 결과를 출력한다

---
## 예외검사
### Validator
 - [x] 사용자의 입력이 숫자 형식이 아닌 다른 형식을 입력하면 예외를 반환한다 - validateInputIsNumber()
 - [x] 사용자가 입력한 다리의 크기가 3 ~ 20이 아니라면 예외를 반환한다 - validateBridgeSize()
 - [x] 사용자가 이동 입력이 "u", "D"가 아니라면 예외를 반환한다 - validateMove()
 - [x] 중간에 게임을 실패한 후 다시 시작에 대한 사용자의 입력이 "Q", "R"가 아니라면 예외를 반환한다() - validateGameCommand()
