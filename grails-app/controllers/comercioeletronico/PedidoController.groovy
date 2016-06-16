package comercioeletronico

import grails.rest.RestfulController

//Nosso controller herda de RestfulController, pois queremos expor ele como
//um recurso Restful de Pedido
class PedidoController extends RestfulController<Pedido> {

    static responseFormats = ['html', 'json', 'xml']

    PedidoController() {
        //Ao passar true como segundo argumento, especificamos que
        //esse controller é readOnly, ou seja, só terá actions de leitura
        //como listagem e detallhe de pedido. Não poderemos criar um pedido
        //novo ou alterar um já existente. Nem remover.
        super(Pedido.class, true)
    }
}
