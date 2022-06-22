package com.example.testtask.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/soapUserWS/*");
    }

    @Bean
    public XsdSchema webserviceSchema(){
        return new SimpleXsdSchema(new ClassPathResource("webservice.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema webserviceSchema){

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(webserviceSchema);
        definition.setLocationUri("/soapUserWS");
        definition.setPortTypeName("WebServiceUserEndpointPort");
        definition.setTargetNamespace("http://localhost:8080/testtask/example/com");

        return definition;
    }
}
