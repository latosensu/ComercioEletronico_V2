package comercioeletronico

class CarrinhoComprasController {


    //Podemos alterar o escopo do controller para session (por padrão é singleton)
    //O escopo session mantém as variáveis do controller na sessão do usuário
    //O singleton apresenta as mesmas variáveis para todos os usuários
    //O outro escopo é o prototype e a variável só vale para uma determinada request
    static scope = "session"

    //Variável do controller
    CarrinhoCompras carrinhoCompras = new CarrinhoCompras()

    def index() {
        //Por convenção, ao utilizar o respond, o Grails procura uma view index,
        //como não existe uma view gsp, a view JSON que definimos é encontrada
        //O carrinhoCompras é utilizado como model da view
        respond carrinhoCompras
    }
}
