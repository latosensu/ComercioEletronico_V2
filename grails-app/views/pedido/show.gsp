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
        <h1 class="page-header">Pedido ${pedido.id}</h1>
    </div>
    <!-- /.col-lg-12 -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-lg-12">
                        <div class="panel-body">
                            <div class="table-responsive table-bordered">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Nome</th>
                                        <th>Quantidade</th>
                                        <th>Preço Unitário</th>
                                        <th>Preço Total</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <g:each in="${pedido.itens}" var="item">
                                        <tr>
                                            <td>${item.produto.id}</td>
                                            <td>${item.produto.titulo}</td>
                                            <td>${item.quantidade}</td>
                                            <td>${item.produto.preco}</td>
                                            <td>${item.precoTotal}</td>
                                        </tr>

                                    </g:each>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->

                        </div>
                        <!-- /.panel -->

                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="panel-footer">
                    <p>Valor Total: ${pedido.total}</p>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.row -->
</body>
</html>
