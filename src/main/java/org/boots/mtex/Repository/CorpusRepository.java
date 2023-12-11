package org.boots.mtex.Repository;

import org.boots.mtex.Entity.Corpus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorpusRepository extends JpaRepository<Corpus, Long> {

    Corpus findCorpusByModel(String model);
}
