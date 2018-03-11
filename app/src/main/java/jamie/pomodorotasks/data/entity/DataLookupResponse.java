package jamie.pomodorotasks.data.entity;

import jamie.pomodorotasks.WorkMode.domain.repository.Response;

public class DataLookupResponse implements Response {
    private boolean success;

    public DataLookupResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
