package ResourceManager.Service;


import ResourceManager.entity.Resource;


import java.util.List;

public interface ResourceService {
    public List<Resource> getAllResource();

    public void deleteResource(Integer resource_id);
    public Resource getResource(Integer resource_id);
    public Resource saveResource(Resource resource);
}


