package ResourceManager.Service.Impl;

import ResourceManager.entity.ProjectColumns;
import ResourceManager.entity.Resource;
import ResourceManager.entity.User;
import ResourceManager.repository.ProjectColumnRepository;
import ResourceManager.repository.ResourceDetailsRepository;
import ResourceManager.entity.ResourceDetails;
import ResourceManager.Service.ResourceDetailsService;
import ResourceManager.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Example.*;


@Service
public class ResourceDetailsServiceImpl implements ResourceDetailsService {
    @Autowired
    ResourceDetailsRepository repository;
    ResourceRepository resource_rep;
    ProjectColumnRepository column_rep;


    @Override
    public List<ResourceDetails> getAllDetails(){
        return repository.findAll();
    }

    @Override
    public ResourceDetails createDetails(Integer resource_id, Integer column_id, String detail_value){
        Resource resource = resource_rep.findById(resource_id).orElse(null);
        ProjectColumns column = column_rep.findById(column_id).orElse(null);
        if(resource ==null || column == null ){
            System.out.println("ID is not valid");
            return null;
        }
        ResourceDetails details = new ResourceDetails();
        details.setProjectColumns(column);
        details.setResources(resource);
        details.setDetail_value(detail_value);
        return repository.save(details);
    }



    @Override
    public void deleteDetails(Integer detail_id){
        repository.deleteById(detail_id);
    }

    @Override
    public ResourceDetails getDetails(Integer detail_id){
        return repository.getById(detail_id);
    }

    @Override
    public ResourceDetails saveDetails(ResourceDetails details){ return repository.save(details); }

    @Override
    public ResourceDetails updateValue(Integer detail_id,String detail_value){
        ResourceDetails details = repository.findById(detail_id).orElse(null);
        if(details==null){
            System.out.println("ID is not valid");
            return null;
        }
        details.setDetail_value(detail_value);
        return repository.save(details);

    }



}
