package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, Id extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll()
    {
        return new HashSet<>(map.values());
    }

    T findById(Id id)
    {
        return map.get(id);
    }

    T save(T object)
    {
        if (object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else
        {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(Id id)
    {
        map.remove(id);
    }

    void delete(T object)
    {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){

        Set<Long> keySet = map.keySet();

        if(keySet.isEmpty()) return 1L;
            else return Collections.max(keySet) + 1;
    }
}
