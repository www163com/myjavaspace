<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示用户数据</title>
</head>
<body>
	<table border="1" align="center" width="50%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<#list list2 as user>
			<tr>
			    <td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.userAge}</td>
            </tr>
		</#list>
	</table>
</body>
</html>