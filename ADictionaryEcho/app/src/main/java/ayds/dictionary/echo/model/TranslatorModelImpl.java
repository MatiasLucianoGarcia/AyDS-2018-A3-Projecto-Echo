package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.business.Repository;

class TranslatorModelImpl implements TranslatorModel {

    private TranslatorModelListener listener;
    private Repository repository;

    TranslatorModelImpl(Repository repository) {
        this.repository = repository;
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
        repository.setExceptionListener(translatorModelExceptionListener);
    }

}