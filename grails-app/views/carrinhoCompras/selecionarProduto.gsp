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
        <h1 class="page-header">Produto </h1>
    </div>
    <!-- /.col-lg-12 -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <!--Podemos apresentar as informações do nosso produto-->
                    <h3>${produto.titulo}</h3>
                    <p>${produto.descricao}</p>
                    <p>Preço:
                        <g:formatNumber number="${produto.preco}" type="currency"/>
                    </p>

                    <!--Especificamos um form, e definimos o nome do controller e action-->
                    <g:form controller="carrinhoCompras" action="adicionarProduto">
                        <!--O name dos fields deve ser igual esperado pelo controller para fazer o bind-->
                        <g:field type="hidden" name="produto" value="${produto.id}"/>
                        <g:field type="number" name="quantidade" min="1" required=""/>
                        <!--O submitButton envia o form-->
                        <g:submitButton class='btn btn-success' name="enviar" value="Adicionar no carrinho" />
                    </g:form>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.row -->
</body>
</html>
