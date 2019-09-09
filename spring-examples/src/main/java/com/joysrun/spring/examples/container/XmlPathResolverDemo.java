package com.joysrun.spring.examples.container;

import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.Properties;

/**
 * xml path 解析
 *
 * author: sin
 * time: 2019/9/8 4:42 下午
 */
public class XmlPathResolverDemo {

    public static void main(String[] args) {
        PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}");
        String sourceValue = "resource/${os.version}/application.yml";
        String resolverValue = helper.replacePlaceholders(sourceValue, new PropertyPlaceholderHelper.PlaceholderResolver() {
            @Override
            public String resolvePlaceholder(String placeholderName) {
                // placeholderName 是 helper 解析出来的 key

                // 创建一个属性
                Properties properties = new Properties();
                properties.setProperty("os.version", "1.0.1");

                // 创建 propertySource
                PropertiesPropertySource propertySource = new PropertiesPropertySource("properties", properties);

                // 创建 PropertySources
                MutablePropertySources mutablePropertySources = new MutablePropertySources();
                mutablePropertySources.addLast(propertySource);

                // 创建 解析器
                PropertySourcesPropertyResolver resolver = new PropertySourcesPropertyResolver(mutablePropertySources);

                // 通过解析器，获取值
                return resolver.getProperty(placeholderName);
            }
        });

        System.err.println("解析值: " + resolverValue);
        System.err.println("解析源值: " + sourceValue);
    }

}
