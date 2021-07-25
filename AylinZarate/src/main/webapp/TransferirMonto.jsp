<%-- 
    Document   : TransferirMonto
    Created on : 20-jul-2021, 21:25:51
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
        <c:if test="${mensaje !=null }">
		<div class="columns is-centered mb-4 mt-2">
			<div class="column is-6">
				<div class="notification is-primary">
					<p>${mensaje}</p>
				</div>
			</div>
		</div>
	</c:if>    
        <c:if test="${errores != null}">
            <div class="columns is-centered mt-6">
                <div class="column is-6">
                    <div class="notification is-danger">
                        <h6>Existen Errores en el formulario</h6>
                        <div class="content">
                            <ul>
                                <c:forEach items="${errores}" var="error">
                                    <li>${error}</li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="columns is-centered mt-6">
            <div class="column is-6">
                <form method="POST" action="TransferirMonto">
                    <div class="card">
                        <div class="card-header has-background-info">
                            <span class="card-header-title is-centered has-text-link-light">Transferencia</span>
                        </div>
                        <div class="card-content">



                            <div class="field">
                                <label class="label" for="origen-txt">Número de Cuenta Origen</label>
                                <div class="columns">
                                    <div class="column is-4">
                                        <div class="control">
                                            <input type="text" class="input"autocomplete="off"

                                                   id="origen-txt" name="origen-txt" maxlength="8" value="${cuenta.getNumerocta()}" disabled="true"/>
                                        </div>
                                    </div>
                                </div>
                            </div>




                            <div class="field">
                                <label class="label" for="destino-txt">Número cuenta Destino</label>
                                <div class="control">
                                    <input type="text" class="input"
                                           autocomplete="off" id="destino-txt" name="destino-txt" />
                                </div>
                            </div>
                            <div class="field">
                                <label class="label" for="monto-txt">Monto</label>
                                <div class="control">
                                    <input type="text" class="input"
                                           autocomplete="off" id="monto-txt" name="monto-txt" />
                                </div>
                            </div>
                            <div class="field">
                                <label class="label" for="edad-txt">Clave</label>
                                <div class="control">
                                    <input type="text" class= "input" autocomplete="off" name="clave-txt" id="clave-txt" class="input" />
                                </div>
                            </div>



                        </div>
                        <div class="card-footer has-text-centered">
                            <div class="card-footer-item">
                                <button type="submit" class="button is-info">TRANSFERIR</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </main>
</html>