package com.baggio.projeto.carros_backend.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.baggio.projeto.carros_backend.dto.CarroDTO;
import com.baggio.projeto.carros_backend.service.CarroService;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

  @Autowired
  private CarroService carroService;

  @GetMapping(value = "/findById/{id}")
  public ResponseEntity<CarroDTO> findById(@PathVariable Long id) {
    CarroDTO carroDTO = carroService.findById(id);
    return ResponseEntity.ok(carroDTO);
  }

  @GetMapping(value = "/findAllPaged")
  public ResponseEntity<Page<CarroDTO>> findAllPaged(Pageable pageable) {
    Page<CarroDTO> pageCarroDTO = carroService.findAllPaged(pageable);
    return ResponseEntity.ok(pageCarroDTO);
  }

  @PostMapping(value = "/save")
  public ResponseEntity<CarroDTO> save(@RequestBody CarroDTO carroDTO) {
    carroDTO = carroService.save(carroDTO);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(carroDTO.getId()).toUri();

    return ResponseEntity.created(uri).body(carroDTO);
  }

  @PostMapping(value = "/update/{id}")
  public ResponseEntity<CarroDTO> update(@RequestBody CarroDTO carroDTO, @PathVariable Long id) {
    carroDTO = carroService.update(carroDTO, id);
    return ResponseEntity.ok(carroDTO);
  }

  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    carroService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
