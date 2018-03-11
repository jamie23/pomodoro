package jamie.pomodorotasks.WorkMode.domain.interactor;

import io.reactivex.Observable;
import jamie.pomodorotasks.WorkMode.domain.Task;
import jamie.pomodorotasks.WorkMode.domain.executor.PostExecutionThread;
import jamie.pomodorotasks.WorkMode.domain.executor.ThreadExecutor;
import jamie.pomodorotasks.data.repository.datasource.TaskDataStore;

public class SaveTask extends UseCase<Void, Task> {
    private final TaskDataStore taskDataStore;

    public SaveTask(TaskDataStore taskDataStore,
                    ThreadExecutor threadExecutor,
                    PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.taskDataStore = taskDataStore;
    }

    @Override
    Observable<Void> buildUseCaseObservable(Task task) {
        return taskDataStore.saveNewTask(task);
    }
}
