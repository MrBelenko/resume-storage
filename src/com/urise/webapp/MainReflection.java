package com.urise.webapp;

import com.urise.webapp.model.Resume;
import java.lang.reflect.*;


/**
 * Created by Pavlo on 18/06/2017.
 */
public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("222");
        System.out.println(r.getClass());

        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.get(r);
        field.set(r, "new_uuid");
        //TODO : invoke r.toString via reflection
        System.out.println(r);

        Method method = r.getClass().getMethod("getUuid");
        Object res = method.invoke(r);
        System.out.println(res);

    }
}
