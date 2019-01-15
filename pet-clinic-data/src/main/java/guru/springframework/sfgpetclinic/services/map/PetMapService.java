package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService{
    @Override
    public Set<Pet> findAll()
    {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object)
    {
        super.delete(object);
    }

    @Override
    public Pet fingById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object)
    {
        return super.save(object);
    }
}