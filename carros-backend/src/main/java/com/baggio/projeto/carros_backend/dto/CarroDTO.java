package com.baggio.projeto.carros_backend.dto;

import java.math.BigDecimal;

import com.baggio.projeto.carros_backend.entity.Carro;
import com.baggio.projeto.carros_backend.entity.enums.TipoCambio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {
  
  private Long id;

  private String nome;

  private Integer anoFabricacao;

  private Integer anoModelo;

  private BigDecimal valorFipe;
  
  private TipoCambio tipoCambio;

  private MarcaDTO marca;

  public CarroDTO(Carro carro) {
    id = carro.getId();
    nome = carro.getNome();
    anoFabricacao = carro.getAnoFabricacao();
    anoModelo = carro.getAnoModelo();
    valorFipe = carro.getValorFipe();
    tipoCambio = carro.getTipoCambio();
    marca = new MarcaDTO(carro.getMarca());
  }

}
