package com.danielspeixoto.musician.presenter.module;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public interface IDeletePresenter<T> {

    void delete(long id);

    void onDeleted();

}
