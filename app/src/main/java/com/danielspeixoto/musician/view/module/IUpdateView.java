package com.danielspeixoto.musician.view.module;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public interface IUpdateView<T> {

    void onObjectUpdated();

    void onErrorUpdating(String message);

}
