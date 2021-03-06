package jamie.pomodorotasks.WorkMode.domain.repository;

import io.reactivex.Observable;
import jamie.pomodorotasks.WorkMode.domain.Response;
import jamie.pomodorotasks.WorkMode.domain.Task;

public interface TaskRepository {
    Observable<Response> saveTask(Task task);
}
