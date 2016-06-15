package comercioeletronico

class Produto {

    String sku
    String titulo
    String descricao
    //BigDecimal é uma classe mais adequada para tratar valores monetários
    BigDecimal preco

    static mapping = {
        //Mapeamento como text para permitir a entra de textos maiores
        //do que 255 caracteres
        descricao type: 'text'
    }

    static constraints = {
    }
}
