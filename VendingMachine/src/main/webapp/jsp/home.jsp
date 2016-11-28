<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>A Very Cool Vending Machine</h1>
            <div class="row">
                <div class="col-xs-4">
                    <div id="moneybox" class="col-xs-12">
                        $<span id="money"></span>
                    </div>
                    <div class="col-xs-12">
                        <button id="dollar" class="col-xs-12">
                            $1.00
                        </button>
                        <button id="quarter" class="col-xs-12"">
                            $0.25
                        </button>
                        <button id="dime" class="col-xs-12">
                            $0.10
                        </button>
                        <button id="nickel" class="col-xs-12">
                            $0.05
                        </button>
                        <button id="penny" class="col-xs-12">
                            $0.01
                        </button>
                    </div>
                </div>
                <div id="items" class="col-xs-8">
                </div>
            </div>
            <div class="row">
                <div id="messages" class="col-xs-6 col-xs-offset-3">
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/machine.js"></script>

    </body>
</html>

