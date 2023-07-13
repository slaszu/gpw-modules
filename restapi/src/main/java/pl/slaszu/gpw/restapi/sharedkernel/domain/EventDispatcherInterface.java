package pl.slaszu.gpw.restapi.sharedkernel.domain;

public interface EventDispatcherInterface {
    public void dispatch(Object event);
}
