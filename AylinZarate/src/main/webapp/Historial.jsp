<%-- 
    Document   : Historial
    Created on : 20-jul-2021, 21:26:04
    Author     : Aylin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="WEB-INF/templates/header.jsp"></jsp:include>

<html>
<main>
    <div class="columns is-centered mt-6">
            <div class="column is-8">
                <div class="table-container">
                    <table class="table is-fullwidth is-bordered is-striped is-narrow is-hoverable">
                        <thead>
                            <tr>
                                <th>Descripción</th>
                                <th>Fecha</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaMovimientos}" var="mov">
                            <tr>
                                <td>${mov.getDescripcion()}</td>
                                <td><fmt:formatDate value="${mov.getFecha()}" pattern="dd-MM-yyyy" /></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
    </div>
    <div class="columns is-centered mt-6">
            <div class="column is-8">
                <span class="tag">
                    Total de movimientos: ${fn:length(listaMovimientos)}
                </span>
            </div>
    </div>
</main>
</html>