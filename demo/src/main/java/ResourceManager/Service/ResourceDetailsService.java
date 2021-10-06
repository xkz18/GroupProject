package ResourceManager.Service;
import ResourceManager.entity.Resource;
import ResourceManager.entity.ResourceDetails;

import java.util.List;

public interface ResourceDetailsService {
    public List<ResourceDetails> getAllDetails();
    public ResourceDetails createDetails(ResourceDetails resourceDetails);
    public void deleteDetails(Integer detail_id);
    public ResourceDetails getDetails(Integer detail_id);
    public ResourceDetails saveDetails(ResourceDetails details);

}

