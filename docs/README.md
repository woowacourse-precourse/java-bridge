# 기능 목록
- [x] 다리의 길이를 입력받는다. (테스트 완료)
   - [x] 입력값이 유효한지 확인한다. -> 3 이상 20 이하의 숫자인가?
  

- [x] 다리를 생성한다. (테스트 완료)
   - [x] 0과 1 중의 무작위 값을 통해 0이면 아래 칸, 1이면 위 칸이 건너갈 수 있는 칸인지를 위해 'U' 또는 'D'로 값을 저장했는가?


- [x] 플레이어가 이동할 칸을 입력받는다.
  - [x] 입력값이 유효한지 확인한다. -> 'U' 또는 'D'인가? (테스트 완료)
  - [x] 건널 수 있다면 'O'로, 그렇지 않다면 'X'로 표시한다. (테스트 완료)
  - [x] 중간에 실패하면, 재시작 여부를 입력받는다. (테스트 완료)
    - [x] 입력값이 유효한지 확인한다. -> 'R' 또는 'Q'인가? (테스트 완료)
  - [x] 다리를 끝까지 건너면 게임을 종료한다. (테스트 완료)


- [x] 게임 종료 시, 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 출력한다. (테스트 완료)

---

# 클래스 분리
## Controller
- Application

## Model
- BridgeGame
- BridgeMaker
- BridgeRandomNumberGenerator
- AnswerBridge
- User


- constant
  - Message


- interfaces
  - BridgeNumberGenerator

- util
  - ExceptionHandler

## View
- InputView
- OutputView