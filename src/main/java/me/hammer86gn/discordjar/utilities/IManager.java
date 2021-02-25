package me.hammer86gn.discordjar.utilities;

import java.util.List;

public interface IManager<Object> {

    void register(Object type);

    List<Object> getAll();

}
