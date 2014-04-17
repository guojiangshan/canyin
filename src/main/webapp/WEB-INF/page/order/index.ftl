<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
function formSubmit()
  {
  document.getElementById("orderForm").submit()
  }
</script>
</head>

<body>

<form id="orderForm" action="http://localhost:8080/CanYin-www/Order/getOrderById" method="post">
order id: <input type="text" name="o_id" size="20"><br />
<!--order name: <input type="text" name="o_id" size="20"><br />-->
<br />
<input type="button" onclick="formSubmit()" value="Submit">
</form>
</body>

</html>