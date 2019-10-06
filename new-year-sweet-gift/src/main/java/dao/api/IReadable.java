package dao.api;

import model.Candy;

import java.util.List;

public interface IReadable {

    List<Candy> read();
}
