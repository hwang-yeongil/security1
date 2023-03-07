<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title> test bootstrap </title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
  <!-- Font Awesome icons (free version)-->
  <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
  <!-- Google fonts-->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet"
    type="text/css" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="css/styles.css" rel="stylesheet" />
  <script>


    /*
    totalPage : 총 게시글 수
    page_num : 한 페이지 당 출력되는 게시글 갯수
    block_num : 한번에 출력될 수 있는 최대 블록 수
    total_block : 블록의 총 수
    current_block : 현재 블록 위치
    data: 게시글 데이터를 담고 있는 객체 배열
    post_data_print(block) : 게시글 데이터 출력하기 / 매개변수 : 선택 블럭 
    block_print(front_block) : 블럭 출력하기 / 매개변수 : 가장 앞에 오는 블럭
    */
    //    총 게시글 수
    let totalPage = 1;
    //  한 페이지 당 출력되는 게시글 갯수
    let page_num = 10;
    //   한번에 출력될 수 있는 최대 블록 수
    // ex ) [1][2][3][4][5] -> 블록
    let block_num = 10;
    // 블록의 총 수를 계산한다.
    let total_block = totalPage % 20 == 0 ? totalPage / 20 : totalPage / 20 + 1;
    // 현재 블록 위치를 알려준다
    let current_block = 1;
    /*
    게시글 데이터를 담고 있는 객체 배열
    번호 : data[게시글 번호].notice_num
    제목 : data[게시글 번호].title
    작성자 : data[게시글 번호].writer
    작성일 : data[게시글 번호].date_created
    조회 : data[게시글 번호].Lookkup_num
    좋아요 : data[게시글 번호].like
    */
    let data = new Array();

    //    게시글 데이터를 담고 있는 객체를 1000개 추가한다.
    for (let i = 1; i <= totalPage; i++) {
      data[i] = {
        id: i,
        title: "제목" + i,
        content: "내용" + i,
        writer: "작성자" + i,
        insertTime: "2022-10-07",
        updateTime: "2022-10-07"
      }
    }
    // 게시글 데이터 출력하기
    // 매개변수 : 선택 블럭 
    function post_data_print(block) {

      // 초기화
      // 게시글 title 제외하고 모두 제거
      let post_list = document.querySelectorAll(".data_row");
      post_list.forEach(function (item) {
        item.remove();
      })

      // 게시글 출력 공간
      let notice_board = document.querySelector(".notice_board");
      let board_title = document.querySelector(".board_title")
      // 출력 첫 페이지 번호
      let start = totalPage - page_num * (block - 1);
      for (let i = start; i >= 1 && i > start - page_num; i--) {

        // 게시글 데이터 가져와서 게시글 요소 생성 및 추가
        // 번호, 제목, 작성자, 작성일, 조회수, 좋아요
        // data[i].notice_num data[i].title data[i].writer data[i].date_created data[i].Lookkup_num data[i].like

        let post = document.createElement("ul");
        post.className = "board_row";
        console.log(post.className);
        post.className = "data_row";
        console.log(post.className);
        // let classname = ["w70", "w500","w500", "w120", "w100"]
        let classname = ["w500", "w120", "w100"]

        // let post_data = [data[i].id, data[i].title, data[i].content, data[i].writer, data[i].insertTime];
        let post_data = [data[i].content, data[i].writer, data[i].insertTime];
        let post_title = data[i].title;
        //게시글 생성
        for (let j = 0; j < classname.length; j++) {
          let li = document.createElement("li");
          li.className = classname[j];
          li.textContent = post_data[j];
          post.appendChild(li);
        }
        console.log(post.className);
        // 게시글 추가
        board_title.append(post_title);
        notice_board.appendChild(post);

      }

    }
/*
    // 블럭 출력하기
    // 매개변수 : 가장 앞에 오는 블럭
    function block_print(front_block) {
      
      1. 이전, 다음 블럭 속성 처리
      2. 기존 블럭 모두 삭제
      3. 범위 안의 블럭 생성 및 추가
      
      current_block = front_block;

      // 이전으로 갈 블럭이 없으면
      if (front_block <= 1) {
        document.querySelector(".before_move").style.visibility = "hidden";
      }
      else {
        document.querySelector(".before_move").style.visibility = "visible";
      }

      // 다음으로 갈 블럭이 없으면
      if (front_block + block_num >= total_block) {

        document.querySelector(".next_move").style.visibility = "hidden";
      }
      else {
        document.querySelector(".next_move").style.visibility = "visible";
      }

      // 블럭을 추가할 공간
      let block_box = document.querySelector(".block");
      // 기존 블럭 모두 삭제
      block_box.replaceChildren();

      console.log("remove");


      //front_block부터 total_block 또는 block_num까지 생성 및 추가
      for (let i = front_block; i <= total_block && i < front_block + block_num; i++) {
        console.log("add element");

        // 버튼을 생성한다.
        let button = document.createElement("button");
        button.textContent = i;
        // 버튼을 클릭하면 게시글이 변경되는 이벤트 추가
        button.addEventListener("click", function (event) {
          post_data_print(i)
        });
        // 블럭에 추가한다.
        block_box.appendChild(button);

      }

    } */

    function before() {
      block_print(current_block - block_num)
      console.log("이전");
    }

    function next() {
      block_print(current_block + block_num)
      console.log("다음");

    }
    // 화면 로드 시 실행되는 이벤트
    window.onload = function () {

      // 게시글 데이터 출력하기
      post_data_print(1)

      // 블럭 출력하기
      block_print(1)
    }
  </script>
</head>

<body id="page-top">
  <!-- Portfolio Section-->
  <section class="page-section portfolio" id="portfolio">
    <div class="container">
      <!-- Portfolio Section Heading-->
      <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Portfolio</h2>
      <!-- Icon Divider-->
      <div class="divider-custom">
        <div class="divider-custom-line"></div>
        <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
        <div class="divider-custom-line"></div>
      </div>
      <!-- Portfolio Grid Items-->
      <div class="row justify-content-center">
        <!-- Portfolio Item 1-->
        <div class="col-md-6 col-lg-4 mb-5" >
          <div class="portfolio-item mx-auto broder-test" data-bs-toggle="modal" data-bs-target="#portfolioModal1">
            <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
              <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
            </div>
             <%@
             	out.println(member.id);
              %>
             
            <!-- <div class="notice_board">
              
            </div> -->
            <img class="img-fluid" src="assets/img/portfolio/cabin.png" alt="..." />
            
          </div>
        </div>
        <!-- 여기까지 새로 추가 될 것 -->

      </div>
    </div>
  </section>
  <!-- Portfolio Modal 1-->
  <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" aria-labelledby="portfolioModal1"
    aria-hidden="true">
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
        <div class="modal-header border-0"><button class="btn-close" type="button" data-bs-dismiss="modal"
            aria-label="Close"></button></div>
        <div class="modal-body text-center pb-5">
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-8">
                <!-- 시작 (수정범위)-->
                <!-- Portfolio Modal - Title-->
                <h2 class="portfolio-modal-title text-secondary text-uppercase mb-0 board_title"></h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                  <div class="divider-custom-line"></div>
                  <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                  <div class="divider-custom-line"></div>
                </div>
                <img class="img-fluid rounded mb-5" src="assets/img/portfolio/cabin.png" alt="..." />
                <div class="notice_board">
              
              
                </div>
                <!-- Portfolio Modal - Image-->
                <!-- Portfolio Modal - Text-->
                <!-- 끝 (수정범위)-->
                <button class="btn btn-primary" data-bs-dismiss="modal">
                  <i class="fas fa-xmark fa-fw"></i>
                  Close Window
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  

  <!-- Bootstrap core JS-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="js/scripts.js"></script>
  <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
  <!-- * *                               SB Forms JS                               * *-->
  <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
  <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
  <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

</html>