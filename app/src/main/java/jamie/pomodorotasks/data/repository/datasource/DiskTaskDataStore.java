package jamie.pomodorotasks.data.repository.datasource;

import java.util.ArrayList;

import io.reactivex.Observable;
import jamie.pomodorotasks.WorkMode.domain.Task;
import jamie.pomodorotasks.WorkMode.domain.repository.Response;
import jamie.pomodorotasks.data.entity.DataLookupResponse;

public class DiskTaskDataStore implements TaskDataStore {
    ArrayList<Task> taskDataStore;

    @Override
    public Observable<Response> saveNewTask(Task task) {
        taskDataStore.add(task);

        //For a simple simulated db, always return true, for networking, may be failures
        return Observable.just(new DataLookupResponse(true));
    }
}
