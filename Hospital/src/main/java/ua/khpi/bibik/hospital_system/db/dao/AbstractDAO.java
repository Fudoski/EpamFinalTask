package ua.khpi.bibik.hospital_system.db.dao;

import ua.khpi.bibik.hospital_system.entity.Entity;

public abstract class AbstractDAO<E extends Entity> {

	public abstract E insert(E entity);

	public abstract E update(E entity);

	public abstract E delete(E entity);

	public abstract E find(E entity);

	public abstract E selectById(int id);

}
