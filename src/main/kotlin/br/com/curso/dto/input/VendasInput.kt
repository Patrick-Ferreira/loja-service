package br.com.curso.dto.input

import java.math.BigDecimal

data class VendasInput(
        val cliente: String,
        val veiculo: Long,
        val valor: BigDecimal,
        val qtdParcelas: Int
)
