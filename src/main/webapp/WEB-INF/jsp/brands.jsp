<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Brands</title>
</head>
<body>
<div>
    <table border="1" align="center">
        <tr>
            <th>ID</th>
            <th>Brand</th>
       </tr>
       <c:forEach items="${brands}" var="brand">
             <tr>
                 <td>${brand.id}</td>
                 <td>${brand.brand}</td>
             </tr>
         </c:forEach>

    </table>
</div>
</body>
</html>
