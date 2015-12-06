<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/index.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/path.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/menu.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="utf-8" />
</head>
<body>


<div id="header"></div>
<jsp:include page="path.jsp"/>


<form method="POST" enctype="multipart/form-data"
      action="${env}/import/import1c">
    File to upload: <input type="file" name="file"><br/>  <br/> <input type="submit"
                                                   value="Upload"> Press here to upload the file!
</form>


<div id="footer"></div>
</body>
</html>
