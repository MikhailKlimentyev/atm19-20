package dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.api.IReadable;
import model.Candy;
import model.Constants;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReaderFromJSON implements IReadable {

    @Override
    public List<Candy> read() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(Constants.PATH_TO_INPUT_JSON),
                    new TypeReference<List<? extends Candy>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
