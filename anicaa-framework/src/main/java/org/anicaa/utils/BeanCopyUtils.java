package org.anicaa.utils;


import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {

    private BeanCopyUtils(){

    }

    public static <S, T> T copyBean(S source, Class<T> targetClass){
        T target = null;
        try {
            target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return target;
    }

    public static <S, T> List<T> copyBeanList(List<S> sourceList, Class<T> targetClass){
        return sourceList.stream()
                .map(o -> copyBean(o, targetClass))
                .collect(Collectors.toList());
    }
}
