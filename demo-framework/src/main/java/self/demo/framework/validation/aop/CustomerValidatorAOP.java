package self.demo.framework.validation.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestBody;

import self.demo.framework.validation.ParamValid;

/**
 * @author liufei45 RequestMapping 传入参数验证
 */
@Aspect
@Component
public class CustomerValidatorAOP {
	@Autowired
	private Validator validator;

	@Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void requestMappingInvocation() {
	}

	@Around(value = "requestMappingInvocation()")
	public Object aroundRequestMapping(ProceedingJoinPoint joinPoint)
			throws Throwable {

		MethodSignature methodSignature = (MethodSignature) joinPoint
				.getSignature();
		Method method = methodSignature.getMethod();

		/*
		 * Annotation[] annotationList = method.getAnnotations(); for(Annotation
		 * anno:annotationList){
		 * System.out.println(ResponseBody.class.isInstance(anno)); }
		 */
		Annotation[][] argAnnotations = method.getParameterAnnotations();
		String[] argNames = methodSignature.getParameterNames();
		Object[] args = joinPoint.getArgs();

		for (int i = 0; i < args.length; i++) {
			if (hasRequestBodyAndValidAnnotations(argAnnotations[i])) {
				Object ret = validateArg(args[i], argNames[i]);
				if (ret != null) {
					return ret;
				}
			}
		}

		return joinPoint.proceed(args);
	}

	/**
	 * 判断参数是否需校验
	 * 
	 * @param annotations
	 * @return
	 */
	private boolean hasRequestBodyAndValidAnnotations(Annotation[] annotations) {

		for (Annotation annotation : annotations) {
			if (ParamValid.class.isInstance(annotation)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 参数校验
	 * 
	 * @param arg
	 * @param argName
	 * @return
	 */
	private Map<String, Object> validateArg(Object arg, String argName) {
		BindingResult result = getBindingResult(arg, argName);
		validate(arg, result, argName);
		Map<String, Object> returnMap = new HashMap<String, Object>();

		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			StringBuilder sbError = new StringBuilder();
			sbError.append("\n格式不正确:\n");
			for (FieldError error : errors) {
				sbError.append("Field: " + error.getObjectName() + "."
						+ error.getField() + " ErrorMessage:"
						+ error.getDefaultMessage() + "\n");
			}
			returnMap.put("status", "503");
			returnMap.put("message", sbError.toString());
			return returnMap;
		}
		return null;
	}

	/**
	 * 递归校验
	 * 
	 * @param paramObject
	 * @param paramErrors
	 */
	private void validate(Object paramObject, BindingResult paramErrors,
			String argName) {
		BindingResult tempBindingResult = getBindingResult(paramObject, argName);
		validator.validate(paramObject, tempBindingResult);
		addErrors(paramErrors, tempBindingResult);
		tempBindingResult = null;
		List<Object> objects = getNonBaseTypeObject(paramObject);
		if (objects != null) {
			for (Object object : objects) {
				String objectName = object.getClass().getName();
				validate(
						object,
						paramErrors,
						argName
								+ objectName.substring(objectName
										.lastIndexOf(".")));
			}
		} else {
			return;
		}
	}

	private BindingResult getBindingResult(Object target, String targetName) {
		return new BeanPropertyBindingResult(target, targetName);
	}

	/**
	 * 添加错误校验
	 * @param bindingResult
	 * @param tempBindingResult
	 */
	private void addErrors(BindingResult bindingResult,
			BindingResult tempBindingResult) {

		if (tempBindingResult.hasErrors()) {
			List<FieldError> errors = tempBindingResult.getFieldErrors();
			for (FieldError error : errors) {

				bindingResult.addError(error);
			}
		}
	}

	/**
	 * 获取非基础类型对象
	 * 
	 * @param paramObject
	 * @return
	 */
	private List<Object> getNonBaseTypeObject(Object paramObject) {
		List<Object> retObjects = new ArrayList<Object>();
		Field[] fields = paramObject.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object o = getFieldValueByName(field.getName(), paramObject);
			if (o != null && !isBaseDataType(o)) {
				retObjects.add(o);
			}
		}
		return retObjects;
	}

	/**
	 * @param fieldName
	 * @param o
	 * @return
	 */
	private Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 判断是不是基础类型
	 * 
	 * @param o
	 * @return
	 */
	private boolean isBaseDataType(Object o) {
		return (o instanceof String || o instanceof Integer
				|| o instanceof Byte || o instanceof Long
				|| o instanceof Double || o instanceof Float
				|| o instanceof Character || o instanceof Short
				|| o instanceof BigDecimal || o instanceof BigInteger
				|| o instanceof Boolean || o instanceof Date);
	}
}