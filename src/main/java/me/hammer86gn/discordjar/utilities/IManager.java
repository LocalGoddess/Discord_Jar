package me.hammer86gn.discordjar.utilities;

import java.util.List;

public interface IManager<Type> {

    void register(Type type);

    List<Type> getAll();

}
