package ayds.dictionary.echo.model;

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
                String translatedWord;
                translatedWord = repository.translateWord(wordToTranslate);
                listener.didUpdateWord(translatedWord);
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