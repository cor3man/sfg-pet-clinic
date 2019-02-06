package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String lastName = "Alex";

    @BeforeEach
    void setUp()
    {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().Id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll()
    {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById()
    {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete()
    {
        ownerMapService.delete(ownerMapService.fingById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void fingById()
    {
        Owner owner = ownerMapService.fingById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save()
    {
    }

    @Test
    void saveExistingId()
    {
        Long id = 2L;
        Owner owner2 = Owner.builder().Id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void seveNoId()
    {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
    }

    @Test
    void findByLastName()
    {
        Owner alex = ownerMapService.findByLastName(lastName);
        assertNotNull(alex);
        assertEquals(ownerId, alex.getId());
    }

    @Test
    void findByLastNameNotFound()
    {
        Owner alex = ownerMapService.findByLastName("foo");
        assertNull(alex);
    }
}