ALTER TABLE `cuenta`
	ADD COLUMN `pin` INT ZEROFILL NOT NULL DEFAULT '0' AFTER `sucursalBancaria`;

