<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

     <form action="save">
           <pre>
               ID   : <input type="text" name="id">
               NAME : <input type="text" name="name">
               SAL  : <input type="text" name="sal">
                      <input type="submit" value="save">
                      ${msg}
           </pre>
     </form>

</body>
</html>