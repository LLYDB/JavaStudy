package study.java.jdks.version1_6.pluggable_annotation;

import javax.annotation.PostConstruct;

public class Testing{    
    @ToBeTested(group="A")
    public void m1(){
    }
    @ToBeTested(group="B",owner="QQ")
    public void m2(){
    }    
    @PostConstruct  //Common Annotation�����һ��Annotation
    public void m3(){
    }    
}

