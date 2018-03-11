package jamie.pomodorotasks.WorkMode.presentation.Presenter;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import jamie.pomodorotasks.WorkMode.presentation.WorkModeContract;

public class WorkModePresenter implements WorkModeContract.Presenter {
    WorkModeContract.View view;
    private boolean isStarted = false;

    public void setView(WorkModeContract.View view) {
        this.view = view;
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
