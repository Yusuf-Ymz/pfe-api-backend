package be.ipl.pfe.adapters;

import be.ipl.pfe.ports.IdGenerator;

import java.util.UUID;

public class UuidGenerator implements IdGenerator {
	@Override
	public String generate() {
		return UUID.randomUUID().toString();
	}
}
