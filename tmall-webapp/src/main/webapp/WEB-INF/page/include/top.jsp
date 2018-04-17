<%@ page import="java.net.InetAddress" %><%--
  Created by IntelliJ IDEA.
  User: warframe
  Date: 2017/9/7
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //获取本机(服务器当前)IP并保存到pageContext中
    InetAddress addr = InetAddress.getLocalHost();
    String ip=addr.getHostAddress().toString();//获得本机IP
    pageContext.setAttribute("ip",ip);
%>

<!--导航栏-->
<nav class="header">

    <div class="header-content">
        <a href="<%=request.getContextPath()%>/home"><span class="glyphicon glyphicon-home" style="color: #c40000"></span>天猫首页</a>
        <c:choose>
            <c:when test="${!empty customer}">
                <span>hi,${customer.customerName}</span>
                <!--点击退出登录后会回到首页，问不是退出登录那一页(待完善)-->
                <a href="logout">退出登录</a>
            </c:when>
            <c:otherwise>
                <span>喵，欢迎来到天猫</span>
                <a href="/home/f_loginlogin">请登录</a>
                <a href="/home/f_register" target="_blank">免费注册</a>
            </c:otherwise>
        </c:choose>


        <span class="pull-right">
            <!--订单信息-->
            <a href="showOrder">我的订单</a>
            <!--购物车信息-->
            <a href="cart">
                <span class="glyphicon glyphicon-shopping-cart" style="color: #c40000"></span>
            购物车<strong style="color: #000">
            <c:choose>
                <c:when test="${!empty cartItemNumber}">${cartItemNumber}</c:when>
                <c:otherwise>0</c:otherwise>
            </c:choose>
            </strong>件
            </a>

        </span>

    </div>
</nav>

