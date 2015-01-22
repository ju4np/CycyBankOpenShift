ALTER TABLE `movimientobancario`
	ADD COLUMN `tipoMovimientoBancario` ENUM('DEBE', 'HABER') NULL AFTER `motivo`;
	
ALTER TABLE `cliente`
	ADD COLUMN `fechaNacimiento` DATE NULL AFTER `dni`;
