<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<style>
  body {
    background: #fff;
    padding: 40px 20px;
    max-width: 800px;
    margin: 0 auto;
  }
  h1 {
    margin-bottom: 30px;
    font-size: 36px;
    color: #000;
  }
  form > div {
    margin-bottom: 20px;
  }
  label {
    display: inline-block;
    width: 80px;
    font-weight: 600;
    color: #6c6c6c;
  }
  input[type="text"] {
    width: calc(100% - 100px);
    padding: 8px 10px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 16px;
  }
  button {
    padding: 10px 18px;
    font-size: 16px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
  }
  button[type="submit"] {
    background-color: #4CAF50;
    color: white;
  }
  button[type="reset"] {
    background-color: #ddd;
    margin-right: 10px;
  }
  button:hover {
    opacity: 0.9;
  }
</style>
</head>
<body>
	<h1>게시글 등록</h1>
	<form method="post" action="./BoardInsert">
		<div>
			<label for="bdTitle">제목</label>
			<input type="text" id="bdTitle" name="bdTitle" required>
		</div>

		<div>
			<label for="bdWriter">작성자</label>
			<input type="text" id="bdWriter" name="bdWriter" required>
		</div>
		
		<div>
			<label for="bdContent">내용</label>
			<input type="text" id="bdContent" name="bdContent" required>
		</div>


		<button type="reset">입력 지우기</button>
		<button type="submit">등록</button>
	</form>
</body>
</html>
