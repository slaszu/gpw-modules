module admin {
    requires datacenter;
    requires dataprovider;
    requires twitterkotlin;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.security.oauth2.core;
    requires spring.security.oauth2.client;
    requires spring.security.core;
    requires lombok;
    requires org.slf4j;
    requires spring.web;
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires spring.webmvc;
    requires spring.security.config;
    requires spring.security.web;
    requires org.apache.tomcat.embed.core;
}