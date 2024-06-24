package com.baggio.projeto.carros_backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GenericService<DTO, T> {

  Page<DTO> findAllPaged(Pageable pageable);
  DTO findById(Long id);
  DTO save(DTO dto);
  DTO update(DTO dto, Long id);
  void delete(Long id);
  void dtoToEntity(DTO dto, T t);

}
