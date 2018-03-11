package jamie.pomodorotasks.WorkMode.presentation.View;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jamie.pomodorotasks.R;
import jamie.pomodorotasks.WorkMode.presentation.Presenter.WorkModePresenter;
import jamie.pomodorotasks.WorkMode.presentation.WorkModeContract;

public class WorkModeFragment extends Fragment implements WorkModeContract.View {
    @BindView(R.id.btn_one)
    Button btn1;
    @BindView(R.id.btn_two)
    Button btn2;
    @BindView(R.id.task_name)
    EditText taskName;
    @BindView(R.id.task_timer)
    TextView timer;

    WorkModePresenter presenter;

    public WorkModeFragment() {}

    public static WorkModeFragment newInstance() {
        return new WorkModeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new WorkModePresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_work_mode, container, false);
        ButterKnife.bind(this, view);
        presenter.setView(this);
        return view;
    }

    @OnClick(R.id.btn_one)
    public void btn1Clicked() {

    }

    @OnClick(R.id.btn_two)
    public void btn2Clicked() {
        presenter.btn2Clicked();
    }

    @Override
    public void showNoTextEnteredError() {
        taskName.setError(getString(R.string.no_task_entered));
    }

    @Override
    public void enableTaskEntry() {
        taskName.setEnabled(true);
    }

    @Override
    public void disableTaskEntry() {
        taskName.setEnabled(false);
    }

    @Override
    public void enablePauseButton() {
        btn1.setEnabled(true);
    }

    @Override
    public void disablePauseButton() {
        btn1.setEnabled(false);
    }

    @Override
    public void setTime(String newTime) {
        timer.setText(newTime);
    }

    @Override
    public String getTaskName() {
        return taskName.getText().toString();
    }

    @Override
    public void notifyTaskFinished() {
        Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(500);
    }

    @Override
    public void showButtonFinish() {
        btn2.setText(R.string.enter_task_finish);
    }

    @Override
    public void showButtonStart() {
        btn2.setText(R.string.enter_task_start);
    }
}
