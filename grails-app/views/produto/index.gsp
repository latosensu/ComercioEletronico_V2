<!doctype html>
<html>
<head>
    <meta name="layout" content="sb-admin-2"/>
    <title>Welcome to Comércio Eletrônico</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Produtos</h1>
    </div>
    <!-- /.col-lg-12 -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
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
                                                <g:link controller="carrinhoCompras" action="selecionarProduto" id="${produto.id}"class="btn btn-success btn-circle"><i class="fa fa-plus"></i>
                                                </g:link>

                                                <g:link controller="produto" action="show" id="${produto.id}"class="btn btn-info btn-circle"><i class="fa fa-eye"></i>
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
