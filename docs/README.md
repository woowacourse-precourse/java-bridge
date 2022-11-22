# 🚀 기능 구현 목록

---
## 프로젝트 구조


---
## 구체적 기능 소개
1. **InputView**
   - readBridgeSize: 다리의 길이를 입력 받음.
     - 사용자가 3-20의 숫자 이외의 값을 입력할 경우 InvalidSizeCheck - IllegalArgumentException, "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다." 에러 메세지 출력 후 그 부분부터 입력 재시도
   - readMoving: 사용자가 이동할 칸(U, D)을 입력 받음.
     - U, D 이외의 값을 입력할 경우 checkInvalidDirection - IllegalArgumentException, "[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자로 입력해주세요." 에러 메세지 출력 후 그 부분부터 입력 재시도
   - readGameCommand: 진행중이던 게임이 끝났을 때 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받음.
     - R, Q 이외의 값을 입력할 경우 checkInvalidCommand - IllegalArgumentException, "[ERROR] 게임 다시 시도 여부는 R(재시도)과 Q(종료) 중 하나의 문자로 입력해주세요." 에러 메세지 출력 후 그 부분부터 입력 재시도
   - InvalidSizeCheck: 정규 표현식을 사용해 숫자 형식, 3-20 범위를 확인.
   - checkInvalidDirection: 문자열 비교하여 U, D 이외의 값은 예외 입력으로 판단.
   - checkInvalidCommand: 문자열 비교하여 R, Q 이외의 값은 예외 입력으로 판단.
2. **OutputView**
   - printMap: 지금까지 이동한 다리의 상황을 누적하여 형식에 맞게 출력.
     - 윗 줄(top line)과 아랫 줄(down line)으로 나누어 정보를 합침(constructBothLines).
     - 괄호 형식을 맞추고 사용자 선택과 다리 상황을 출력(printLines).
   - constructBothLines: 현재까지 이동한 다리의 상태(윗 줄, 아랫 줄) 정보 합치기.
     - 윗 줄은 constructTopLine, 아랫 줄은 constructDownLine 함수를 사용하여 정보 수합.
     - 결과는 connectTop, connectDown 함수가 정보들 사이의 "|" 처리나 공백처리 같은 형식을 담당하도록 함.
   - connectTop: "U"에 해당하는 윗 줄에 첫번째 시도의 첫번째 이동 일 경우 그대로 이어 붙이고, 그렇지 않을 경우 "|" 로 구분.
   - connectDown: "D"에 해당하는 아랫 줄에 첫번째 시도의 첫번째 이동 일 경우 그대로 이어 붙이고, 그렇지 않을 경우 "|" 로 구분.
   - constructTopLine: 사용자의 선택이 "U"일 경우 윗 줄에 출력 내용을 추가(addLine), 그렇지 않다면 윗 줄에 공백을 추가(addBlank)
   - constructDownLine: 사용자의 선택이 "U"일 경우 아랫 줄에 공백 내용을 추가(addBlank), 그렇지 않다면 아랫 줄에 내용을 추가(addLine)
   - addLine: 출력 내용(O, X)을 윗 줄 또는 아랫 줄에 추가.
   - addBlank: 공백(빈칸 3개)을 윗 줄 또는 아랫 줄에 추가.
   - printLines: 정보가 수합된 윗 줄과 아랫줄을 괄호를 닫아 형식을 맞춘 뒤 출력. 
3. **Messages**
   - InputView 클래스의 예외처리 메세지들을 Enum class로 모아 힌 곳에 관리하는 클래스.
     - INVALID_SIZE: "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
     - INVALID_DIRECTION: "[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자로 입력해주세요."
     - INVALID_COMMAND: "[ERROR] 게임 다시 시도 여부는 R(재시도)과 Q(종료) 중 하나의 문자로 입력해주세요."
4. **User**
   - 게임에 참여하는 사용자 객체.
   - userMoveChoice 필드로 사용자의 선택(U, D)을 리스트로 모아 관리.
   - saveChoice: 사용자의 개별 선택(이동할 칸)을 userMoveChoice 필드에 저장.
5. **BridgeGame**
   - move: 사용자의 선택(입력 값)과, 정답(다리를 건너기 위한 정답 칸)을 비교하여 [마커(O,X), 방향(U,D)]의 형태를 element으로 가진 리스트를 반환.
   - markResult: 사용자의 선택 경로에 마커 (O, X)를 표시, 선택 방향(U, D)를 리스트 형태로 묶어 반환.
   - retry: 사용자가 게임을 다시 시도할 때, 즉 "R" 입력 시 true를 반환, 그렇지 않다면 false를 반환.
6. **BridgeMaker**
   - makeBridge: 다리 길이를 파라미터로 받아 그 길이 만큼 랜덤으로 생성된 숫자(0,1)를 칸(U,D)으로 표현(saveAnswer)하여 반환.
   - saveAnswer: BridgeNumberGenerator 인터페이스를 구현한 BridgeRandomNumberGenerator의 generate 함수로 생성된 랜덤 값이 0인 경우 아래 칸, 1인 경우 위 칸으로 변환.
7. **BridgeNumberGenerator**
   - 랜덤 값 생성을 위한 인터페이스.
8. **BridgeRandomNumberGenerator**
   - 인터페이스 BridgeNumberGenerator의 구현체.
   - 0, 1 값 중 한 개를 camp.nextstep.edu.missionutils.Randoms 라이브러리 함수를 이용해 선택.
9. **Application**
   - greetings: 게임 시작 문구(다리 건너기 게임을 시작합니다.)
   - init: 다리 생성, 다리 길이 초기 입력 세팅.
     - 3-20 사이의 숫자값이 입력으로 들어오지 않으면 예외 처리, 입력받은 에러 메세지 출력(INVALID_SIZE)
   - askUntilDone: 다리 건너기 성공할 때까지 게임 진행
     - userOneMove -> checkConditions -> restart check
     - userOneMove: 사용자에게 이동할 칸을 입력받고 적합하지 않은 값을 예외처리 한 후 현재 다리의 상태를 출력.
     - checkConditions: 
       - 게임 성공여부 판단(checkSucceed)
       - 게임 실패 판단(checkGameOver)
       - 재시도 질문 시 "R" 여부 판단(restart)
     - restart: 재시도 "R" 입력 시 시도 횟수 trial에 1을 더하고 restart 초기화.
---