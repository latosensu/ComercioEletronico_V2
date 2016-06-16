package comercioeletronico

class CarrinhoComprasController {

    //Variável do controller
    CarrinhoCompras carrinhoCompras = new CarrinhoCompras()

    def index() {
        //Por convenção, ao utilizar o respond, o Grails procura uma view index,
        //como não existe uma view gsp, a view JSON que definimos é encontrada
        //O carrinhoCompras é utilizado como model da view
        respond carrinhoCompras
    }
}
