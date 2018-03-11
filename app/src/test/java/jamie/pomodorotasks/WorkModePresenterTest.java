package jamie.pomodorotasks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import jamie.pomodorotasks.WorkMode.presentation.Presenter.WorkModePresenter;
import jamie.pomodorotasks.WorkMode.presentation.View.WorkModeFragment;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorkModePresenterTest {
    private WorkModePresenter presenter;

    @Mock
    private WorkModeFragment view;

    @Before
    public void setUp() {
        presenter = new WorkModePresenter();
        presenter.setView(view);
    }

    @Test
    public void noTaskNameClickSubmitShowsUserError() {
        when(view.getTaskName()).thenReturn("");
        presenter.btn2Clicked();
        verify(view).showNoTextEnteredError();
    }
}
