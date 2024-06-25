package com.baggio.projeto.carros_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baggio.projeto.carros_backend.dto.CarroDTO;
import com.baggio.projeto.carros_backend.entity.Carro;
import com.baggio.projeto.carros_backend.entity.Marca;
import com.baggio.projeto.carros_backend.repository.CarroRepository;
import com.baggio.projeto.carros_backend.repository.MarcaRepository;
import com.baggio.projeto.carros_backend.service.exceptions.ResourceNotFoundException;
import com.baggio.projeto.carros_backend.util.Constants;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarroService implements GenericService<CarroDTO, Carro> {

  @Autowired
  private CarroRepository carroRepository;

  @Autowired
  private MarcaRepository marcaRepository;
  
  @Transactional(readOnly = true)
  @Override
  public Page<CarroDTO> findAllPaged(Pageable pageable) {
    Page<Carro> page = carroRepository.findAll(pageable);
    return page.map(carro -> new CarroDTO(carro));
  }
  
  @Transactional(readOnly = true)
  @Override
  public CarroDTO findById(Long id) {
    Optional<Carro> carroOpt = carroRepository.findById(id);
    Carro carro = carroOpt.orElseThrow(() -> new ResourceNotFoundException(Constants.RECURSO_NAO_ENCONTRADO));
    
    return new CarroDTO(carro);
  }
  
  @Transactional
  @Override
  public CarroDTO save(CarroDTO dto) {
    Carro carro = new Carro();
    dtoToEntity(dto, carro);
    carro = carroRepository.save(carro);
    
    return new CarroDTO(carro);
  }
  
  @Transactional
  @Override
  public CarroDTO update(CarroDTO dto, Long id) {
    try {
      Carro carro = carroRepository.getReferenceById(id);
      dtoToEntity(dto, carro);
      carro = carroRepository.save(carro);

      return new CarroDTO(carro);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(Constants.RECURSO_NAO_ENCONTRADO);
    }
  }

  @Override
  public void delete(Long id) {
    if(!carroRepository.existsById(id)) {
      throw new ResourceNotFoundException(Constants.RECURSO_NAO_ENCONTRADO);
    }

    try {
      carroRepository.deleteById(id);
    } catch (Exception e) {
      throw new ResourceNotFoundException(Constants.FALHA_DE_INTEGRIDADE);
    }
  }

  @Override
  public void dtoToEntity(CarroDTO dto, Carro carro) {
    carro.setNome(dto.getNome());
    carro.setAnoFabricacao(dto.getAnoFabricacao()); 
    carro.setAnoModelo(dto.getAnoModelo());
    carro.setValorFipe(dto.getValorFipe());
    carro.setTipoCambio(dto.getTipoCambio());

    Marca marca = marcaRepository.getReferenceById(dto.getMarca().getId());
    carro.setMarca(marca);
  }

}
