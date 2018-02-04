package io.qhacks.var_mapper;

import java.util.List;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Prediction;

/**
 * Created by james on 2/3/2018.
 */

public class Clarifai_Process {
    private final String API_KEY = "";
    private ClarifaiClient client;

    public Clarifai_Process(){
        client = new ClarifaiBuilder("")
                //.client(new OkHttpClient()) // OPTIONAL. Allows customization of OkHttp by the user
                .buildSync();
    }

    public ClarifaiOutput<Prediction> getCategories(byte[] imageBytes){
        List<ClarifaiOutput<Prediction>> predictionResults =
            client.predict("QHacks Sponsor logos")
                    .withInputs(
                            ClarifaiInput.forImage(imageBytes))
                    .executeSync()
                    .get();

        return predictionResults.get(0);
    }
}
