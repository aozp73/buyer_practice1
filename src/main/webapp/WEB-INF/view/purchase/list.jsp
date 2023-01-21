<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <h1>구매 목록</h1>
        <table border="1">
            <tr>
                <th>번호</th>
                <th>구매자</th>
                <th>구매품</th>
                <th>구매갯수</th>
            </tr>
            <c:forEach items="${purchaseList}" var="purchase">
            <tr>
                <td>${purchase.id}</td>
                <td>${purchase.username}</td>
                <td>${purchase.name}</td>
                <td>${purchase.count}</td>
                <td>
                        <!-- 구매 히스토리 삭제하고, 재고를 채우는 2가지 해야 함 -->
                        <!-- 비지니스 로직을 가지고 있으므로 delete는 트랜잭션, 서비스에 구현 -->
                        <!-- 삭제하기전에 인증 같은 것도 다 확인 -->
                <form action="/purchase/${purchase.id}/delete" method="post">
                   <button type="submit">삭제</button>
                </form>
                 </td>
            </tr>
            </c:forEach>
        </table>


        <%@ include file="../layout/footer.jsp" %>