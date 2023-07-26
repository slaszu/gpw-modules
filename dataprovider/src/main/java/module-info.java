module dataprovider {
    requires spring.beans;
    requires spring.context;
    requires org.apache.poi.poi;
    requires lombok;
    requires org.slf4j;
    requires org.jsoup;
    requires org.apache.commons.io;
    requires jollyday.core;

    exports pl.slaszu.gpw.dataprovider.application.FetchData;
    exports pl.slaszu.gpw.dataprovider.domain.dto;
}