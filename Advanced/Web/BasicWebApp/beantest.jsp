<jsp:useBean id="uctr" class="basicwebapp.CounterBean"					
	scope="session"/>
<jsp:useBean id="gctr" class="basicwebapp.CounterBean"
	scope="application"/>
<jsp:useBean id="calc" class="basicwebapp.CalculatorBean"/>					<!-- Check point 1. -->
<jsp:setProperty name="calc" property="*"/>							<!-- Check point 2. -->
<html>
	<head>
		<title>Welcome - BasicWebApp</title>
	</head>
	<body>
		<h1>Welcome Visitor ${param.name}</h1>					<!-- Check point 3. -->
		<b>Number of requests: </b>
		${uctr.nextCount} / ${gctr.nextCount}					<!-- Check point 4. -->
		<p>
			<form method="post">
				<span style="float:left;width:10%">
					FirstValue:
				</span>
				<input type="text" name="firstValue" 				<!-- Check point 5. -->
					value="${param.firstValue}"><br>
				<span style="float:left;width:10%">
					SecondValue:
				</span>
				<input type="text" name="secondValue"
					value="${param.secondValue}"><br><br>
				<input type="submit" name="command" value="Add">		<!-- Check point 6. -->
				<input type="submit" name="command" value="Sub">
				<input type="submit" name="command" value="Mul">
				<input type="submit" name="command" value="Div">
			</form>
		</p>
		<b>Result = </b>${calc.result}						<!-- Check point 7. -->
	</body>
</html>

<!-- Comments about this programme :-

POINTS :-
	1. This is used to locate or instantiates a java bean component.
		id :-	Id is a instance of that component(java bean class)
		class :-	here we are specifying the Bean component (java bean class name, fully qualified name).
		scope :- 	This is used to specify that bean can be called in any jsp page in the same session as the page created the 
			bean (request scope is bydefault).

	2. The <jsp:useBean> element  contains a <jsp:setProperty> element that is used to sets property values in the Bean.
		It means we are setting the all property. so we can call by their name only.

	3. name we will pass in URL.
	4. "uctr" is a object of basicwebapp.CounterBean which is initialized in session scope. So data will be accessed from multiple 
	    page within that particular browser. and
	     "gctr" is a object of basicwebapp.CounterBean which is initialized in application scope. So data will be accessed from 
	     multiple  page within that particular browser.

	 	So here we are calling the nextCount() property so compiler will automatically call getNextCount() method from 
		class of that object (basicwebapp.CounterBean)

		NOTE :- here both object (id) is created seperated so they are containing seperate data.

	5. Here we are making the text-box whose name is same as variable of Java-Bean so this text box will implicitly map to that
	    variable.. same for all.

		${param.firstValue} :-It means, we are getting the value of this variable from Java-Bean.

	6. Here we are making the button and whose name is same as variable of Java-Bean so this button will implicitly map to that
	    variable
		It will set the value of command variable.

	7. Here we are calling result on "calc" on Id, so compiler will call getResult() method from this id's class (CalculatorBean).
-->