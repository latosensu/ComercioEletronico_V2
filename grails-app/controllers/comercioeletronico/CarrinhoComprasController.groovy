package comercioeletronico

import grails.converters.JSON
import grails.validation.ValidationException

class CarrinhoComprasController {

    //Podemos alterar o escopo do controller para session (por padrão é singleton)
    //O escopo session mantém as variáveis do controller na sessão do usuário
    //O singleton apresenta as mesmas variáveis para todos os usuários
    //O outro escopo é o prototype e a variável só vale para uma determinada request
    static scope = "session"

    //O responseFormats define quais formatos de resposta são possíveis para o controller
    //A ordem da lista define qual o formato padrão (no caso html)
    //Se não houver o um html possível, gera o próximo formato (JSON)
    //Podemos especificar o formato pela url, colocando por exemplo:
    //http://localhost:8080/carrinhoCompras.json
    static responseFormats = ['html', 'json', 'xml']

    //O allowedMethods define que tipo de método HTTP cada uma das nossas
    //actions consegue responder. Se o usuário tentar mandar um outro tipo
    //de método HTTP, receberá uma resposta 405 (Method Not Allowed)
    static allowedMethods = [index: 'GET', adicionarProduto: 'POST', removerProduto: 'DELETE']

    //Variável do controller
//    CarrinhoCompras carrinhoCompras = new CarrinhoCompras()

    //Bean utilizado para mostrar a mensagem adequada para cada tipo de erro
    def messageSource

    //Bean do nosso service PedidoService. O Grails injeta automaticamente essa
    //dependência para nós.
    def pedidoService

    def index() {
        //Por convenção, ao utilizar o respond, o Grails procura uma view index,
        //como não existe uma view gsp, a view JSON que definimos é encontrada
        //O carrinhoCompras é utilizado como model da view
        CarrinhoCompras carrinhoCompras = obterCarrinhoCompras()
        respond carrinhoCompras
    }

    //Esse método procura o carrinho na sessão, se não encontrar, cria um novo carrinho e coloca na sessão
    private CarrinhoCompras obterCarrinhoCompras() {

        CarrinhoCompras carrinhoCompras = session['carrinhoCompras']
        if (!carrinhoCompras){
            carrinhoCompras = new CarrinhoCompras()
            session.carrinhoCompras = carrinhoCompras
        }
        return carrinhoCompras
    }

    def adicionarProduto(ListaProduto listaProduto) {
        if (!listaProduto.validate()) {
            def erros = listaProduto.errors.allErrors.inject([], { listaErros, erro ->
                (listaErros << messageSource.getMessage(erro, null))
            })
            render erros as JSON
            return
        }
        CarrinhoCompras carrinhoCompras = obterCarrinhoCompras()
        carrinhoCompras.adicionarProduto(listaProduto)
        flash.message = "Produto adicionado com sucesso"
        redirect (controller: 'produto')
//        render([mensagem: "Produto adicionado com sucesso"] as JSON)
    }

    def removerProduto() {
        Produto produto = Produto.get(params.id)
        try {
            CarrinhoCompras carrinhoCompras = obterCarrinhoCompras()
            carrinhoCompras.removerProduto(produto)
        }
        catch (Exception e) {
            render([erro: e.message] as JSON)
            return
        }
        flash.message = "Produto removido com sucesso"
        redirect (controller: 'produto')
//        render([sucesso: "Produto removido com sucesso"] as JSON)
    }

    def finalizarCarrinho() {
        CarrinhoCompras carrinhoCompras = obterCarrinhoCompras()
        try {
            pedidoService.registrarPedido(carrinhoCompras)
        }
        catch (ValidationException e) {
            //Se não for possível registrar o pedido, mostramos os erros
            def erros = e.errors.allErrors.inject([], { listaErros, erro ->
                (listaErros << messageSource.getMessage(erro, Locale.default))
            })

            render(erros as JSON)
            return
        }
        //Se finalizarmos o pedido, reiniciamos nosso carrinho de compras
        //e mostramos mensagem de sucesso
        session['carrinhoCompras'] = new ArrayList<ListaProduto>()
        render([sucesso: "Pedido finalizado com sucesso"])
    }

    def selecionarProduto(Produto produto){
        //O respond por padrão manda para a view de mesmo nome da action
        respond produto
    }

}
