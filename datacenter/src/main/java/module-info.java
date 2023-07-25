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

    exports pl.slaszu.gpw.datacenter.stock.application.ListStocks;
    exports pl.slaszu.gpw.datacenter.stock.application.ListStockPrice;
}