package MadreSelvaCosmetics4.service;

import MadreSelvaCosmetics4.model.Cosmetics4;
import MadreSelvaCosmetics4.repository.Cosmetics4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Elsy Del Águila
 */
@Service
public class Cosmetics4Service {

    @Autowired
    private Cosmetics4Repository Cosmetics4Repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Cosmetics4> getAll() {
        return Cosmetics4Repository.getAll();
    }

    public Optional<Cosmetics4> getCosmetics4(String reference) {
        return Cosmetics4Repository.getCosmetics4(reference);
    }

    public Cosmetics4 create(Cosmetics4 Cosmetics4) {
        if (Cosmetics4.getReference() == null) {
            return Cosmetics4;
        } else {
            return Cosmetics4Repository.create(Cosmetics4);
        }
    }

    public Cosmetics4 update(Cosmetics4 Cosmetics4) {

        if (Cosmetics4.getReference() != null) {
            Optional<Cosmetics4> Cosmetics4Db = Cosmetics4Repository.getCosmetics4(Cosmetics4.getReference());
            if (!Cosmetics4Db.isEmpty()) {
                if (Cosmetics4.getBrand() != null) {
                    Cosmetics4Db.get().setBrand(Cosmetics4.getBrand());
                }

                if (Cosmetics4.getCategory() != null) {
                    Cosmetics4Db.get().setCategory(Cosmetics4.getCategory());
                }

                if (Cosmetics4.getName() != null) {
                    Cosmetics4Db.get().setName(Cosmetics4.getName());
                }

                if (Cosmetics4.getDescription() != null) {
                    Cosmetics4Db.get().setDescription(Cosmetics4.getDescription());
                }
                if (Cosmetics4.getPrice() != 0.0) {
                    Cosmetics4Db.get().setPrice(Cosmetics4.getPrice());
                }
                if (Cosmetics4.getQuantity() != 0) {
                    Cosmetics4Db.get().setQuantity(Cosmetics4.getQuantity());
                }
                if (Cosmetics4.getPhotography() != null) {
                    Cosmetics4Db.get().setPhotography(Cosmetics4.getPhotography());
                }
                Cosmetics4Db.get().setAvailability(Cosmetics4.isAvailability());
                Cosmetics4Repository.update(Cosmetics4Db.get());
                return Cosmetics4Db.get();
            } else {
                return Cosmetics4;
            }
        } else {
            return Cosmetics4;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCosmetics4(reference).map(Cosmetics4 -> {
            Cosmetics4Repository.delete(Cosmetics4);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
