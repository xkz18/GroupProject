package ResourceManager.Service.Impl;

import ResourceManager.entity.Resource;
import ResourceManager.entity.User;
import ResourceManager.repository.ResourceDetailsRepository;
import ResourceManager.entity.ResourceDetails;
import ResourceManager.Service.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Example.*;


@Service
public class ResourceDetailsServiceImpl implements ResourceDetailsService {
    @Autowired
    ResourceDetailsRepository repository;


    @Override
    public List<ResourceDetails> getAllDetails(){
        return repository.findAll();
    }

    @Override
    public ResourceDetails createDetails(ResourceDetails resourceDetails){
        return repository.save(resourceDetails);
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



}
