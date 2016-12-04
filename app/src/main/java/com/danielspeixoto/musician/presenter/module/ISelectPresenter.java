package com.danielspeixoto.musician.presenter.module;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public interface ISelectPresenter<T> {

    void select(long id);

    void onReceived(T t);

}
