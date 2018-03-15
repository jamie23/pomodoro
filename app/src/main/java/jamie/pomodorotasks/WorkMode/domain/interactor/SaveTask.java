package jamie.pomodorotasks.WorkMode.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import jamie.pomodorotasks.WorkMode.domain.Response;
import jamie.pomodorotasks.WorkMode.domain.Task;
import jamie.pomodorotasks.WorkMode.domain.executor.PostExecutionThread;
import jamie.pomodorotasks.WorkMode.domain.executor.ThreadExecutor;
import jamie.pomodorotasks.WorkMode.domain.repository.TaskRepository;
import jamie.pomodorotasks.data.repository.datasource.TaskDataStore;

public class SaveTask extends UseCase<Response, Task> {
    private final TaskRepository taskRepository;

    public SaveTask(TaskRepository repository,
                    Scheduler threadExecutor,
                    PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.taskRepository = repository;
    }

    @Override
    public Observable<Response> buildUseCaseObservable(Task task) {
        return taskRepository.saveTask(task);
    }
}
