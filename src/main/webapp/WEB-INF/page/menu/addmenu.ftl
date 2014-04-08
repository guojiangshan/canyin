<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
function formSubmit()
  {
  	document.getElementById("addForm").submit()
  }
</script>
</head>

<body>

<form id="addForm" action="http://localhost:8080/CanYin-www/Menu/addmenu" method="post">
restaurant name: <input type="text" name="m_name" size="20"><br />
restaurant create time: <input type="text" name="createtime" size="20"><br />
restaurant update time: <input type="text" name="updatetime" size="20"><br />
restaurant owner: <input type="text" name="r_id" size="20"><br />
<br />
<input type="button" onclick="formSubmit()" value="Submit">
</form>
</body>
</html>

////