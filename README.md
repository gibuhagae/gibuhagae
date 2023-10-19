<div align=center> 
  <img src="https://github.com/gibuhagae/gibuhagae/assets/138549312/3d078492-4cc5-4b4f-8060-bd35f78f8359.PNG" width="300" height="150"/></div>

<br>
<br>

<div align="center">
    HAHYEON &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    HYEOK &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    JUNHONG &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    WOOSEOK &nbsp;&nbsp;&nbsp;
    <br>
    <br>
    <img src="https://github.com/gibuhagae/gibuhagae/assets/138549312/281ebcf8-029b-400a-888d-88bce79151a8" width="130" height="130"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="https://github.com/gibuhagae/gibuhagae/assets/138549312/956e797b-0a72-4fc6-b6ac-adae9606a45a" width="130" height="130"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="https://github.com/gibuhagae/gibuhagae/assets/138549312/0c8f6abb-e857-4e01-acfc-656b4e65f81e" width="130" height="130"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="https://github.com/gibuhagae/gibuhagae/assets/138549312/12a7b9d6-93a9-4b5f-bad9-509892567a0a" width="130" height="130"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </a>
</div>
<br><br>

## :clipboard: 개요
- 초기에 애완용품 쇼핑몰을 구상하면서 주인이없는 소외동물을 도와줄 수 있는 방법을 생각하고,
이에 많은 사람들이 소외동물을 도와줄 수 있는 수단인 기부에 쉽게 접근 할 수 있도록 적립금을 기부할 수 있는 반려동물 용품 쇼핑몰 제작을 기획.
      <br>
- 개발기간 : 2020.09.26 ~ 2020.10.20 (약 4주)
- 개발인원 : FullStack 5명     

## :clipboard: 개발환경
* IntelliJ
* Oracle
* Spring
* GitHub
<br>
<div align=left><h2>📚 FRONT-END</h2></div>

<div align=left> 
  <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <br>
</div>

<div align=left><h2>📚 BACK-END</h2></div>

<div align=left>
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
  <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> 
  <br>
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
  <img src="https://img.shields.io/badge/node.js-339933?style=for-the-badge&logo=Node.js&logoColor=white">
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
  <br>
</div>  

## 주요 기능
- 상품조회, 게시판 관리
- 주문, 결제
- 로그인, 회원가입
- 주문, 기부금 관리
- 적립금을 활용한 후원 기능

## :link: ERD 설계
* [shopping mall ERD](https://github.com/didrlgus/springboot-shoppingmall/issues/1)

## :link: 디자인 설계
* [shopping mall FIGMA](https://github.com/didrlgus/springboot-shoppingmall/issues/1)

## :link: 업무 흐름도
* [shopping mall FIGJAM](https://github.com/didrlgus/springboot-shoppingmall/issues/1)

# 화면

- #### 메인화면

 <p align="center"><img src="https://github.com/gibuhagae/gibuhagae/assets/138549312/008740e4-4ff6-4e16-9039-a7c7294d7fef" width="1000" height="800"/></p>


- **슬라이드, 상품리스트**

   1. bxSlider를 이용하여 이미지 슬라이더 구성.

   2. JsonView를 설정해 데이터를 Json형태로 가져와 Ajax 통신으로

       메인 상품 리스트 구성.
      

- #### 상품 상세

 <p align="center"><img src=""/></p>



 - **카테고리별 검색, 리스트, 순서, 페이징**
   
   1. Mybatis 동적 쿼리문을 이용하여 하나의 쿼리문으로 카테고리별 검색, 리스트, 순서, 페이징을 한 번에 처리를 하고 JsonView를 설정하여 Json형태로   데이터를 가져와 Ajax 통신으로 상품 리스트를 구성합니다
   
   
 - **좋아요, 장바구니, 구매하기 기능**    ///////
   
   1. 장바구니 클릭 시 선택한 상품이 장바구니 리스트에 등록된후 팝업창 알림.
   2. 중복값 저장 불가.
   
 - **상품 문의 기능**
 
    1. JsonView를 설정해 Json형태로 데이터를 가져와 Ajax 통신으로 리스트 구성.
    2. Toggle을 사용하여 제목을 클릭 시 보이기, 숨기기 기능 구성.
    
  - **Review 기능**
  
    1. JsonView를 설정해 Json형태로 데이터를 가져와 Ajax 통신으로 리스트 구성.
    2. Toggle을 사용하여 제목을 클릭 시 보이기, 숨기기 기능 구성. 
    3. 리뷰를 등록할 때 CkEditor를 사용하여 DataBase에 저장된 이미지와 내용 출력.
    4. Ajax 및 Jquery로 페이징 구성.   
    
    
- #### 주문, 결제

 - **장바구니 기능**
   
  1. Json을 이용해 장바구니내 상품 수정.
  2. 체크박스와 form태그 생성을 이용하여 주문페이지 전송.
  

 - **주문페이지**
   
  1. 구매자 정보 입력 후 결제 진행.
  2. 적립금 후원여부 확인 후 전송.


- #### 로그인, 회원가입

 - **좋아요, 장바구니, 구매하기 기능**
 
    1. 장바구니 클릭 시 선택한 상품이 장바구니 리스트에 등록됩니다. 그리고 팝업창이 뜹니다. 상품을 선택 안 할 시 유효성 체크 완료.


- #### 게시판

 - **좋아요, 장바구니, 구매하기 기능**
 
    1. 장바구니 클릭 시 선택한 상품이 장바구니 리스트에 등록됩니다. 그리고 팝업창이 뜹니다. 상품을 선택 안 할 시 유효성 체크 완료.


- #### 게시판

 - **좋아요, 장바구니, 구매하기 기능**
 
    1. 장바구니 클릭 시 선택한 상품이 장바구니 리스트에 등록됩니다. 그리고 팝업창이 뜹니다. 상품을 선택 안 할 시 유효성 체크 완료.    


- #### 주문 관

 - **좋아요, 장바구니, 구매하기 기능**
 
    1. 장바구니 클릭 시 선택한 상품이 장바구니 리스트에 등록됩니다. 그리고 팝업창이 뜹니다. 상품을 선택 안 할 시 유효성 체크 완료.    

    

 
