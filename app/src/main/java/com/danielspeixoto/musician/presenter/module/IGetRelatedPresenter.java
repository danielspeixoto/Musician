package com.danielspeixoto.musician.presenter.module;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public interface IGetRelatedPresenter<T> {

    void getRelated(int parentId);

    void onReceivingRelated(T t);

}
