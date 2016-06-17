package comercioeletronico

class CarrinhoComprasTagLib {

    //Definição do namespace
    static namespace = "cel"

    static defaultEncodeAs = [taglib:'raw']
//    static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def carrinhoCompras = { attrs, body ->
        out << """
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
        """
    }
}
