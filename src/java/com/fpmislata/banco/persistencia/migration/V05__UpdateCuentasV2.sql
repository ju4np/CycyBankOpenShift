ALTER TABLE `cuenta`
	CHANGE COLUMN `cuentaBancaria` `cuentaBancaria` VARCHAR(24) NOT NULL AFTER `sucursalBancaria`,
	CHANGE COLUMN `pin` `pin` INT(6) UNSIGNED ZEROFILL NOT NULL DEFAULT '123456' AFTER `cuentaBancaria`;