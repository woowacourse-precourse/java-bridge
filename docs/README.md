# 다리 건너기
![Generic badge](https://img.shields.io/badge/precourse-week4-brightgreen)

## 기능 구현
- [x] 다리 생성
  - [x] random 생성 0,1에 따른 U,D 입력 구현
  - [x] 다리 길이 입력 받기
    - 예외 처리
      - [x] 숫자를 입력 받아야 하는데 문자를 입력받은 경우
      - [x] 3이상 20이하가 아닌 숫자를 입력받은 경우
- [ ] 플레이어 입력(U,D)
- [ ] 플레이어 입력 검증(O,X)
- [ ] 플레이어 입력 결과 출력
- [ ] 게임 성공 여부 처리
- [ ] 시도 횟수 처리
- [ ] 재시도 / 종료 처리

## 요구(제한) 사항
- indent depth가 3이 넘지 않도록
- 3항 연산자 x
- 함수,메서드의 길이가 10라인을 넘지 x
- 메서드의 파라미터 개수는 3개까지 허용
- InputView에서만 readLine() 쓸 수O
- BridgeGame에서는 InputView, outputView 사용x
