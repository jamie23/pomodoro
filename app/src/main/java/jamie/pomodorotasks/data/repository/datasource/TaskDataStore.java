package jamie.pomodorotasks.data.repository.datasource;

import io.reactivex.Observable;
import jamie.pomodorotasks.WorkMode.domain.Task;
import jamie.pomodorotasks.WorkMode.domain.repository.Response;

public interface TaskDataStore {
    Observable<Response> saveNewTask(Task task);
}
