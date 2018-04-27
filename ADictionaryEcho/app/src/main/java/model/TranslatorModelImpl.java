package model;

import model.exceptions.TranslatingWordException;

class TranslatorModelImpl implements TranslatorModel {

    private TranslatorModelListener listener;
    private TranslatorModelExceptionListener translatorModelExceptionListener;
    private Repository repository;

    TranslatorModelImpl(Repository repository) {
        this.repository = repository;
    }

    public void translateWord(final String wordToTranslate) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String translatedWord;
                try {
                    translatedWord = repository.translateWord(wordToTranslate);
                    listener.didUpdateWord(translatedWord);
                } catch (TranslatingWordException e) {
                    translatorModelExceptionListener.sendExceptionMessage(e.getMessage());
                }
            }
        }).start();
    }

    @Override
    public void setListener(TranslatorModelListener listener) {
        this.listener = listener;
    }

    @Override
    public void setExceptionListener(TranslatorModelExceptionListener translatorModelExceptionListener) {
        this.translatorModelExceptionListener = translatorModelExceptionListener;
    }

}