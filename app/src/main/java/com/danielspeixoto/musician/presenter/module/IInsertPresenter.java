package com.danielspeixoto.musician.presenter.module;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface IInsertPresenter<T> {

    void insert(T t);

    void onInserted(long id);

}
