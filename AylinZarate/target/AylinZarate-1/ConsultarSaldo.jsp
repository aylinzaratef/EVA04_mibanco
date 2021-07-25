<%-- 
    Document   : ConsultarSaldo
    Created on : 20-jul-2021, 21:25:25
    Author     : Aylin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="WEB-INF/templates/header.jsp"></jsp:include>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Mi Banco</title>
        </head>


        <body>

            <!-- END NAV -->
            <div class="columns is-centered mt-5">
                <div class="column is-10">
                    <section class="hero is-info welcome is-small">
                        <div class="hero-body">
                            <div class="container">
                                <h1 class="title">
                                    BIENVENID@ ${cliente.getNombre()}
                            </h1>
                            <h2 class="subtitle">

                            </h2>
                        </div>
                    </div>
                </section>
                <section class="info-tiles">
                    <div class="tile is-ancestor has-text-centered">
                        <div class="tile is-parent">
                            <article class="tile is-child box">
                                <p class="title">$ ${cuenta.getSaldo()}</p>
                                <p class="subtitle">Saldo Actual</p>
                            </article>

                        </div>
                        <div class="tile is-parent">
                            <article class="tile is-child box">
                                <p class="title">$ ${cuenta.getSaldolineacredito()}</p>
                                <p class="subtitle">Linea de crédito</p>
                            </article>

                        </div>
                                <div class="tile is-parent">
                            <article class="tile is-child box">
                                <p class="title">$ ${cuenta.getSaldolineacreditousado()}</p>
                                <p class="subtitle">Linea de crédito utilizada</p>
                            </article>

                        </div>
                    </div>

                </section>
            </div>
        </div>
    </body>






</html>

