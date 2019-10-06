package dao.api;

import model.Candy;

import java.util.List;

public interface IWritable {

    void write(List<Candy> candies);
}
