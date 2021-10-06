package ResourceManager.Service.Impl;
import ResourceManager.repository.ResourceRepository;
import ResourceManager.entity.Resource;
import ResourceManager.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    ResourceRepository repository;

    @Override
    public List<Resource> getAllResource(){
        return repository.findAll();
    }


    @Override
    public boolean deleteResource(Integer resource_id){
        Resource resource = repository.findById(resource_id).orElse(null);
        if (resource == null) return false;
        repository.deleteById(resource_id);
        return true;
    }


    @Override
    public Resource getResource(Integer resource_id){
        Optional<Resource> target = repository.findById(resource_id);
        if(target.isPresent()){
            return target.get();
        }
        else{
            return null;
        }
    }

    @Override
    public Resource saveResource(Resource resource){ return repository.save(resource); }


}





