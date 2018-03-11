package jamie.pomodorotasks.domain;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import jamie.pomodorotasks.WorkMode.domain.Task;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskTest {
    private Task task;

    @Before
    public void setUp(){
        task = new Task("Jamie", new DateTime(1,1,1,1,1));
    }

    @Test
    public void testTaskConstructorCorrect(){
        assertThat(task.getName()).isEqualTo("Jamie");
        assertThat(task.getStartTime()).isEqualTo(new DateTime(1,1,1,1,1));
    }
}
