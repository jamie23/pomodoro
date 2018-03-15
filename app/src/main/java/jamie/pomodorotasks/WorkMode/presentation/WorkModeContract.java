package jamie.pomodorotasks.WorkMode.presentation;

public interface WorkModeContract {
    interface View {
        void showNoTextEnteredError();
        void enableTaskEntry();
        void disableTaskEntry();
        void enablePauseButton();
        void disablePauseButton();
        void showButtonFinish();
        void showButtonStart();
        void notifyTaskFinished();
        void setTime(String newTime);
        String getTaskName();
    }

    interface Presenter {
        void initialise();
        void setView(WorkModeContract.View view);
        void btn1Clicked();
        void btn2Clicked();
    }
}
