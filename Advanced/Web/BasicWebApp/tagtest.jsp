<%@ taglib prefix="b" uri="/WEB-INF/basic.tld" %>
<html>
	<head>
		<title>Welcome - BasicWebApp</title>
	</head>
	<body>
		<h1>
			<b:colorText colors="red,green,blue">
				Welcome Visitor ${param.name}
			</b:colorText>
		</h1>
		<b>Time on server: </b>
			<b:putTime format="yyyy-MM-dd hh:mm:ss a"/>
		<p>
			<b>Tick Count: </b>${ticks}
		</p>
	</body>
</html>


















