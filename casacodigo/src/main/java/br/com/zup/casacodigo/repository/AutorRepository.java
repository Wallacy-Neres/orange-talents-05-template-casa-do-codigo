package br.com.zup.casacodigo.repository;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> ceaff7cbb20a629e35fef03fb596991c7821ccc6
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.casacodigo.modelo.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
<<<<<<< HEAD

	Optional<Autor> findByEmail(String email);
=======
>>>>>>> ceaff7cbb20a629e35fef03fb596991c7821ccc6
	
}
