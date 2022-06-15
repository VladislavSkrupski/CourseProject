<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Brands</title>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <th>ID</th>
            <th>Brand</th>
            <th>Material</th>
       </tr>
       <c:forEach items="${brandsm}" var="brand">
             <tr>
                 <td>${brand.id}</td>
                 <td>${brand.brand}</td>
                 <td>${brand.materials[0].decorArticle}</td>
             </tr>
         </c:forEach>

    </table>
</div>
</body>
</html>
