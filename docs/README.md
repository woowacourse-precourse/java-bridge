## 게임 시작
- [x] 게임 시작 출력
  - new BridgeGame();
- [X] BridgeGame class안에 필드 추가(성공여부, 시도횟수, 다리 성공 경로)

## 다리 생성
- [x] 게임  길이 입력받기(InputView 이용해서 Console.readLine()이용 )
  - [x] 입력값이 숫자인지 체크  (테스트케이스)
- [x] 입력값을 readBridgeSize에서 리턴
  - [x] 다리 길이 3이상 20이하 아니면 예외처리 `IllegalArgumentException`를 발생+`[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.`
- [x] bridgeGenerator로 bridgeMaker 생성
- [x] BridgeMaker 사용해서 다리 입력받은 다리 개수 만큼 생성

## 다리 이동
- [x] 입력 `이동할 칸을 선택해주세요. (위: U, 아래: D)` 후 정답과 비교하는 함수 구현
  - (InputView 이용해서 Console.readLine()이용 )
  - [x] U/D아니면 예외처리 `IllegalArgumentException`를 발생
- [x] 정답과 같을 경우 출력하는 함수 구현
- [x] 입력`게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)`후 함수 구현
  - (InputView 이용해서 Console.readLine()이용 )
  - R이면 재시작이고 기존 다리 재사용

## 최종 출력
-[x] 최종결과, 게임성공여부, 총시도 횟수 출력