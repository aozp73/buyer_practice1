<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <h1>상품 목록</h1>
        <table border="1">
            <tr>
                <td>번호</td>
                <td>이름</td>
                <td>가격</td>
                <td>재고</td>
                <td>등록일</td>
            </tr>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.qty}</td>
                <td>${product.createdAt}</td>
            </tr>
        </table>

        <%@ include file="../layout/footer.jsp" %>