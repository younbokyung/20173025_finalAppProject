# 20173025_finalAppProject

## 20173025_2A_윤보경_캡스톤 디자인 기말과제

- 기말과제 주제 : 영화 후기 작성 프로그램
  - 처음 로그인 화면과 프래그먼트를 이용해 하단 메뉴를 생성하여 화면 전환이 가능한 영화 순위 탭, 영화 검색 탭, 후기 작성 탭, 정보 탭을 생성하여 프로젝트를 구성함.

### 로그인 : it, 패스워드 : 0000
### 사용된 이미지는 모두 drawable-v24에 업로드 되어있음.

## 로그인 화면
- 실행 화면 이미지


<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535695-6620e8dc-700d-4a4a-aafc-98cbd1a35349.png"></img>
<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535702-d3727dfc-83a9-46fb-a7a0-60c22f4fbbc4.png"></img>

- 기능 설명
  - 로그인 it, 패스워드 0000으로 입력하지 않는다면 비밀번호만 리셋되고, 다시 로그인을 수행해야 한다. 
  - 제대로 입력이 완료 되면 Toast 메시지를 이용해 username과 함께 '환영합니다'라는 문구를 출력하게 된다.


## 영화 순위 화면
- 실행 화면 이미지


<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535705-859e8f3f-721c-4cd2-bf0d-f34177fbd095.png"></img>
<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535708-7981f292-84ed-415f-9fcb-3829f963ff1d.png"></img>


<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535742-7e05f5e8-9899-4640-8eaf-5a13b342047b.png"></img>
<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535744-949c9965-9637-438c-982f-041f275019c6.png"></img>

- 기능 설명
  - EditText에 직접 숫자를 입력하여 호출이 가능하고, 안드로이드에서 제공하는 DatePickerDialog를 이용하여 날짜를 입력받을 수 있다. 단, 월(Month)이 한 글자이거나 일(dayOfMonth)이 한 글자인 경우 오류가 발생하고, 1월이 0으로 표기되고, 2월이 1로 표기되어 이 점을 if문을 이용하여 사용자가 입력한 값을 제대로 받아 올 수 있도록 한다.
  - 조회하기 버튼을 누르면 해당 일자와 함께 영화 정보를 Toast메시지로 출력한다.
  - 입력한 날짜 값이 api 호출 주소와 합쳐 지면서 사용자가 보기 편리한 카드뷰와 리싸이클러뷰 형태로 화면에 보여진다.
  - 하단에 있는 영화 예매하러 가기 버튼을 누르면 안드로이드에서 제공하는 AlertDialog를 이용하여 CGV, 메가박스, 롯데시네마를 한가지 선택해 확인 버튼을 누르면 intent를 이용해 영화관 페이지로 화면을 이동한다.


## 영화 검색 화면
- 실행 화면 이미지


<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535712-77aacbf3-6c11-4500-964f-7deadd20243f.png"></img>
<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535717-928811a2-62ca-4464-a60d-ec178ed71671.png"></img>

- 기능 설명
  - 검색 버튼을 클릭해 Search view에 검색하고 싶은 영화 제목을 입력한 후 검색 버튼을 누르게 된다면 네이버 api 주소와 합쳐져 네이버에 요청이 되고, 사용자가 보기 쉬운 형태인 카드뷰와 리싸이클러뷰 형태로 받아 볼 수 있다.
  - 네이버 api에서 제공하는 이미지와 평점 값을 이용해 시각적인 정보를 사용자에게 제공할 수 있으며, url또한 제공되어 원하는 영화를 클릭하면 해당 url주소로 이동되어 네이버 검색 화면으로 이동된다. 



## 후기 작성 화면
- 실행 화면 이미지


<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535728-4e468b94-014a-4ace-b5f2-d302ec1dfd71.png"></img>
<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535738-21e11032-bd4e-4848-8115-2fc88b459785.png"></img>

- 기능 설명
  -Edit Text에 글을 입력하면 byte를 카운트하여 100자까지만 입력 가능하도록 제한함.
  - 이미지를 클릭하면 카메라로 전환되고, 카메라로 찍은 사진을 다시 이미지 뷰에 보여지게 함.
  - 따로 다운받은 RangeSliderView를 이용해 평점을 매길 수 있도록 구현함. 평점 1점부터 5점까지 입력이 가능하며, RangeSlider를 움직일 때 평점을 Toast메시지로 출력함.
  - 저장 버튼을 누를 때 실제로 db에 저장이 되지는 않지만 저장되었습니다라는 Toast메시지를 띄움.



## 정보 화면
- 실행 화면 이미지


<img width="300" height="550" src="https://user-images.githubusercontent.com/90364468/146535740-3e31f8b9-903f-4ac0-a9f8-9f928c57f340.png"></img>

- 기능 설명
  - 각각의 탭에 대한 설명을 카드뷰와 리싸이클러뷰 형태로 나열함.
  - 기존에 했던 세로 형태의 리싸이클러뷰 형태가 아닌 가로 형태로 나열된 리싸이클러뷰를 규현해 봄. mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));으로 기존 코드를 수정하면 손쉽게 가로로 형태를 바꿀 수 있음.
  - 하단 로그아웃 버튼을 누르면 intent를 이용하여 로그인 화면으로 전환한다. 

# 프로젝트를 마무리 하며...

## 프로젝트를 진행하며 느낀점

- 이 프로젝트를 진행하며 정말 다양한 오류들을 경험했다. 특히 네이버 api를 사용하면서 parse를 사용하면서 uriString 변수를 선언하여 사용하는 작업이 있었는데 아무리 작업을 해도 그 부분이 아예 실행이 되지 않으며 avd가 계속 튕기는 현상이 발생했다. 꽤 오랫동안 그 오류로 인해 더 이상의 진전이 안되어 너무 답답했고, 어느 함수에서 오류가 발생하는지는 알겠는데 뭘 고쳐야 하는지도 막막했다. 코드를 이리저리 분석하고, 정확히 어느 부분이 오류인지 한 줄마다 Toast 메시지를 출력해 보았다. 이렇게 몇 번 계속 수정해 보니 uriString 변수에 "content://com.example.a20173025_finalappproject/movie"이렇게 입력했어야 했는데 뒤에 movie를 없애고 parse를 진행하니 오류가 발생한 것이다. 이렇게 정말 사소하고, 작은 것의 오류에 프로그램이 영향을 받아 아예 작동이 안 되었다는 것이 개발(코딩)의 매력인 것 같다. 이렇게 오류들을 수정해 보니 비슷한 오류가 나왔을 때 이런 식으로 수정하면 오류가 생기지 않을 것 같다는 생각도 돌게 되었다. 이번 프로젝트를 하며 가장 크게 얻게 된 것은 오류를 수정해 보면서 생긴 감과 경험인 것 같다. 프로젝트를 하며 처음 보는 소스코드를 분석하고 오류를 수정해야 할 때는 정말 막막하고, 이게 왜 오류가 난 것인지 의문일 때가 많았는데 점점 보다 보면 어떤 부분에서 이렇게 프로그램이 진행되고 어떻게 끝나는 것인지 알 수 있게 되었다. 이렇게 점점 나만의 경험을 쌓아간다면 후에 나중에 내가 기획한 앱도 실현 가능할 수 있다는 생각이 들었다. 앞으로 더 다양한 경험들을 쌓아 봐야겠다.
