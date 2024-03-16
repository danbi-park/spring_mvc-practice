<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- import --%>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
    //request, response 사용 가능
    //servlet으로 자동으로 변환되서 사용됨.
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);

%>
<%-- JSP표시가 없으면 나ㅂ머지는 println 으로 다 표시되는거임 --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    
    <%--<%=((Member)request.getAttribute("member")).getId()%>--%>
    <li>id=<%=member.getId()%></li>
<%-- 프로퍼티 접근법--%>
     <li>id=${member.id}</li>

    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
