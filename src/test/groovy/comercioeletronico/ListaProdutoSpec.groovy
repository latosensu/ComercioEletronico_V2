package comercioeletronico

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

//O TestFor especifica a classe que está sendo testada. Nesse caso ListaProduto.
//Para rodar todos os testes podemos digitar test-app no modo iterativo do Grails
//Podemos especificar qual spec vamos testar, podemos digitar test-app comercioeletronico.ListaProdutoSpec
//O comando test-app -unit roda somente os testes unitários de todas as specs
@TestFor(ListaProduto)
class ListaProdutoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    //O unroll serve para mostrar cada uma das execuções do where
    //As variáveis do where podem aparecer na descrição usando # antes do nome delas
    @Unroll("Quando o preço do produto é #preco e a quantidade é #quantidade, o preço total é: #precoEsperado")
    void "Retornar preço total"() {
        when: "Criar um produto"
        def produto = new Produto(preco: preco)

        and: "Criar uma lista produto"
        def listaProduto = new ListaProduto(produto: produto, quantidade: quantidade)

        then: "Preço calculado é igual ao preço esperado"
        listaProduto.precoTotal == precoEsperado

        //No where, a tabela pode ter quantas colunas forem necessárias
        //Essas colunas contém valores utilizados no teste
        //As variáveis de 'entrada' são separadas pelo símbolo |
        //Já as variáveis de 'saída' (resultados) são separadas pelo símbolo ||
        where:
        preco | quantidade || precoEsperado
        10    | 5          || 50
        8     | 0          || 0
        56.75 | 5          || 283.75
    }
}
