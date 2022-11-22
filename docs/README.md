# 기능목록

## InputView

- 사용자 입력받고 유효성 검사
  - 에러발생시 catch에서 재귀
- 정의된 함수들 구현


## OutputView

- printMap: 위의 다리와 아래의 다리를 출력한다. 
- 결과 출력

# Validation

- 유효성 검사
  - 다리 입력 받았을 경우-> 숫자인지 확인/ 범위 확인
  - 무브 입력/ 재시작 입력-> 해당 문자열이 아닌경우만 return


# BridgeMaker

- 1,0 랜덤 숫자 뽑기
- num to String

# GameResult
- 게임 결과 저장하는 객체
- 결과 리셋
- 결과 업데이트
- 결과 조회를 위한 getter와 toString

# BridgeGame
- move, retry 구현
- 게임 상태 조회, 관리를 위한 status변수와 관리 함수들 추가
- 결과 조회를 위한 함수 추가

# GameController
- 게임 시작: 객체 생성
- 게임 플레이
  - move-> 게임 상태가 플레이가 아닐 때까지
  - retry -> move 결과가 실패일 때
  - end-> 최종 결과 출력시 부르는 함수
