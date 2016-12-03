package com.danielspeixoto.musician.presenter.module;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public interface IUpdatePresenter<T> {

    void update(T t);

    void onUpdated();
}
