ALTER TABLE `cuenta`
	CHANGE COLUMN `sucursalBancaria` `sucursalBancaria` INT NOT NULL AFTER `fechaCreacion`;
ALTER TABLE `cuenta`
	ADD COLUMN `cuentaBancaria` INT(24) ZEROFILL NOT NULL AFTER `sucursalBancaria`;
ALTER TABLE `sucursal`
	CHANGE COLUMN `codigoSucursal` `codigoSucursal` INT(3) NOT NULL DEFAULT '0' AFTER `localizacion`;