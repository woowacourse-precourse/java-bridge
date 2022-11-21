
### 기능 구현 목록

1. Application
2. BridgeGame
   - move: 사용자의 칸 이동
   - retry: 사용자의 게임 재시도 
3. BridgeMaker (변경X)
   - makeBridge: 다리를 만들어 표현
4. BridgeRandomNumberGenerator (변경X)
   - generate: 랜덤으로 특정 길이의 다리 생성
5. InputView
    - readBridgeSize: 다리의 길이를 String으로 입력 받아서 int로 리턴
    - readMoving: 사용자가 이동 칸을 입력 받아 boolean 리턴 (U - true, D - false)
    - readGameCommand: 사용자가 게임을 다시 시도할지 종료할지 여부 입력 받아 boolean 리턴 (재시도 - true, 종료 - false)
6. Validator
   - isInt: 입력값이 integer인지 확인
   - isValidLength: 입력값이 3~20인지 확인
   - isValidMove: 입력값이 U 또는 D인지 확인
   - isValidCommand: 입력값이 R 또 Q인지 확인
7. OutputView
   - printMap: 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력
     - translateBridge: List<String>을 List<Boolean>으로 변경
     - checkCell: move와 bridge에 같은 index가 같은 값인지 확인
     - makeMap: print하기 전 map 만들기
   - printResult: 게임 최종 결과를 정해진 형식에 맞춰 출력
   - printStart: 게임 시작 문구 출력
   - printGetLength: 다리 길이 입력 문구 출력
   - printGetMove: 이동칸 선택 입력 문구 출력
   - printGetCommand: 재시도 입력 문구 출력
8. Tests