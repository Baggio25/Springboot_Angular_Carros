-- -----------------------------------------------------
-- Table `marca`
-- -----------------------------------------------------
CREATE TABLE marca (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  CONSTRAINT pk_marca PRIMARY KEY (id)
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carro`
-- -----------------------------------------------------
CREATE TABLE carro (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  ano_fabricacao INT NOT NULL,
  ano_modelo INT NOT NULL,
  valor_fipe DECIMAL(10,2) NOT NULL,
  tipo_cambio VARCHAR(45) NOT NULL,
  marca_id INT NOT NULL,
  
  CONSTRAINT pk_carro PRIMARY KEY (id),
  INDEX fk_carro_marca_idx (marca_id ASC) VISIBLE,
  CONSTRAINT fk_id_marca
    FOREIGN KEY (marca_id)
    REFERENCES marca (id)
)ENGINE = InnoDB;