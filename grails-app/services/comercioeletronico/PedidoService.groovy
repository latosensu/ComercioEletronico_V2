package comercioeletronico

import grails.transaction.Transactional
import grails.validation.ValidationException

//O @Transactional define que abriremos uma nova transação para cada método
//do nosso service
@Transactional
class PedidoService {

    //Criamos um service para registrar o pedido, pois poderíamos
    //ter regras de negócio complexas aqui, permitindo ou não o registro
    //do pedido. Se simplesmente criássemos uma nova instância de Pedido
    //essas regras de negócio ficariam na classe de domínio, e ela teria
    //responsabilidades que não são adequadas para ela
    Pedido registrarPedido(CarrinhoCompras carrinhoCompras) {
        Pedido novoPedido = new Pedido(carrinhoCompras.properties)
        novoPedido.dataPedido = new Date()
        if (!novoPedido.save()) {
            throw new ValidationException("", novoPedido.errors)
        }
        return novoPedido

    }
}
