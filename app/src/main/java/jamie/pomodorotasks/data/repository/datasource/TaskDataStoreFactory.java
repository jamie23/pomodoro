package jamie.pomodorotasks.data.repository.datasource;

/**
 * When multiple data sources, this will decide which to use
 */
public class TaskDataStoreFactory {
    public TaskDataStore getDataStore() {
        //Later if there is a online db, we can decide to return db or rest client
        return new DiskTaskDataStore();
    }
}
