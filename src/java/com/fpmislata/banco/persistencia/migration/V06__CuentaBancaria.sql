ALTER TABLE `cuenta`
	DROP COLUMN `cuentaBancaria`;
ALTER TABLE `cuenta`
	ADD COLUMN `cuentaBancaria` VARCHAR(24) NOT NULL AFTER `pin`;
