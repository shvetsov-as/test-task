//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.06.20 at 12:00:55 AM MSK 
//


package com.example.testtask.webservice.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userShort" type="{http://localhost:8080/testtask/example/com}userShort"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userList", propOrder = {
    "userShort"
})
public class UserList {

    @XmlElement(required = true)
    protected UserShort userShort;

    /**
     * Gets the value of the userShort property.
     * 
     * @return
     *     possible object is
     *     {@link UserShort }
     *     
     */
    public UserShort getUserShort() {
        return userShort;
    }

    /**
     * Sets the value of the userShort property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserShort }
     *     
     */
    public void setUserShort(UserShort value) {
        this.userShort = value;
    }

}
