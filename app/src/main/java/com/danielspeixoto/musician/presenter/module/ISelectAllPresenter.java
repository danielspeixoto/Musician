package com.danielspeixoto.musician.presenter.module;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface ISelectAllPresenter<T> {

    void selectAll();

    void onReceiving(T t);

}
