package Service;

import ResourceManager.model.ProjectColumns;

import java.util.List;

public interface ProjectColumnService {
    public ProjectColumns addColumn(ProjectColumns projectColumn);
    public void deleteColumn(Integer column_id);
    public ProjectColumns getColumn(Integer column_id);
    public List<ProjectColumns> getAllColumns();
}
