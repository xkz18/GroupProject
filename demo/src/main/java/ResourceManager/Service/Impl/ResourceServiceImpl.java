package ResourceManager.Service.Impl;
import ResourceManager.repository.ResourceRepository;
import ResourceManager.entity.Resource;
import ResourceManager.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    ResourceRepository repository;

    @Override
    public List<Resource> getAllResource(){
        return repository.findAll();
    }


    @Override
    public void deleteResource(Integer resource_id){
        repository.deleteById(resource_id);
    }

    @Override
    public Resource getResource(Integer resource_id){
        return repository.getById(resource_id);
    }

    @Override
    public Resource saveResource(Resource resource){ return repository.save(resource); }


}





