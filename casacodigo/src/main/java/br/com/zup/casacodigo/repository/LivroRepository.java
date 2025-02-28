package br.com.zup.casacodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.casacodigo.modelo.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
