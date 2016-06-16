package comercioeletronico

class ListaProduto {

    Produto produto
    Integer quantidade

    //Propriedade transiente, ou seja, não é persistida no banco de dados
    static transients = ['precoTotal']

    //Get para a propriedade transiente, para o Grails saber como calcular
    //o valor da propriedade
    BigDecimal getPrecoTotal() {
        return quantidade * produto.preco
    }

    static constraints = {
    }
}
