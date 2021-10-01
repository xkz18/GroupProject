package ResourceManager.Service;

import ResourceManager.model.Project;
import ResourceManager.model.User;

import java.util.List;

public interface ProjectService {
    public Project findById(Integer id);
    public List<Project> findByUser(User user);

    List<Project> findAll();

    public Project save(Project project);

    public Project create(Project project);
    public Project update(Project project);
}
