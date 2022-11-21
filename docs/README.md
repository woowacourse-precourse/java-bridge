# 구현할 기능 목록

## 다리 생성
- 다리의 길이를 숫자로 입력 받음
  - `camp.nextstep.edu.missionutils.Console`에서 제공하는 `readLine` 함수를 이용
  - 잘못된 값을 입력 받으면 `IllegalArgumentException` 발생 후 에러 메시지 출력 후 다시 입력 받음
- 건널 수 있는 칸을 0과 1 중 랜덤으로 설정
- 값이 0인 경우 아래 칸, 1인 경우 위 칸을 건널 수 있게 설정

## 플레이어 이동
- 플레이어 가 이동할 칸을 입력 받음
  - `camp.nextstep.edu.missionutils.Console`에서 제공하는 `readLine` 함수를 이용
  - 잘못된 값을 입력 받으면 `IllegalArgumentException` 발생 후 에러 메시지 출력 후 다시 입력 받음
- U를 입력받으면 위 칸, D를 입력받으면 아래 칸을 입력 받음
- 이동한 칸을 건널 수 있다면 O, 건널 수 없으면 X로 표시

## 다리 결과 출력
- 이동할 수 있는 칸을 선택하면 O 그렇지 않으면 X를 표시
- 선택하지 않은 칸은 공백 한칸으로 표시
- 다리의 시작과 끝은 []로 표시
- 다리 칸의 구분은 |으로 표시
- 현재까지 건넌 다리를 모두 출력해야함

## 게임 종료
- 다리를 끝까지 건너면 게임을 종료
- 다리를 건너다 실패한 후 게임 종료 여부 입력 받음
  - `camp.nextstep.edu.missionutils.Console`에서 제공하는 `readLine` 함수를 이용
  - 잘못된 값을 입력 받으면 `IllegalArgumentException` 발생 후 에러 메시지 출력 후 다시 입력 받음
- 플레이어가 R을 누르면 재시작
- 플레이어가 Q를 누르면 종료
- 게임 성공 여부 및 시도한 횟수 출력