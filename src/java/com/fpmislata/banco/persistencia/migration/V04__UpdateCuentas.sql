ALTER TABLE `cuenta`
	CHANGE COLUMN `sucursalBancaria` `sucursalBancaria` INT NOT NULL AFTER `fechaCreacion`;
ALTER TABLE `cuenta`
	ADD COLUMN `cuentaBancaria` INT(24) ZEROFILL NOT NULL AFTER `sucursalBancaria`;