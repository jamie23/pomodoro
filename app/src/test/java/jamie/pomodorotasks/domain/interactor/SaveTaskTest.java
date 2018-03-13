package jamie.pomodorotasks.domain.interactor;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import jamie.pomodorotasks.WorkMode.domain.Task;
import jamie.pomodorotasks.WorkMode.domain.executor.PostExecutionThread;
import jamie.pomodorotasks.WorkMode.domain.executor.ThreadExecutor;
import jamie.pomodorotasks.WorkMode.domain.interactor.SaveTask;
import jamie.pomodorotasks.WorkMode.domain.repository.TaskRepository;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SaveTaskTest {
    private SaveTask saveTask;

    @Mock
    private ThreadExecutor mockThreadExecutor;
    @Mock
    private PostExecutionThread mockPostExecutionThread;
    @Mock
    TaskRepository mockRepository;

    @Before
    public void setUp() {
        saveTask = new SaveTask(mockRepository, mockThreadExecutor, mockPostExecutionThread);
    }

    @Test
    public void testUseCaseSavesTaskCorrectly() {
        Task task = new Task("Jamie", new DateTime(1,1,1,1,1));
        saveTask.buildUseCaseObservable(task);

        verify(mockRepository).saveTask(task);
    }
}
