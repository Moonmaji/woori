<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<link href="./css/menu.css" rel="stylesheet">
<style type="text/css">
#main{
   margin: 0 auto;
   width: 800px;
   height: 100%;
}

#noticeWriteForm{
   margin: 0 auto;
   margin-top: 100px;
   padding: 10px;
   height: 500px;
   width: 500px;
   background-color: teal;
}

#noticeWriteForm input{
   margin: 0;
   padding: 0;
   line-height: 30px; /*위아래 중앙정렬 높이만큼 줌 */
   width: 100%;
   height: 50px;
   margin-bottom: 5px;
   box-sizing: border-box; 패딩 넣으면 
   padding: 5px;
}

#noticeWriteForm textarea{
   margin: 0; 여백이 있어서 
   padding: 0;
   width: 100%;
   height: 350px;
   margin-bottom: 5px;
   box-sizing: border-box;
}
</style>
</head>
<body>
   <%@include file="./menu.jsp"%>
   <div id="main">
   	<h1>공지사항 작성</h1>
      <div id = "noticeWriteForm">
         <form action="./noticeWrite" method="post" enctype="multipart/form-data">
            <input type="text" name="title" required="required">
            <textarea name="content"></textarea>
            <input type="file" name="file" accept="image/*">
            <button type="submit">공지등록</button>
         </form>
      </div>
   </div>

</body>
</html>