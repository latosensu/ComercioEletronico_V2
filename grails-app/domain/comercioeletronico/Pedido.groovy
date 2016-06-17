package comercioeletronico

class Pedido {
    List<ListaProduto> itens = new ArrayList<ListaProduto>()
    static hasMany = [itens: ListaProduto]

    Date dataPedido
    Usuario usuario
    static transients = ['total']

    BigDecimal getTotal() {
        //O inject começa com um valor inicial, no nosso caso 0,
        //e para cada item da lista (item) vai atualizando o valor
        //inicial
        itens.inject(0, { inicial, item ->
            return inicial + item.precoTotal
        })
    }

    static constraints = {
        //O pedido, quando for criado, deve ter ao menos 1 item
        itens minSize: 1
    }
}
