module restapi {
    requires datacenter;
    requires dataprovider;

    requires io.swagger.v3.oas.annotations;
    requires spring.beans;
    requires spring.web;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires lombok;
}