package com.baggio.projeto.carros_backend.entity;

import java.math.BigDecimal;

import com.baggio.projeto.carros_backend.entity.enums.TipoCambio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carro")
public class Carro {
  
  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome", nullable = false)
  private String nome;
  
  @Column(name = "ano_fabricacao", nullable = false)
  private Integer anoFabricacao;

  @Column(name = "ano_modelo", nullable = false)
  private Integer anoModelo;

  @Column(name = "valor_fipe", nullable = false)
  private BigDecimal valorFipe;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_cambio", nullable = false)
  private TipoCambio tipoCambio;

}
