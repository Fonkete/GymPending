package fonket.gympending.data;

import java.util.List;

import fonket.gympending.models.Exercise;

/**
 * Created by felip on 28-05-2017.
 */

public class Queries {

    public List<Exercise> exercises() {
        return Exercise.listAll(Exercise.class);
}}
