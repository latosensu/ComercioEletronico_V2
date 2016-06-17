package comercioeletronico

//A classe CarrinhoCompras não deve ser armazenada no banco de dados
class CarrinhoCompras {

    Usuario usuario

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

    void adicionarProduto(ListaProduto listaProduto) {
        //O método find recebe uma clousure como parâmetro
        //O retorno da clousure deve ser um boolean.
        //Se o retorno da clousure for true para um determinado item,
        //o find retorna o item da lista
        //Caso contrário, o find retorna null.
        ListaProduto itemExistente = itens.find { item ->
            item.produto.id == listaProduto.produto.id
        }
        if (itemExistente) {
            itemExistente.quantidade += listaProduto.quantidade
            return
        }
        this.itens.add(listaProduto)
    }

    void removerProduto(Produto produto) {
        //O removeIf é semelhante ao find. Mas quando o item é encontrado
        //ele é removido da lista, e o retorno do removeIf é true.
        //Caso contrário o retorno é falso
        Boolean removido = itens.removeIf { listaProduto ->
            listaProduto.produto.id == produto?.id
        }
        if (!removido) {
            throw new Exception("Produto não existente no carrinho")
        }
    }

    static constraints = {
    }
}
