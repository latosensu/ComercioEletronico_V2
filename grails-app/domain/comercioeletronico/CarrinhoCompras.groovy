package comercioeletronico

//A classe CarrinhoCompras não deve ser armazenada no banco de dados
class CarrinhoCompras {


    //Podemos especificar a variável itens, definindo seu tipo como List de
    //ListaProduto. Podemos também inicializá-la. No caso como ArrayList
    //que é uma classe que herda de List
    List<ListaProduto> itens = new ArrayList<ListaProduto>()

    //O hasMany especifica que um CarrinhoCompras terá muitos itens da classe ListaProduto
    static hasMany = [itens: ListaProduto]

    //Com o mapWith informamos que a classe não deverá ser mapeada no banco de dados
    static mapWith = "none"

    //Uma classe pode ter um ou vários transientes
    static transients = ['numeroItens', 'precoTotal']

    //Cada transiente deve ter seu próprio get
    Integer getNumeroItens() {
        return itens.size()
    }
    BigDecimal getPrecoTotal() {
        itens.inject(0, { inicial, item ->
            return inicial + item.precoTotal
        })
    }

    static constraints = {
    }
}
