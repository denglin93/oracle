<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/meihua/css/bootstrap.css" />
</head>
<body>
<div class="container">
<h1 class="page-header">表单美化</h1>
<div class="input-prepend">
<span class="add-on">用户名</span><input type="text">
</div>
<label >用户名</label>
<input type="text" placeholder="请输入 用户名" class="span2"><br><br>
<div class="input-append">
<input  type="text"><button class="btn" type="button">搜索</button> 
</div>
<br><br>
<h2>提交表单，插查询功能</h2>
<div class="input-append">
<input  type="text"><input class="btn" type="submit" value="搜索">
</div>

<br><br>
<div><label>性别</label>
<label class="radio">
<input type="radio" name="gender" value="male">
男</label>
<label class="radio">
<input type="radio" name="gender" value="female">
女</label>
<label class="radio">
<input type="radio" name="gender" value="other">
其他</label>
</div>
<br><br>
<div>
<h1>复选框</h1>
<label class="checkbox">
<input type="checkbox" name="cd" value="1">1</label><label class="checkbox">
<input type="checkbox" name="cd" value="2">2</label><label class="checkbox">
<input type="checkbox" name="cd" value="3">3</label><label class="checkbox">
<input type="checkbox" name="cd" value="4">4</label>
<br><br>
<h1>复选框</h1>
<label class="checkbox inline">
<input type="checkbox" name="cd" value="1">1</label><label class="checkbox inline">
<input type="checkbox" name="cd" value="2">2</label><label class="checkbox inline">
<input type="checkbox" name="cd" value="3">3</label><label class="checkbox inline">
<input type="checkbox" name="cd" value="4">4</label>
</div>
<br><br>
<div>
<label>选择列表</label>
<select>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select>
<br><br>
<label> 多选框</label>
<select name="select" multiple="multiple">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select>

</div>





</div>
</body>
</html>