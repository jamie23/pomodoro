package jamie.pomodorotasks.WorkMode.presentation;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import jamie.pomodorotasks.WorkMode.domain.executor.PostExecutionThread;

public class UIThread implements PostExecutionThread {
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
