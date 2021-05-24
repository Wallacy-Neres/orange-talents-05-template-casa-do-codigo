package br.com.zup.casacodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.zup.casacodigo.modelo.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Estado findByNome(String nome);

	
	@Query("Select e from Estado e where e.nome =:nomeParam And pais.id = :pais")
	public Optional<Estado> findEstadoBanco(@Param("nomeParam") String nome, @Param("pais") Long id);

}
