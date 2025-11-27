package main.java.com.faijanshaikh.customAnnotation;

import java.lang.annotation.*;

/**
 * @author Faijan Shaik
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Admins.class)
public @interface AdminOnly {
    /*
    we apply the custom annotaion to attach some extra information as meta data to the class, method, variables and constructors
    used to trigger some processing, such as logging, security, validation, mapping, etc.

       To create custom annotations
       1. @interface is required, it is used to declare an annotation type , introduced at java 5 version
       2.@Target it specifies where the annotation can be applied
        - ElementType.METHOD means this annotation can be applied only to methods.
       3.@Retention it specifies how long annotation should be retained
        - RetentionPolicy.RUNTIME means it is available at runtime via reflection
     */
    String admin();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Admins {
    AdminOnly[] value();
}