package jamie.pomodorotasks.data.repository.datasource;

import java.util.ArrayList;

import io.reactivex.Observable;
import jamie.pomodorotasks.WorkMode.domain.Response;
import jamie.pomodorotasks.WorkMode.domain.Task;

public class DiskTaskDataStore implements TaskDataStore {
    private ArrayList<Task> taskDataStore;

    @Override
    public Observable<Response> saveNewTask(Task task) {
        taskDataStore.add(task);

        //For a simple simulated db, always return true, for networking, may be failures
        return Observable.just(new Response(true));
    }
}
