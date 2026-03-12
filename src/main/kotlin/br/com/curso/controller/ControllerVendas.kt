package br.com.curso.controller

import br.com.curso.dto.input.VendasInput
import br.com.curso.servive.VendasService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/vendas")
class ControllerVendas (
        private val vendasService: VendasService
) {

    @Post
    fun realizarVenda(@Body vendasInput: VendasInput){
        vendasService.realizarVenda(vendasInput)
    }

}