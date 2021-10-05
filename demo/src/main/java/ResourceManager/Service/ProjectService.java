package ResourceManager.Service;



import ResourceManager.entity.Project;
import ResourceManager.entity.User;

import java.util.List;

public interface ProjectService {
    public Project findById(Integer id);
    public List<Project> findByUser(User user);

    List<Project> findAll();
    public void delete(Integer id);

    public Project create(Project project,User user);
    public Project update(Project project);
}
