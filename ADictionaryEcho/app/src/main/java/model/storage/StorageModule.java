package model.storage;

import view.ViewModule;

public class StorageModule {

    private static final StorageModule ourInstance = new StorageModule();

    public static StorageModule getInstance() {
        return ourInstance;
    }

    private StorageModule() {
        databaseInitializer();
    }

    private void databaseInitializer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DataBase.getInstance().createNewDatabase(ViewModule.getInstance().getApplicationContext());
            }
        }).start();
    }

    public DataBase getDataBase(){
        return DataBase.getInstance();
    }

}
