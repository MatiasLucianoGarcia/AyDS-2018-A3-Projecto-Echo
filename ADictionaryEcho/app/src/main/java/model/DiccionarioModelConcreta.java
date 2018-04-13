package model;

import android.text.Html;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Response;

public class DiccionarioModelConcreta implements DiccionarioModel {

    private String translatedWord;
    private TraductorModelListener listener;

    public DiccionarioModelConcreta() {}

    public void translateWord(String term) {
        String text = DataBase.getMeaning(term);

        if (text != null) { // exists in db

            text = "[*]" + text;
        }
        else {
            Response<String> callResponse;
            try {
                callResponse = yandex.getTerm(term).execute();

                Log.e("**","JSON " + callResponse.body());


                if (callResponse.body() == null) {
                    text = "No Results";
                } else {


                    Gson gson = new Gson();
                    JsonObject jobj = gson.fromJson(callResponse.body(), JsonObject.class);

                    // nouns
                    String extract = jobj.get("text").getAsString();

                    text = extract.replace("\\n", "<br>");
                    text = textToHtml(text, term);

                    // save to DB  <o/
                    DataBase.saveTerm(textField1.getText().toString(), text);
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        final String textToSet = text;
        textPane1.post(new Runnable() {
            public void run() {
                textPane1.setText(Html.fromHtml(textToSet));
            }
        });
    }
    
    public String getWord(){
        return translatedWord;
    }

    @Override
    public void setListener(TraductorModelListener listener) {
        this.listener = listener;
    }
}
