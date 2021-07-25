<%-- 
    Document   : header
    Created on : 20-jul-2021, 18:47:44
    Author     : Aylin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="vendor/bulma/css/bulma.min.css" rel="stylesheet" />
</head>
<body>
    <header>
        <nav class="navbar has-background-info-dark navbar-height" role="navigation"
             aria-label="main navigation">

        </nav>


        <nav id="navbar" class="bd-navbar navbar ">
            <div class="navbar-brand">
                <a class="navbar-item" href="ConsultarSaldo">
                    <img src="assets/img/logo.png" width="112" height="28">
                </a>

                <button id="navbarBurger" class="navbar-burger" data-target="navMenuDocumentation">
                    <span></span>
                    <span></span>
                    <span></span>
                </button>
            </div>

            <div id="navMenuDocumentation" class="navbar-menu">
                <div id="navbarStartOriginal" class="navbar-start bd-navbar-start bd-is-original">
                    <a class="
                       navbar-item bd-navbar-item bd-navbar-item-base bd-navbar-item-documentation

                       is-active
                       " href="ConsultarSaldo">
                        <span class="icon has-text-primary">
                            <i class="fas fa-book"></i>
                        </span>
                        <span class="is-hidden-tablet-only is-hidden-desktop-only">
                            Saldo
                        </span>
                        <span class="is-hidden-mobile is-hidden-widescreen">
                            Saldo
                        </span>
                    </a>

                    <a class="
                       navbar-item
                       bd-navbar-item
                       bd-navbar-item-videos
                       bd-navbar-item-base


                       " href="TransferirMonto">
                        <span class="icon has-text-success">
                            <i class="fas fa-play-circle"></i>
                        </span>

                        <span>Tranferencia</span>
                    </a>

                    <a class="
                       navbar-item
                       bd-navbar-item
                       bd-navbar-item-expo
                       bd-navbar-item-base


                       " href="Historial">
                        <span class="icon has-text-expo">
                            <i class="fas fa-star"></i>
                        </span>

                        <span>Movimientos</span>
                    </a>



                </div>


                <div class="navbar-end">

                    <div class="navbar-item bd-navbar-download-button is-hidden-touch">
                        <a class="is-primary mr-3" href="loginCliente">
                            <span class="icon">
                                <i class="fas fa-download"></i>
                            </span>
                            <span>Logout</span>
                        </a>

                    </div>

                </div>
            </div>

        </nav>
    </header>


</body>
</html>