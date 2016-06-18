import comercioeletronico.Produto

class BootStrap {

    def init = { servletContext ->
        5.times{ i ->
            new Produto(sku: "a", descricao: "a", preco: 4, titulo: "Produto ${i}").save(failOnError:true, flush: true)
        }
    }
    def destroy = {
    }
}
