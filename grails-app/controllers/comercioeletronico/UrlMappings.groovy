package comercioeletronico

class UrlMappings {

    static mappings = {

        //Mapeamos nosso recurso RESTful (pedidos),
        //apontando para o controller PedidoController
        "/pedidos"(resources: "pedido")
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
