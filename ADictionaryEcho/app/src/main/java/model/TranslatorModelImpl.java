package model;

import android.os.Looper;

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
                String translatedWord = null;
                try {
                    translatedWord = repository.translateWord(wordToTranslate);
                } catch (TranslatingWordException e) {
                    translatorModelExceptionListener.sendExceptionMessage(e.getMessage());
                }
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
        this.translatorModelExceptionListener = translatorModelExceptionListener;
    }

}