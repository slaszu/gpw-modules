module datacenter {
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.context;
    requires jakarta.persistence;
    requires lombok;
    requires org.slf4j;
    requires com.fasterxml.jackson.annotation;
    requires spring.beans;
    requires spring.tx;
    requires spring.boot.autoconfigure;

    exports pl.slaszu.gpw.datacenter.application.ListStocks;
    exports pl.slaszu.gpw.datacenter.application.ListStockPrice;
    exports pl.slaszu.gpw.datacenter.application.CreateStock;
}