package comercioeletronico

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

    //Variável do controller
    CarrinhoCompras carrinhoCompras = new CarrinhoCompras()

    def index() {
        //Por convenção, ao utilizar o respond, o Grails procura uma view index,
        //como não existe uma view gsp, a view JSON que definimos é encontrada
        //O carrinhoCompras é utilizado como model da view
        respond carrinhoCompras
    }
}
