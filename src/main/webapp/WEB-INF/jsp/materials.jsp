<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Materials</title>
</head>
<body>
<table border="1" align="center">
    <tr>
        <th>ID</th>
        <th>Brand</th>
        <th>Category</th>
        <th>Decor article</th>
        <th>Decor name</th>
        <th>texture</th>
        <th>length</th>
        <th>width</th>
        <th>thickness</th>
        <th>unit</th>
        <th>cost</th>
        <th>picture</th>

    </tr>
 <c:forEach items="${materials}" var="material">
        <tr>
            <td>${material.id}</td>
            <td>{material.brand.brand}</td>
            <td>{material.category.category}</td>
            <td>{material.decor.decorArticle}</td>
            <td>{material.decor.decorName}</td>
            <td>{material.texture.texture}</td>
            <td>{material.format.length}</td>
            <td>{material.format.width}</td>
            <td>{material.thickness.thickness}</td>
            <td>${material.measureUnit}</td>
            <td>${material.cost}</td>
            <td>${material.pictureAddress}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
