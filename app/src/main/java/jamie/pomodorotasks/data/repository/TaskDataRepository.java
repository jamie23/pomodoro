package jamie.pomodorotasks.data.repository;

import io.reactivex.Observable;
import jamie.pomodorotasks.WorkMode.domain.Task;
import jamie.pomodorotasks.WorkMode.domain.repository.Response;
import jamie.pomodorotasks.WorkMode.domain.repository.TaskRepository;
import jamie.pomodorotasks.data.repository.datasource.TaskDataStore;
import jamie.pomodorotasks.data.repository.datasource.TaskDataStoreFactory;

public class TaskDataRepository implements TaskRepository {
    private final TaskDataStoreFactory dataStoreFactory;

    public TaskDataRepository(TaskDataStoreFactory taskDataStoreFactory) {
        this.dataStoreFactory = taskDataStoreFactory;
    }

    @Override
    public Observable<Response> setTask(Task task) {
        final TaskDataStore dataStore = dataStoreFactory.getDataStore();
        return dataStore.saveNewTask(task);
    }
}
