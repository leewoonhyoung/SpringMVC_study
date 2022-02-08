<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: wh361
  Date: 2022-02-08
  Time: 오후 5:09
  To change this template use File | Settings | File Templates.
--%>

<%
    //request, response 사용 가능  따라서  extends HttpServlet 그냥 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("JspClass.jsp_service_method");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    Member savedMember = memberRepository.save(member);

%>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
