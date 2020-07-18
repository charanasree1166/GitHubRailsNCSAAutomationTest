
package com.ncsa.automation.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "Ruby",
    "HTML",
    "JavaScript",
    "CSS",
    "CoffeeScript",
    "Shell",
    "Yacc"
})
public class Language {

    @JsonProperty("Ruby")
    private Integer ruby;
    @JsonProperty("HTML")
    private Integer hTML;
    @JsonProperty("JavaScript")
    private Integer javaScript;
    @JsonProperty("CSS")
    private Integer cSS;
    @JsonProperty("CoffeeScript")
    private Integer coffeeScript;
    @JsonProperty("Shell")
    private Integer shell;
    @JsonProperty("Yacc")
    private Integer yacc;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Ruby")
    public Integer getRuby() {
        return ruby;
    }

    @JsonProperty("Ruby")
    public void setRuby(Integer ruby) {
        this.ruby = ruby;
    }

    public Language withRuby(Integer ruby) {
        this.ruby = ruby;
        return this;
    }

    @JsonProperty("HTML")
    public Integer getHTML() {
        return hTML;
    }

    @JsonProperty("HTML")
    public void setHTML(Integer hTML) {
        this.hTML = hTML;
    }

    public Language withHTML(Integer hTML) {
        this.hTML = hTML;
        return this;
    }

    @JsonProperty("JavaScript")
    public Integer getJavaScript() {
        return javaScript;
    }

    @JsonProperty("JavaScript")
    public void setJavaScript(Integer javaScript) {
        this.javaScript = javaScript;
    }

    public Language withJavaScript(Integer javaScript) {
        this.javaScript = javaScript;
        return this;
    }

    @JsonProperty("CSS")
    public Integer getCSS() {
        return cSS;
    }

    @JsonProperty("CSS")
    public void setCSS(Integer cSS) {
        this.cSS = cSS;
    }

    public Language withCSS(Integer cSS) {
        this.cSS = cSS;
        return this;
    }

    @JsonProperty("CoffeeScript")
    public Integer getCoffeeScript() {
        return coffeeScript;
    }

    @JsonProperty("CoffeeScript")
    public void setCoffeeScript(Integer coffeeScript) {
        this.coffeeScript = coffeeScript;
    }

    public Language withCoffeeScript(Integer coffeeScript) {
        this.coffeeScript = coffeeScript;
        return this;
    }

    @JsonProperty("Shell")
    public Integer getShell() {
        return shell;
    }

    @JsonProperty("Shell")
    public void setShell(Integer shell) {
        this.shell = shell;
    }

    public Language withShell(Integer shell) {
        this.shell = shell;
        return this;
    }

    @JsonProperty("Yacc")
    public Integer getYacc() {
        return yacc;
    }

    @JsonProperty("Yacc")
    public void setYacc(Integer yacc) {
        this.yacc = yacc;
    }

    public Language withYacc(Integer yacc) {
        this.yacc = yacc;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
