package jamie.pomodorotasks.WorkMode.presentation.Presenter;

import android.util.Log;

import org.joda.time.DateTime;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import jamie.pomodorotasks.WorkMode.domain.Task;
import jamie.pomodorotasks.WorkMode.domain.interactor.SaveTask;
import jamie.pomodorotasks.WorkMode.presentation.UIThread;
import jamie.pomodorotasks.WorkMode.presentation.WorkModeContract;
import jamie.pomodorotasks.data.repository.TaskDataRepository;
import jamie.pomodorotasks.data.repository.datasource.TaskDataStoreFactory;

public class WorkModePresenter implements WorkModeContract.Presenter {
    WorkModeContract.View view;
    private boolean isStarted = false;
    private SaveTask saveTask;

    public void setView(WorkModeContract.View view) {
        this.view = view;
    }

    public void initialise() {
        saveTask = new SaveTask(new TaskDataRepository(new TaskDataStoreFactory()),
                                Schedulers.io(),
                                new UIThread());
    }
    @Override
    public void btn1Clicked() {

    }

    @Override
    public void btn2Clicked() {
        if (view.getTaskName() == null || view.getTaskName().isEmpty()) {
            view.showNoTextEnteredError();
            return;
        }

        if (!isStarted) {
            initialiseInProgressState();
        } else {
            initaliseStartState();
        }
    }

    private void startTimer() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(10)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return aLong+1;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                       view.setTime(aLong.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Timer", "Timer threw an error");
                    }

                    @Override
                    public void onComplete() {
                        view.notifyTaskFinished();
                        saveTask.buildUseCaseObservable(new Task(view.getTaskName(), new DateTime()));
                        initaliseStartState();
                    }
                });
    }

    private void initaliseStartState() {
        view.showButtonStart();
        view.disablePauseButton();
        view.enableTaskEntry();
        view.setTime(Long.toString(0));
        isStarted = false;
    }

    private void initialiseInProgressState() {
        view.enablePauseButton();
        view.showButtonFinish();
        view.disableTaskEntry();
        isStarted = true;
        startTimer();
    }
}
