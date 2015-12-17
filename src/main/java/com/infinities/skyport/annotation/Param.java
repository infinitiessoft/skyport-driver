package com.infinities.skyport.annotation;

public @interface Param {

	String name();

	String description();

	String type() default "String";

	String[] enumeration() default {};

	String[] constraints() default {};

	boolean required() default false;

}
