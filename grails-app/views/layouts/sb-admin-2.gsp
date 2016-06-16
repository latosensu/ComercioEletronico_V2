<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        %{--Definição do título padrão--}%
        <g:layoutTitle default="Comércio Eletrônico"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <!--Adição dos arquivos application.css e application.js que conterão todas as dependências-->
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>
</head>
<body>

<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <!--Utilização de templates para renderizar cada parte da página-->
        <g:render template="/sb-admin2/navbar-header"/>
        <!--<div class="navbar-header">-->
            <!--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">-->
                <!--<span class="sr-only">Toggle navigation</span>-->
                <!--<span class="icon-bar"></span>-->
                <!--<span class="icon-bar"></span>-->
                <!--<span class="icon-bar"></span>-->
            <!--</button>-->
            <!--<a class="navbar-brand" href="/">Comércio Eletrônico v1.0</a>-->
        <!--</div>-->
        <!-- /.navbar-header -->

        <g:render template="/sb-admin2/navbar-right"/>
        <!--<ul class="nav navbar-top-links navbar-right">-->
            <!-- /.dropdown -->
            <!--<li class="dropdown">-->
                <!--<a class="dropdown-toggle" data-toggle="dropdown" href="#">-->
                    <!--<i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>-->
                <!--</a>-->
                <!--<ul class="dropdown-menu dropdown-user">-->
                    <!--<li><a href="#"><i class="fa fa-user fa-fw"></i> Perfil do Usuário</a>-->
                    <!--</li>-->
                    <!--<li class="divider"></li>-->
                    <!--<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>-->
                    <!--</li>-->
                <!--</ul>-->
                <!-- /.dropdown-user -->
            <!--</li>-->
            <!-- /.dropdown -->
        <!--</ul>-->
        <!-- /.navbar-top-links -->

        <g:render template="/sb-admin2/navbar-default"/>
        <!--<div class="navbar-default sidebar" role="navigation">-->
            <!--<div class="sidebar-nav navbar-collapse">-->
                <!--<ul class="nav" id="side-menu">-->
                    <!--<li>-->
                        <!--<a href="/"><i class="fa fa-dashboard fa-fw"></i> Index</a>-->
                    <!--</li>-->
                <!--</ul>-->
            <!--</div>-->
            <!-- /.sidebar-collapse -->
        <!--</div>-->
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
        <!--Aqui será apresentado o conteúdo de cada página-->
        <g:layoutBody/>

    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

</body>
</html>
