<%-- 
    Document   : index
    Created on : 20-jul-2021, 18:47:25
    Author     : Aylin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Banco de Chile</title>
        <link rel="shortcut icon" href="../assets/img/images.ico" />
        <script src="assets/js/particles.js"></script>
        <script src="assets/js/main.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.5.3/css/bulma.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=0">
        <link rel="stylesheet" href="assets/css/main.css">
    </head>
    <main>
        <div class="columns is-vcentered">

            <div class="login column is-4 ">

                <section class="section">
                    <div class="has-text-centered">
                        <img class="login-logo" src="assets/img/logo.png">
                    </div>
                    <c:if test="${errores != null}">
                        <div class="notification is-danger">
                            <div class="content">
                                <ul>
                                    <c:forEach items="${errores}" var="error">
                                        <li>${error}</li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </c:if>
                    <form method="POST" action="loginCliente">
                        <div class="field">
                            <label class="label">Rut</label>
                            <div class="control has-icons-right">
                                <input class="input is-info" type="text" name="rut-txt" id="rut-txt" >
                                <span class="icon is-small is-right">
                                    <i class="fa fa-user"></i>
                                </span>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">Contraseña</label>
                            <div class="control has-icons-right">
                                <input class="input is-info" type="password" name="clave-txt" id="clave-txt">
                                <span class="icon is-small is-right">
                                    <i class="fa fa-key"></i>
                                </span>
                            </div>
                        </div>
                        <div class="has-text-centered">
                            <button type="submit" class="button is-vcentered is-info is-outlined">Ingresar</button>
                        </div>
                        <div class="has-text-centered has-text-info">
                            <h> ¿No tienes una cuenta? ¡Registrate ahora!</h>
                        </div>
                    </form>

                </section>
            </div>
            <div id="particles-js" class="interactive-bg column is-8">
            </div>
        </div>
    </main>
</html>



