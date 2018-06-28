package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.business.Repository;

class TranslatorModelImpl implements TranslatorModel {

    private TranslatorModelListener listener;
    private Repository repository;
    private ExceptionHandler exceptionHandler;

    TranslatorModelImpl(Repository repository,ExceptionHandler exceptionHandler) {
        this.repository = repository;
        this.exceptionHandler = exceptionHandler;
        this.repository.setExceptionHandler(exceptionHandler);
    }

    public void translateWord(final String wordToTranslate) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                listener.didUpdateWord(repository.translateWord(wordToTranslate));
            }
        }).start();
    }

    @Override
    public void setListener(TranslatorModelListener listener) {
        this.listener = listener;
    }

    @Override
    public void setExceptionListener(TranslatorModelExceptionListener translatorModelExceptionListener) {
        exceptionHandler.setListener(translatorModelExceptionListener);
    }

}