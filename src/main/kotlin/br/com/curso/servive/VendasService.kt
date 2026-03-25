package br.com.curso.servive

import br.com.curso.dto.input.VendasInput
import br.com.curso.dto.output.Parcela
import br.com.curso.dto.output.Venda
import br.com.curso.http.VeiculoHttp
import jakarta.inject.Singleton
import java.time.LocalDateTime

@Singleton
class VendasService(
        private val veiculoService: VeiculoService
) {
    fun realizarVenda(vendasInput: VendasInput) {
        val veiculo = veiculoService.getVeiculo(vendasInput.veiculo)
        var parcelas: List<Parcela> = ArrayList<Parcela>()
        var valorParcela = vendasInput.valor.divide(vendasInput.qtdParcelas.toBigDecimal())
        var dataVencimento = LocalDateTime.now().plusMonths(1)

        for (i in 1..vendasInput.qtdParcelas) {
            var parcela = Parcela(valorParcela, dataVencimento.toString(), i)
            parcelas = parcelas.plus(parcela)
            dataVencimento = dataVencimento.plusMonths(1)
        }
        var venda= Venda(vendasInput.cliente, veiculo, vendasInput.valor, parcelas)
        println( venda)
    }
}