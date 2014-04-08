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

<form id="addForm" action="http://localhost:8080/CanYin-www/Restaurant/addrestaurant" method="post">
restaurant name: <input type="text" name="r_name" size="20"><br />
restaurant total seat number: <input type="text" name="r_totseatnum" size="20"><br />
restaurant address: <input type="text" name="r_adress" size="20"><br />
restaurant post: <input type="text" name="r_post" size="20"><br />
restaurant phone: <input type="text" name="r_phone" size="20"><br />
restaurant wechatid: <input type="text" name="r_wechatid" size="20"><br />
restaurant create time: <input type="text" name="create_time" size="20"><br />
restaurant update time: <input type="text" name="update_time" size="20"><br />
restaurant owner: <input type="text" name="r_owner" size="20"><br />
restaurant status: <input type="text" name="r_status" size="20"><br />
<br />
<input type="button" onclick="formSubmit()" value="Submit">
</form>
</body>
</html>

////