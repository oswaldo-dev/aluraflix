package br.com.alura.aluraflix.repository;

import br.com.alura.aluraflix.model.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

}
