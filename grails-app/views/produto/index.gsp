<!doctype html>
<html>
<head>
    <meta name="layout" content="sb-admin-2"/>
    <title>Welcome to Comércio Eletrônico</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>
<body>
<div class="row">
    <div class="col-lg-9">
        <h1 class="page-header">Produtos</h1>
    </div>
    <div class="col-lg-3 col-md-6">
        <div class="panel panel-yellow">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-shopping-cart fa-3x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div>Itens: ${session["carrinhoCompras"]?.numeroItens?:0}</div>
                        <div>Total: ${session["carrinhoCompras"]?.precoTotal?:0}</div>
                    </div>
                </div>
            </div>
            <a href="#">
                <div class="panel-footer">
                    <g:link controller="carrinhoCompras">
                        <span class="pull-left">
                            Ver Detalhes
                        </span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    </g:link>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
    <!-- /.col-lg-12 -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <g:if test="${flash.message}">
                        <div class="alert alert-info">
                            ${flash.message}.
                        </div>
                    </g:if>

                    <h3>Catálogo</h3>
                    <p>Procure pelos produtos que deseja adicionar no carrinho </p>


                    <div class="col-lg-12">
                        <div class="panel-body">
                            <div class="table-responsive table-bordered">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Nome</th>
                                        <th>Preço</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <g:each in="${produtoList}" var="produto">
                                        <tr>
                                            <td>${produto.id}</td>
                                            <td>${produto.titulo}</td>
                                            <td>${produto.preco}</td>
                                            <td>
                                                <g:link controller="carrinhoCompras" action="selecionarProduto"
                                                        id="${produto.id}" class="btn btn-success btn-circle"><i
                                                        class="fa fa-plus"></i>
                                                </g:link>

                                                <g:link controller="produto" action="show" id="${produto.id}"
                                                        class="btn btn-info btn-circle"><i class="fa fa-eye"></i>
                                                </g:link>
                                            </td>
                                        </tr>

                                    </g:each>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-6 -->
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.row -->
</body>
</html>
