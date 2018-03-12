package jamie.pomodorotasks.data.repository.datasource;

import io.reactivex.Observable;
import jamie.pomodorotasks.WorkMode.domain.Response;
import jamie.pomodorotasks.WorkMode.domain.Task;

public interface TaskDataStore {
    Observable<Response> saveNewTask(Task task);
}
