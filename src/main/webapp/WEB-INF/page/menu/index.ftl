<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
function formSubmit()
  {
  document.getElementById("menuForm").submit()
  }
</script>
</head>

<body>

<form id="menuForm" action="http://localhost:8080/CanYin-www/Menu/getbyid" method="post">
menu id: <input type="text" name="m_id" size="20"><br />
restaurant id: <input type="text" name="r_id" size="20"><br />
<br />
<input type="button" onclick="formSubmit()" value="Submit">
</form>
</body>

</html>