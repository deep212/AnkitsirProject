<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.1.min.js" > </script>
<script type="text/javascript">

    function PrintElem(elem)
    {
        Popup($(elem).html());
    }

    function Popup(data) 
    {
        var mywindow = window.open('', 'my div', 'height=400,width=600');
        mywindow.document.write('<html><head><title>my div</title>');
        /*optional stylesheet*/ //mywindow.document.write('<link rel="stylesheet" href="main.css" type="text/css" />');
        mywindow.document.write('</head><body >');
        mywindow.document.write(data);
        mywindow.document.write('</body></html>');

        mywindow.document.close(); // necessary for IE >= 10
        mywindow.focus(); // necessary for IE >= 10

        mywindow.print();
        mywindow.close();

        return true;
    }

</script>
<title>Insert title here</title>
<script type="text/javascript">
	function previewImage(input) {
		var preview = document.getElementById('preview');
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				preview.setAttribute('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		} else {
			preview.setAttribute('src');
		}
	}
</script>

 
</head>
<body>
<div id="mydiv">
<div>	<img src="${attachment}" id="preview" height="140px"
													width="140px" align="top" />
											</div>
<form:form action="#" modelAttribute="registration" method="post">
<table align="center" border="5" bordercolor="brown" cellspacing="5">
<tr><td>NAME</td><td>${RegistData.name}</td></tr>
<tr><td style="width: 300px;">EMAIL</td><td>${RegistData.email}</td><tr>
<tr><td style="width: 300px;">MOBILE_NO.</td><td>${RegistData.mobileNo}</td></tr>
<tr><td style="width: 300px;">WEbBSITE</td><td>${RegistData.companyurl}</td></tr>
<tr><td style="width: 300px;"><a href="UpdateProfile?email=${RegistData.email}">UpdateProfile</a></td></tr>
<tr><td style="width: 300px;"><a href="DeleteProfile">DeleteProfile</a></td></tr></table></form:form>
</div>
<input type="button" value="Print Div" onclick="PrintElem('#mydiv')" />
</body>
</html>