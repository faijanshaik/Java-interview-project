package main.java.com.faijanshaikh.customAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class CustomAnnotationMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        AdminOnly[] admins;
        Class<?> object = Class.forName("main.java.com.faijanshaikh.customAnnotation.UserService");
        Method method = object.getDeclaredMethod("deleteUser");
        if (method.isAnnotationPresent(Admins.class)) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }//output : @main.java.com.faijanshaikh.customAnnotation.Admins({@main.java.com.faijanshaikh.customAnnotation.AdminOnly(admin="admin"), @main.java.com.faijanshaikh.customAnnotation.AdminOnly(admin="admin1"), @main.java.com.faijanshaikh.customAnnotation.AdminOnly(admin="admin2")})


            admins = method.getAnnotationsByType(AdminOnly.class);
            for (AdminOnly admin : admins) {
                System.out.println(admin.admin());
            } /* output :admin
                         admin1
                         admin2
               */
        }
        admins = null;
        if (method.isAnnotationPresent(Admins.class)) {
            admins = method.getAnnotationsByType(AdminOnly.class);
            for (AdminOnly admin : admins) {
                if (!admin.admin().equals("admin")) {
                    boolean isAdmin = false;
                    System.out.println("Acess denied! you are not admin");
                    return;
                }
            }
        }


        method.invoke(object.getDeclaredConstructor().newInstance());
    }
}
