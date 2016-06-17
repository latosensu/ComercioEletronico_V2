import comercioeletronico.Usuario

class BootStrap {

    def init = { servletContext ->

        new Usuario("usuario", "normal", "usuario@teste.com").save(failOnError:true, flush: true)
    }
    def destroy = {
    }
}
