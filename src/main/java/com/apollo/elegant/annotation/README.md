# 注解
## 注解分类
注解分为标准注解和元注解，下面会分别介绍它们。 1.标准注解 标准注解有以下4种。 •@Override：对覆盖超类中的方法进行标记，如果被标记的方法并没有实际覆盖超类中的方法，则编 译器会发出错误警告。 •@Deprecated：对不鼓励使用或者已过时的方法添加注解，当编程人员使用这些方法时，将会在编译 时显示提示信息。 •@SuppressWarnings：选择性地取消特定代码段中的警告。 •@SafeVarargs：JDK 7新增，用来声明使用了可变长度参数的方法，其在与泛型类一起使用时不会出现 类型安全问题。 2.元注解 除了标准注解，还有元注解，它用来注解其他注解，从而创建新的注解。元注解有以下几种。 •@Targe：注解所修饰的对象范围。 •@Inherited：表示注解可以被继承。 •@Documented：表示这个注解应该被JavaDoc工具记录。 •@Retention：用来声明注解的保留策略。 •@Repeatable：JDK 8 新增，允许一个注解在同一声明类型（类、属性或方法）上多次使用。 其中@Targe注解取值是一个ElementType类型的数组，其中有以下几种取值，对应不同的对象范围。 • ElementType.TYPE：能修饰类、接口或枚举类型。 • ElementType.FIELD：能修饰成员变量。 • ElementType.METHOD：能修饰方法。 • ElementType.PARAMETER：能修饰参数。 • ElementType.CONSTRUCTOR：能修饰构造方法。 • ElementType.LOCAL_VARIABLE：能修饰局部变量。 • ElementType.ANNOTATION_TYPE：能修饰注解。 • ElementType.PACKAGE：能修饰包。 • ElementType.TYPE_PARAMETER：类型参数声明。 • ElementType.TYPE_USE：使用类型。 其中@Retention注解有3种类型，分别表示不同级别的保留策略。 • RetentionPolicy.SOURCE：源码级注解。注解信息只会保留在.java源码中，源码在编译后，注解信息 被丢弃，不会保留在.class中。 • RetentionPolicy.CLASS：编译时注解。注解信息会保留在.java 源码以及.class 中。当运行Java程序时， JVM会丢弃该注解信息，不会保留在JVM中。 • RetentionPolicy.RUNTIME：运行时注解。当运行Java程序时，JVM也会保留该注解信息，可以通过反
1.标准注解 
标准注解有以下4种。
 •@Override：对覆盖超类中的方法进行标记，如果被标记的方法并没有实际覆盖超类中的方法，则编 译器会发出错误警告。
 •@Deprecated：对不鼓励使用或者已过时的方法添加注解，当编程人员使用这些方法时，将会在编译 时显示提示信息。 
 •@SuppressWarnings：选择性地取消特定代码段中的警告。 
 •@SafeVarargs：JDK 7新增，用来声明使用了可变长度参数的方法，其在与泛型类一起使用时不会出现 类型安全问题。 
2.元注解 
除了标准注解，还有元注解，它用来注解其他注解，从而创建新的注解。元注解有以下几种。 
 •@Targe：注解所修饰的对象范围。 
 •@Inherited：表示注解可以被继承。 
 •@Documented：表示这个注解应该被JavaDoc工具记录。 
 •@Retention：用来声明注解的保留策略。 
 •@Repeatable：JDK 8 新增，允许一个注解在同一声明类型（类、属性或方法）上多次使用。 
 其中@Targe注解取值是一个ElementType类型的数组，其中有以下几种取值，对应不同的对象范围。 
 • ElementType.TYPE：能修饰类、接口或枚举类型。 
 • ElementType.FIELD：能修饰成员变量。 
 • ElementType.METHOD：能修饰方法。 
 • ElementType.PARAMETER：能修饰参数。 
 • ElementType.CONSTRUCTOR：能修饰构造方法。 
 • ElementType.LOCAL_VARIABLE：能修饰局部变量。 
 • ElementType.ANNOTATION_TYPE：能修饰注解。 
 • ElementType.PACKAGE：能修饰包。 
 • ElementType.TYPE_PARAMETER：类型参数声明。 
 • ElementType.TYPE_USE：使用类型。
 其中@Retention注解有3种类型，分别表示不同级别的保留策略。 
 • RetentionPolicy.SOURCE：源码级注解。注解信息只会保留在.java源码中，源码在编译后，注解信息 被丢弃，不会保留在.class中。 
 • RetentionPolicy.CLASS：编译时注解。注解信息会保留在.java 源码以及.class 中。当运行Java程序时， JVM会丢弃该注解信息，不会保留在JVM中。 
 • RetentionPolicy.RUNTIME：运行时注解。当运行Java程序时，JVM也会保留该注解信息，可以通过反射获取该注解信息。