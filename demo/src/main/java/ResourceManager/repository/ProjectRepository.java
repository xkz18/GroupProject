package ResourceManager.repository;


import ResourceManager.entity.Project;
import ResourceManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public List<Project> findByUser(User user);
}
