package com.baggio.projeto.carros_backend.dto;

import com.baggio.projeto.carros_backend.entity.Marca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {

  private Long id;
  private String nome;

  public MarcaDTO(Marca marca) {
    id = marca.getId();
    nome = marca.getNome();
  }

}
