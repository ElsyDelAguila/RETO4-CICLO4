package MadreSelvaCosmetics4.repository;

import MadreSelvaCosmetics4.model.Cosmetics4;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import MadreSelvaCosmetics4.repository.crud.Cosmetics4CrudRepository;

/**
 *
 * @author Elsy Del Águila
 */
@Repository
public class Cosmetics4Repository {
    @Autowired
    private Cosmetics4CrudRepository repository;

    public List<Cosmetics4> getAll() {
        return repository.findAll();
    }

    public Optional<Cosmetics4> getCosmetics4(String reference) {
        return repository.findById(reference);
    }
    
    public Cosmetics4 create(Cosmetics4 Cosmetics4) {
        return repository.save(Cosmetics4);
    }

    public void update(Cosmetics4 Cosmetics4) {
        repository.save(Cosmetics4);
    }
    
    public void delete(Cosmetics4 Cosmetics4) {
        repository.delete(Cosmetics4);
    }
}
