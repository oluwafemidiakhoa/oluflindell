package lottery.backend.persistence;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import lottery.backend.domain.Contender;

@Repository
public interface ContenderPersistence extends CrudRepository<Contender, Long> { }
