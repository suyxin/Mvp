package com.suyxin.mvp.componet.base;

/**
 * @author Created by suyxin on 2018/3/7 12:11.
 */


public class PresenterFactoryImpl<V extends BaseMvpView,P extends BasePresenter<V>> implements PresenterFactory<V,P> {


    @Override
    public P create(V iView) {

        PresenterClass annotation = iView.getClass().getAnnotation(PresenterClass.class);

        if (annotation != null) {
            Class<P> presentClass = (Class<P>) annotation.value();
            System.out.println("找到  "+presentClass.getCanonicalName());
            try {
                return presentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(iView.getClass().getName()+" 找不到有Presenter注解");
        return null;
    }
}
